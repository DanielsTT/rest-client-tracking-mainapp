package com.example.restclienttrackingmainapp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = Visitor.TABLE_NAME)
public class Visitor {

    public static final String TABLE_NAME = "visitors";
    public static final String COLUMN_PREFIX = "v_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_PREFIX + "id", nullable = false)
    private Long id;

    @Column(name = COLUMN_PREFIX + "ip_address", nullable = false)
    private String ipAddress;

    @Column(name = COLUMN_PREFIX + "method", nullable = false)
    private String method;

    @Column(name = COLUMN_PREFIX + "request", nullable = false)
    private String request;

    @Column(name = COLUMN_PREFIX + "logged_time", nullable = false)
    private LocalDateTime loggedTime;

}
