package com.someco.pollservice.service.impl;

import com.someco.pollservice.model.UserVote;
import com.someco.pollservice.repository.UserVoteRepository;
import com.someco.pollservice.service.UserVoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserVoteServiceImpl implements UserVoteService {

    private final UserVoteRepository userVoteRepository;

    @Autowired
    public UserVoteServiceImpl(UserVoteRepository userVoteRepository) {
        this.userVoteRepository = userVoteRepository;
    }

    @Override
    public List<UserVote> findByPollID(Long pollID) {
        return userVoteRepository.findByPollID(pollID);
    }
}
