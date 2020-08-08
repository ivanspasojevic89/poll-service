package com.someco.pollservice.util;

import com.someco.pollservice.dto.PollSummary;
import com.someco.pollservice.model.Poll;

import java.util.List;
import java.util.stream.Collectors;

public class PollSummaryAssembler {

    public static List<PollSummary> convert(List<Poll> polls) {
        return polls.stream()
                .map(PollSummary::new)
                .collect(Collectors.toList());
    }
}
