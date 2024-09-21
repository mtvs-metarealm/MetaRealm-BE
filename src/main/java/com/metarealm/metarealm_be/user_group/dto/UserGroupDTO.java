package com.metarealm.metarealm_be.user_group.dto;

public class UserGroupDTO {

    private Long userNo;
    private Long groupId;
    private int isInGroup;

    public UserGroupDTO() {}

    public UserGroupDTO(Long userNo, Long groupId, int isInGroup) {
        this.userNo = userNo;
        this.groupId = groupId;
        this.isInGroup = isInGroup;
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
        return "UserGroupDTO{" +
                "userNo=" + userNo +
                ", groupId=" + groupId +
                ", isInGroup=" + isInGroup +
                '}';
    }
}
