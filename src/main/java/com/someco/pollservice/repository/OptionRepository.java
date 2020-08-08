package com.someco.pollservice.repository;

import com.someco.pollservice.model.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends CrudRepository<Option, Long> {
    @Query("select o from Option  o where o.pollID = :pollID")
    List<Option> findByPollID(@Param("pollID") Long pollID);
}
