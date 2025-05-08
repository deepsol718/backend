package com.deepak.gcp.backend.entity;

import com.deepak.gcp.backend.helper.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="users")
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;


}
