package com.metarealm.metarealm_be.user.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "tbl_group")
@Getter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String groupName;
    private Long groupReader;

    public Group() {}

    public Group(String groupName, Long groupReader) {
        this.groupName = groupName;
        this.groupReader = groupReader;
    }
}
