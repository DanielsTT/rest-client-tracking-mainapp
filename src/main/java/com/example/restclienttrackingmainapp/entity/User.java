package com.example.restclienttrackingmainapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = User.TABLE_NAME)
public class User {

    public static final String TABLE_NAME = "users";
    public static final String COLUMN_PREFIX = "u_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_PREFIX + "id", nullable = false)
    private Long id;

    @Column(name = COLUMN_PREFIX + "first_name", nullable = false)
    private String firstName;

    @Column(name = COLUMN_PREFIX + "last_name", nullable = false)
    private String lastName;

    @Column(name = COLUMN_PREFIX + "email", nullable = false)
    private String email;

    @Column(name = COLUMN_PREFIX + "password", nullable = false)
    private String password;

    @Column(name = COLUMN_PREFIX + "phone", nullable = false)
    private String phone;

}
