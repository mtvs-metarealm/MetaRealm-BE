package com.metarealm.metarealm_be.user.command.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupFindByIdResponseDTO {

    private String groupName;
    private Long groupReader;

    public GroupFindByIdResponseDTO(String groupName) {
        this.groupName = groupName;
    }
    @Override
    public String toString() {
        return "GroupFindByIdResponseDTO{" +
                "groupName='" + groupName + '\'' +
                ", groupReader=" + groupReader +
                '}';
    }
}
