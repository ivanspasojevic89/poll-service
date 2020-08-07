package com.someco.pollservice.dto;

import com.someco.pollservice.model.Poll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollDetails {

    private Long id;
    private String title;
    private String description;
    private String type;
    private String state;
    private String locale;
    private UserDTO createdBy;
    private Date created;
    private Date modified;
    private String preferencesType;
    private String device;
    private String level;

    private List<OptionDetails> options;
    private List<InviteeDTO> invitees;
    private List<UserVoteDTO> preferences;

    public PollDetails(Poll poll) {
        this.id = poll.getId();
        this.title = poll.getTitle();
        this.description = poll.getDescription();
        this.type = poll.getType();
        this.state = poll.getState();
        this.locale = poll.getLocale();
        this.createdBy = new UserDTO(poll.getCreatedBy());
        this.preferencesType = poll.getPreferencesType();
        this.device = poll.getDevice();
        this.level = poll.getLevel();
        this.created = poll.getCreated();
        this.modified = poll.getModified();
    }


}
