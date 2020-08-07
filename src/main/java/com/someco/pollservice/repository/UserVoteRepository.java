package com.someco.pollservice.repository;

import com.someco.pollservice.model.UserVote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVoteRepository extends CrudRepository<UserVote, Long> {
}
