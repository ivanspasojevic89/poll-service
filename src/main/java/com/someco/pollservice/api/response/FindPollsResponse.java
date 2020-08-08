package com.someco.pollservice.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.someco.pollservice.dto.PollSummary;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FindPollsResponse {
    private List<PollSummary> polls;
}
