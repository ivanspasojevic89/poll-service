package com.someco.pollservice.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindPollsRequest {
    private String name;
    private Date dateFrom;
    private Long userID;
}
