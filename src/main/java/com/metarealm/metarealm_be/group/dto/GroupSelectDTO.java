package com.metarealm.metarealm_be.group.dto;

public class GroupSelectDTO {

    private Long userNo;
    private String groupName;

    public GroupSelectDTO() {}

    public GroupSelectDTO(Long userNo, String groupName) {
        this.userNo = userNo;
        this.groupName = groupName;
    }

    public Long getUserNo() {
        return userNo;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "GroupSelectDTO{" +
                "userNo=" + userNo +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
