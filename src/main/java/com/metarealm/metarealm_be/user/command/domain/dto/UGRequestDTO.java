package com.metarealm.metarealm_be.user.command.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UGRequestDTO {

    private String groupName;

    @Override
    public String toString() {
        return "UGRequestDTO{" +
                '}';
    }

}
