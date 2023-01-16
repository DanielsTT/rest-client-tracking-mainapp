package com.example.restclienttrackingmainapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = Role.TABLE_NAME)
public class Role {

    public static final String TABLE_NAME = "roles";
    public static final String COLUMN_PREFIX = "r_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_PREFIX + "id", nullable = false)
    private Long id;

    @Column(name = COLUMN_PREFIX + "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
