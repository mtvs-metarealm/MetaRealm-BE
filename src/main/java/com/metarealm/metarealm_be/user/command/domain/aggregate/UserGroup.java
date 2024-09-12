package com.metarealm.metarealm_be.user.command.domain.aggregate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "tbl_user_group")
@Getter
public class UserGroup {

    @EmbeddedId
    private UserGroupId id;

    public UserGroup() {}

    public UserGroup(UserGroupId id) {
        this.id = id;
    }


}
