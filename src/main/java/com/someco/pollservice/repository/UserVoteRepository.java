package com.someco.pollservice.repository;

import com.someco.pollservice.model.UserVote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserVoteRepository extends CrudRepository<UserVote, Long> {
    @Query("select uv from UserVote  uv where uv.pollID = :pollID")
    List<UserVote> findByPollID(@Param("pollID") Long pollID);
}
