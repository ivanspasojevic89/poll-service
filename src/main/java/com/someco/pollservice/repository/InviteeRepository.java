package com.someco.pollservice.repository;

import com.someco.pollservice.model.Invitee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InviteeRepository extends CrudRepository<Invitee, Long> {
}
