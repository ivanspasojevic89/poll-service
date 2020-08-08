package com.someco.pollservice.service.impl;

import com.someco.pollservice.api.request.FindAllPollsRequest;
import com.someco.pollservice.api.request.FindPollsRequest;
import com.someco.pollservice.model.Poll;
import com.someco.pollservice.repository.PollRepository;
import com.someco.pollservice.service.PollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PollServiceImpl implements PollService {

    @Value("${max.poll.limit}")
    private Integer maxPollLimit;

    private final PollRepository pollRepository;

    @Autowired
    public PollServiceImpl(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Override
    public List<Poll> findAllUserPolls(FindAllPollsRequest findAllPollsRequest) {
        return pollRepository.getUserPolls(findAllPollsRequest.getUserID(), checkAndFindLimit(findAllPollsRequest.getLimit()), findAllPollsRequest.getOffset());
    }


    @Override
    public List<Poll> findPolls(FindPollsRequest findPollsRequest) {
        findPollsRequest.setLimit(checkAndFindLimit(findPollsRequest.getLimit()));
        return pollRepository.getUserPollsByCriteria(findPollsRequest);
    }

    @Override
    public Optional<Poll> findByID(Long pollID) {
        return pollRepository.findById(pollID);
    }

    private Integer checkAndFindLimit(int limit) {
        return (limit < 0 || limit > maxPollLimit) ? maxPollLimit : limit;
    }

}
