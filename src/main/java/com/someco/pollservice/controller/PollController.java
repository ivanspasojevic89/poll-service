package com.someco.pollservice.controller;

import com.someco.pollservice.api.request.FindAllPollsRequest;
import com.someco.pollservice.api.request.FindPollsRequest;
import com.someco.pollservice.api.request.PollDetailsRequest;
import com.someco.pollservice.api.response.FindPollsResponse;
import com.someco.pollservice.api.response.PollDetailsResponse;
import com.someco.pollservice.dto.OptionDetails;
import com.someco.pollservice.dto.PollDetails;
import com.someco.pollservice.model.Option;
import com.someco.pollservice.model.Poll;
import com.someco.pollservice.model.UserVote;
import com.someco.pollservice.service.OptionService;
import com.someco.pollservice.service.PollService;
import com.someco.pollservice.service.UserVoteService;
import com.someco.pollservice.util.PollDetailAssembler;
import com.someco.pollservice.util.PollSummaryAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/v1/poll")
@Slf4j
public class PollController {

    @Autowired
    private PollService pollService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private UserVoteService userVoteService;

    @RequestMapping(method = RequestMethod.POST, path = "/findAllUserPolls")
    public ResponseEntity<FindPollsResponse> findAllUserPolls(@RequestBody FindAllPollsRequest findAllPollsRequest) {
        List<Poll> polls = pollService.findAllUserPolls(findAllPollsRequest);
        FindPollsResponse response = new FindPollsResponse();
        response.setPolls(PollSummaryAssembler.convert(polls));
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/findPolls")
    public ResponseEntity<FindPollsResponse> findPolls(@RequestBody FindPollsRequest findPollsRequest) {
        List<Poll> polls = pollService.findPolls(findPollsRequest);
        FindPollsResponse response = new FindPollsResponse();
        response.setPolls(PollSummaryAssembler.convert(polls));
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/getPollDetails")
    public ResponseEntity<PollDetailsResponse> getPollDetails(@RequestBody PollDetailsRequest pollDetailsRequest) {
        PollDetailsResponse response = new PollDetailsResponse();
        Optional<Poll> poll = pollService.findByID(pollDetailsRequest.getPollID());
        if (poll.isPresent()) {
            List<Option> options = optionService.findByPollID(poll.get().getId());
            List<UserVote> userVotes = userVoteService.findByPollID(poll.get().getId());

            PollDetails pollDetails = new PollDetails(poll.get());
            pollDetails.setOptions(options.stream().map(OptionDetails::new).collect(Collectors.toList()));
            PollDetailAssembler.addUserVotes(pollDetails, userVotes);
            response.setPoll(pollDetails);
        }

        return ResponseEntity.ok(response);
    }


}
