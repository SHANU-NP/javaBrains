package com.lacon.workflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

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
