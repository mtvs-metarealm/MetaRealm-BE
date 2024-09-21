package com.metarealm.metarealm_be.group.dto;

public class GroupRequestDTO {

    private Long userNo;
    private Long groupId;
    private String groupName;
    private int isGroupActive;

    public GroupRequestDTO() {}

    public GroupRequestDTO(Long userNo, Long groupId, String groupName, int isGroupActive) {
        this.userNo = userNo;
        this.groupId = groupId;
        this.groupName = groupName;
        this.isGroupActive = isGroupActive;
    }

    public Long getUserNo() {
        return userNo;
    }

    public Long getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getIsGroupActive() {
        return isGroupActive;
    }

    @Override
    public String toString() {
        return "GroupRequestDTO{" +
                "userNo=" + userNo +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", isGroupActive=" + isGroupActive +
                '}';
    }
}
