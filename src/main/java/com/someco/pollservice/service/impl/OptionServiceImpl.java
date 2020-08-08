package com.someco.pollservice.service.impl;

import com.someco.pollservice.model.Option;
import com.someco.pollservice.repository.OptionRepository;
import com.someco.pollservice.service.OptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public List<Option> findByPollID(Long pollID) {
        return optionRepository.findByPollID(pollID);
    }
}
