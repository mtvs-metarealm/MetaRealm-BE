package com.metarealm.metarealm_be.user.command.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GroupResponseDTO {

    private String groupName;
    private Long groupReader;

    @Override
    public String toString() {
        return "GroupResponseDTO{" +
                "groupName='" + groupName + '\'' +
                ", groupReader=" + groupReader +
                '}';
    }
}
