package com.someco.pollservice.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindAllPollsRequest {
    private Long userID;
    private int limit;
    private int offset;
}
