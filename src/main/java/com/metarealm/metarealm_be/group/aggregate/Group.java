package com.metarealm.metarealm_be.group.aggregate;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String groupName;
    private int isGroupActive;

    public Group() {}

    public Group(String groupName, int isGroupActive) {
        this.groupName = groupName;
        this.isGroupActive = isGroupActive;
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
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", isGroupActive=" + isGroupActive +
                '}';
    }

    //엔티티로 변환
    public void toEntity(String groupName, int isGroupActive) {
        this.groupName = groupName;
        this.isGroupActive = isGroupActive;
    }
}
