package com.someco.pollservice.util;

import com.someco.pollservice.dto.OptionSimple;
import com.someco.pollservice.dto.PollDetails;
import com.someco.pollservice.dto.UserDTO;
import com.someco.pollservice.dto.UserVoteDTO;
import com.someco.pollservice.model.UserVote;

import java.util.*;

public class PollDetailAssembler {


    public static void addUserVotes(PollDetails pollDetails, List<UserVote> userVotes) {

        Map<Long, UserVoteDTO> userVoteMaps = new HashMap<>();
        for (UserVote uv : userVotes) {
            Long userID = uv.getUserID().getId();
            OptionSimple optionSimple = new OptionSimple(uv.getOption());
            if (!userVoteMaps.containsKey(userID)) {
                userVoteMaps.put(userID, new UserVoteDTO(new UserDTO(uv.getUserID()), Arrays.asList(optionSimple)));
            } else {
                userVoteMaps.get(userID).getOptions().add(optionSimple);
            }
        }

        pollDetails.setPreferences(new ArrayList<>(userVoteMaps.values()));
    }

}
