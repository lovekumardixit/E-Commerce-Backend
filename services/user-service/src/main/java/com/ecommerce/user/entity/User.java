package com.ecommerce.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users", indexes = @Index(name = "idx_email", columnList = "email", unique = true))
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
}
