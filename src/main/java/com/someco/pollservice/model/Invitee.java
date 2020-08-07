package com.someco.pollservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invitee")
@Entity(name = "Invitee")
public class Invitee {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invitee_generator")
    @SequenceGenerator(name = "invitee_generator", sequenceName = "invitee_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "invited_user_id", nullable = false)
    private User invitedUser;
    @Column(name = "poll_id")
    private Long pollID;
    @CreationTimestamp
    @Column(name = "created")
    private Date created;
}
