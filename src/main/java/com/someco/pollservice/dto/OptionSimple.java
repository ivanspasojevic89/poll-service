package com.someco.pollservice.dto;

import com.someco.pollservice.model.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionSimple {

    private String text;
    private Boolean active;

    public OptionSimple(Option option) {
        this.text = option.getText();
        this.active = option.getActive();
    }
}
