package com.someco.pollservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.someco.pollservice.model.Poll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PollSummary {

    private Long id;
    private String title;
    private String description;
    private String type;
    private String state;
    private String locale;
    private Date created;
    private Date modified;
    private String preferencesType;
    private UserDTO createdBy;
    private String device;
    private String level;

    public PollSummary(Poll poll) {
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
