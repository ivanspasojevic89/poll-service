package com.someco.pollservice.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FindPollsRequest {
    private String name;
    private Date dateFrom;
    private Long userID;
    private Integer limit;
    private Integer offset;
}
