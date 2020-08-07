package com.someco.pollservice.api.response;

import com.someco.pollservice.dto.PollDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollDetailsResponse {
    private PollDetails poll;
}
