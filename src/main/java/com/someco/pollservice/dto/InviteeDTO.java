package com.someco.pollservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.someco.pollservice.model.Invitee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InviteeDTO {

    private UserDTO invitedUser;
    private Date created;

    public InviteeDTO(Invitee invitee) {
        this.invitedUser = new UserDTO(invitee.getInvitedUser());
        this.created = invitee.getCreated();
    }
}
