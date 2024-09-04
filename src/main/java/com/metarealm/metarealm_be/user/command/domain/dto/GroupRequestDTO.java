package com.metarealm.metarealm_be.user.command.domain.dto;

import com.metarealm.metarealm_be.user.command.domain.aggregate.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupRequestDTO {

    private String groupName;
    private Long groupReader;

    @Override
    public String toString() {
        return "GroupRequestDTO{" +
                "groupName='" + groupName + '\'' +
                ", groupReader=" + groupReader +
                '}';
    }

    //변환
    public Group toEntity(Long userId) {
        return new Group(
                this.groupName,
                this.groupReader = userId
        );
    }


}
