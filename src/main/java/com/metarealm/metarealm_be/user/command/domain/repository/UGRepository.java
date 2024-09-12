package com.metarealm.metarealm_be.user.command.domain.repository;


import com.metarealm.metarealm_be.user.command.domain.aggregate.UserGroup;
import com.metarealm.metarealm_be.user.command.domain.aggregate.UserGroupId;
import com.metarealm.metarealm_be.user.command.domain.dto.GroupFindByIdResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UGRepository extends JpaRepository<UserGroup, UserGroupId> {


    @Query("SELECT new com.metarealm.metarealm_be.user.command.domain.dto.GroupFindByIdResponseDTO(g.groupName, g.groupReader) " +
            "FROM UserGroup ug " +
            "JOIN Group g ON ug.id.groupId = g.groupId " +
            "WHERE ug.id.userId = :userId")
    List<GroupFindByIdResponseDTO> findByUserId(@Param("userId") Long userId);

}
