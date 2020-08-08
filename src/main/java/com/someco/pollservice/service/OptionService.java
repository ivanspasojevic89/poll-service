package com.someco.pollservice.service;

import com.someco.pollservice.model.Option;

import java.util.List;

public interface OptionService {
    List<Option> findByPollID(Long id);
}
