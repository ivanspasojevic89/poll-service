package com.someco.pollservice.controller;

import com.someco.pollservice.api.request.FindAllPollsRequest;
import com.someco.pollservice.api.request.FindPollsRequest;
import com.someco.pollservice.api.request.PollDetailsRequest;
import com.someco.pollservice.api.response.PollDetailsResponse;
import com.someco.pollservice.api.response.FindPollsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/poll")
@Slf4j
public class ClientController {

    @RequestMapping(method = RequestMethod.POST, path = "/findAll")
    public FindPollsResponse findAllPolls(@RequestBody FindAllPollsRequest findAllPollsRequest){

        return null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/findPolls")
    public FindPollsResponse findPolls(@RequestBody FindPollsRequest findPollsRequest){

        return null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/getPollDetails")
    public PollDetailsResponse getPollDetails(@RequestBody PollDetailsRequest pollDetailsRequest){

        return null;
    }


}
