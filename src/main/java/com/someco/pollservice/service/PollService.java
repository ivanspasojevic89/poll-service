package com.someco.pollservice.service;

import com.someco.pollservice.api.request.FindAllPollsRequest;
import com.someco.pollservice.api.request.FindPollsRequest;
import com.someco.pollservice.model.Poll;

import java.util.List;
import java.util.Optional;

public interface PollService {
    List<Poll> findAllUserPolls(FindAllPollsRequest findAllPollsRequest);

    List<Poll> findPolls(FindPollsRequest findPollsRequest);

    Optional<Poll> findByID(Long pollID);
}
