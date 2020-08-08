package com.someco.pollservice.service;

import com.someco.pollservice.model.UserVote;

import java.util.List;

public interface UserVoteService {
    List<UserVote> findByPollID(Long id);
}
