package com.someco.pollservice.dto;

import com.someco.pollservice.model.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionDetails {

    private Long id;
    private String text;
    private Boolean active;
    private Date startDate;
    private Date endDate;

    public OptionDetails(Option option) {
        this.id = option.getId();
        this.text = option.getText();
        this.active = option.getActive();
        this.startDate = option.getStartDate();
        this.endDate = option.getEndDate();
    }
}
