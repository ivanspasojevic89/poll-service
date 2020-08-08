package com.someco.pollservice.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.someco.pollservice.dto.PollDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PollDetailsResponse {
    private PollDetails poll;
}
