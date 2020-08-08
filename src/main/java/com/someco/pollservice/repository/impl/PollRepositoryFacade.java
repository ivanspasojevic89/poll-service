package com.someco.pollservice.repository.impl;

import com.someco.pollservice.api.request.FindPollsRequest;
import com.someco.pollservice.model.Poll;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepositoryFacade {

    List<Poll> getUserPolls(Long userID, Integer limit, Integer offset);

    List<Poll> getUserPollsByCriteria(FindPollsRequest findPollsRequest);
}
