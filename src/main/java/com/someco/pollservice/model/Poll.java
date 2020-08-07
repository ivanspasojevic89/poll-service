package com.someco.pollservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "poll")
@Entity(name = "Poll")
public class Poll {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "poll_generator")
    @SequenceGenerator(name = "poll_generator", sequenceName = "poll_seq", allocationSize = 1)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private String type;
    @Column(name = "state")
    private String state;
    @Column(name = "locale")
    private String locale;
    @ManyToOne
    @JoinColumn(name = "created_user_id", nullable = false)
    private User createdBy;
    @CreationTimestamp
    @Column(name = "created")
    private Date created;
    @UpdateTimestamp
    @Column(name = "modified")
    private Date modified;
    @Column(name = "preferences_type")
    private String preferencesType;
    @Column(name = "device")
    private String device;
    @Column(name = "level")
    private String level;


}
