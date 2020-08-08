package com.someco.pollservice.repository;

import com.someco.pollservice.api.request.FindPollsRequest;
import com.someco.pollservice.model.Option;
import com.someco.pollservice.model.Poll;
import com.someco.pollservice.model.User;
import com.someco.pollservice.model.UserVote;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PollServiceRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private UserVoteRepository userVoteRepository;


    private String email;

    @BeforeEach
    void setup() {
        email = "test3@someco.com";
    }


    @Test
    void populateData() {

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

    @Test
    void testGetUserPolls() {
        Optional<User> userOptional = userRepository.findFirstByEmail(email);
        assert userOptional.isPresent();
        List<Poll> pollList = pollRepository.getUserPolls(userOptional.get().getId(), 10, 1);
        assert !pollList.isEmpty();

    }


    @Test
    void testGetUserByCriteriaPolls() {
        Optional<User> userOptional = userRepository.findFirstByEmail(email);
        assert userOptional.isPresent();
        FindPollsRequest findPollsRequest = new FindPollsRequest();
        findPollsRequest.setLimit(10);
        findPollsRequest.setOffset(1);
        findPollsRequest.setName("tle");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -10);
        findPollsRequest.setDateFrom(cal.getTime());
        List<Poll> pollList = pollRepository.getUserPollsByCriteria(findPollsRequest);
        assert (!pollList.isEmpty());

    }

}
