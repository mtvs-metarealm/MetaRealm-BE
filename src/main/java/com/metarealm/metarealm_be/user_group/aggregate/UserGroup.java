package com.metarealm.metarealm_be.user_group.aggregate;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_user_group")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userGroupId;
    private Long userNo;
    private Long groupId;
    private int isInGroup;

    public UserGroup() {}

    public UserGroup(Long userNo, Long groupId, int isInGroup) {
        this.userNo = userNo;
        this.groupId = groupId;
        this.isInGroup = isInGroup;
    }

    public Long getUserGroupId() {
        return userGroupId;
    }

    public Long getUserNo() {
        return userNo;
    }

    public Long getGroupId() {
        return groupId;
    }

    public int getIsInGroup() {
        return isInGroup;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "userGroupId=" + userGroupId +
                ", userNo=" + userNo +
                ", groupId=" + groupId +
                ", isInGroup=" + isInGroup +
                '}';
    }

    //엔티티로 변환
    public void toEntity(Long userNo, Long id, int isInGroup) {
        this.userNo = userNo;
        this.groupId = id;
        this.isInGroup = isInGroup;
    }


    public void fromDTO(Long userNo, Long groupId, int i) {
        this.userNo = userNo;
        this.groupId = groupId;
        this.isInGroup = i;
    }
}
