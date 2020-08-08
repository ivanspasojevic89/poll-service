package com.someco.pollservice.repository;

import com.someco.pollservice.model.Poll;
import com.someco.pollservice.repository.impl.PollRepositoryFacade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long>, PollRepositoryFacade {
}
