package com.someco.pollservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_vote")
@Entity(name = "UserVote")
public class UserVote {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_vote_generator")
    @SequenceGenerator(name = "user_vote_generator", sequenceName = "user_vote_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userID;
    @Column(name = "poll_id")
    private Long pollID;
    @ManyToOne
    @JoinColumn(name = "option_id", nullable = false)
    private Option option;
    @CreationTimestamp
    @Column(name = "created")
    private Date created;
}
