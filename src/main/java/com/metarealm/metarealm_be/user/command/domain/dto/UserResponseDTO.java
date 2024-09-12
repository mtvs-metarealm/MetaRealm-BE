package com.metarealm.metarealm_be.user.command.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponseDTO {

    private Long userId;
    private String userName;
    private String userPass;

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
