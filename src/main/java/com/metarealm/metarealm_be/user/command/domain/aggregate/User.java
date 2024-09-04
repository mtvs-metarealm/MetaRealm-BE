package com.metarealm.metarealm_be.user.command.domain.aggregate;


import com.metarealm.metarealm_be.user.command.domain.dto.UserRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "tbl_user")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userPass;

    public User() {}

    public User(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    //변환
    public UserRequestDTO toEntity(User user) {
        return new UserRequestDTO(
                this.userName = user.getUserName(),
                this.userPass = user.getUserPass()
        );
    }
}
