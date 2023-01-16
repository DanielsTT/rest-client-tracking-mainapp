package com.example.restclienttrackingmainapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Column(name = COLUMN_PREFIX + "name", nullable = false)
    private String name;

    @Column(name = COLUMN_PREFIX + "email", nullable = false)
    private String email;

    @Column(name = COLUMN_PREFIX + "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = User.TABLE_NAME + "_" + Role.TABLE_NAME,
            joinColumns = @JoinColumn(name = User.COLUMN_PREFIX + "id"),
            inverseJoinColumns = @JoinColumn(name = Role.COLUMN_PREFIX + "id")
    )
    private List<Role> roles = new ArrayList<>();

}
