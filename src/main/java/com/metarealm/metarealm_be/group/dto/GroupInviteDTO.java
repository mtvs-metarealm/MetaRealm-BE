package com.metarealm.metarealm_be.group.dto;

public class GroupInviteDTO {

    private Long userNo;
    private Long groupId;
    private int isGroupActive;

    public GroupInviteDTO() {}

    public GroupInviteDTO(Long userNo, Long groupId, int isGroupActive) {
        this.userNo = userNo;
        this.groupId = groupId;
        this.isGroupActive = isGroupActive;
    }

    public Long getUserNo() {
        return userNo;
    }

    public Long getGroupId() {
        return groupId;
    }

    public int getIsGroupActive() {
        return isGroupActive;
    }

    @Override
    public String toString() {
        return "GroupInviteDTO{" +
                "userNo=" + userNo +
                ", groupId=" + groupId +
                ", isGroupActive=" + isGroupActive +
                '}';
    }
}
