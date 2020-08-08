package com.someco.pollservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.someco.pollservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String email;
    private Boolean notificationEnabled;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.notificationEnabled = user.getNotificationEnabled();
    }
}
