package com.someco.pollservice;

import com.someco.pollservice.model.Option;
import com.someco.pollservice.model.Poll;
import com.someco.pollservice.model.User;
import com.someco.pollservice.model.UserVote;
import com.someco.pollservice.repository.OptionRepository;
import com.someco.pollservice.repository.PollRepository;
import com.someco.pollservice.repository.UserRepository;
import com.someco.pollservice.repository.UserVoteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class PollServiceApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private UserVoteRepository userVoteRepository;


    @Test
    void populateData() {

        String email = "test@someco.com";

        Optional<User> userOptional = userRepository.findFirstByEmail(email);

        if (!userOptional.isPresent()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword("NewPasswod"); //TODO bcript
            user.setName("Test User");
            user.setNotificationEnabled(true);

            userRepository.save(user);

            Poll poll = new Poll();
            poll.setCreatedBy(user);
            poll.setTitle("Title");

            pollRepository.save(poll);

            Option option = new Option();
            option.setPollID(poll.getId());
            option.setText("firstOption");
            option.setActive(true);
            optionRepository.save(option);

            Option secondOption = new Option();
            secondOption.setPollID(poll.getId());
            secondOption.setText("secondOption");
            secondOption.setActive(true);
            optionRepository.save(secondOption);

            UserVote vote = new UserVote();
            vote.setOption(option);
            vote.setPollID(poll.getId());
            vote.setUserID(user);

            userVoteRepository.save(vote);
        }


    }

}
