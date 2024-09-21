package com.metarealm.metarealm_be.security.user.entity;

import com.metarealm.metarealm_be.security.common.OhgiraffersRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TBL_USER")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @Column(name = "USER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNo;

    @Column(name = "USER_ID", unique = true)
    @NotBlank
    private String userId;

    @Column(name = "USER_PASS")
    @NotBlank
    private String userPass;

    @Column(name = "USER_NAME")
    private String userName;

//    @Column(name = "USER_EMAIL")
//    private String userEmail;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "USER_ROLE")
    private OhgiraffersRole role;

    @Column(name = "USER_STATE")
    private String state;

    public List<String> getRoleList() {
        if (this.role.getRole().length() > 0) {
            return Arrays.asList(this.role.getRole().split(","));
        }
        return new ArrayList<>();
    }
}
