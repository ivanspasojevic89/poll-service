package com.someco.pollservice.repository.impl;

import com.someco.pollservice.api.request.FindPollsRequest;
import com.someco.pollservice.model.Poll;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class PollRepositoryImpl implements PollRepositoryFacade {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Poll> getUserPolls(Long userID, Integer limit, Integer offset) {
        String hql = "select p, u from Poll p inner join User u on (p.createdBy.id = u.id) where p.createdBy.id = :userID order by p.id asc";
        Query query = entityManager.createQuery(hql);

        query.setParameter("userID", userID);
        query.setMaxResults(limit);
        query.setFirstResult((offset - 1) * limit);
        return query.getResultList();
    }

    @Override
    public List<Poll> getUserPollsByCriteria(FindPollsRequest findPollsRequest) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Poll> criteriaQuery = criteriaBuilder.createQuery(Poll.class);
        Root<Poll> root = criteriaQuery.from(Poll.class);

        List<Predicate> predicateList = getPredicateList(findPollsRequest, criteriaBuilder, root);
        criteriaQuery.where(predicateList.toArray(new Predicate[0]));


        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));


        TypedQuery<Poll> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult((findPollsRequest.getOffset() - 1) * findPollsRequest.getLimit());
        typedQuery.setMaxResults(findPollsRequest.getLimit());
        return typedQuery.getResultList();
    }

    private List<Predicate> getPredicateList(FindPollsRequest findPollsRequest, CriteriaBuilder criteriaBuilder, Root<Poll> root) {
        List<Predicate> predicateList = new ArrayList<>();
        if (findPollsRequest.getName() != null) {
            predicateList.add(criteriaBuilder.like(root.get("title"), "%" + findPollsRequest.getName() + "%"));
        }
        if (findPollsRequest.getDateFrom() != null) {
            predicateList.add(criteriaBuilder.greaterThan(root.get("created"), findPollsRequest.getDateFrom()));
        }
        return predicateList;
    }

}
