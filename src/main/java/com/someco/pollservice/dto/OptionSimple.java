package com.someco.pollservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.someco.pollservice.model.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class OptionSimple {

    private String text;
    private Boolean active;

    public OptionSimple(Option option) {
        this.text = option.getText();
        this.active = option.getActive();
    }
}
