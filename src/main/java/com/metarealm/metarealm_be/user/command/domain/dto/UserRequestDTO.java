package com.metarealm.metarealm_be.user.command.domain.dto;


import com.metarealm.metarealm_be.user.command.domain.aggregate.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequestDTO {

    private String userName;
    private String userPass;

    public User toEntity() {
        return new User(
                this.userName,
                this.userPass
        );
    }

    @Override
    public String toString() {
        return "UserRequestDTO{" +
                "userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }

}
