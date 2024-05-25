package com.lacon.workflow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
public class User extends DBTimeStamp{
    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    private Long id;

    @Setter
    @Getter
    @Column(name = "user_id")
    private UUID userId;

    @Setter
    @Getter
    @Column(name = "first_name")
    private String firstName;

    @Setter
    @Getter
    @Column(name = "last_name")
    private String lastName;

    @Setter
    @Getter
    @Column(name = "phone")
    private String phone;

    @Setter
    @Getter
    @Column(name = "password")
    private String password;

    @Setter
    @Getter
    @Column(name = "role")
    private String role;

}
