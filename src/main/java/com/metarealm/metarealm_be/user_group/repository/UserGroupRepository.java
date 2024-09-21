package com.metarealm.metarealm_be.user_group.repository;

import com.metarealm.metarealm_be.group.aggregate.Group;
import com.metarealm.metarealm_be.user_group.aggregate.UserGroup;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

    @Query("SELECT g FROM Group g JOIN UserGroup ug ON g.groupId = ug.groupId WHERE ug.userNo = :userNo AND g.isGroupActive = 1")
    List<Group> findActiveGroupsByUserNo(@Param("userNo") Long userNo);
}
