package com.metarealm.metarealm_be.group.repository;

import com.metarealm.metarealm_be.group.aggregate.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Long findByGroupId(Group group);
}
