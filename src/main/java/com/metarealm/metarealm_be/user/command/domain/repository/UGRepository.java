package com.metarealm.metarealm_be.user.command.domain.repository;


import com.metarealm.metarealm_be.user.command.domain.aggregate.UserGroup;
import com.metarealm.metarealm_be.user.command.domain.aggregate.UserGroupId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UGRepository extends JpaRepository<UserGroup, UserGroupId> {
}
