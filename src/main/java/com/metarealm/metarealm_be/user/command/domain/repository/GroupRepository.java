package com.metarealm.metarealm_be.user.command.domain.repository;


import com.metarealm.metarealm_be.user.command.domain.aggregate.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
