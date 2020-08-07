package com.someco.pollservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVoteDTO {

    private UserDTO user;
    private List<OptionSimple> option;

}
