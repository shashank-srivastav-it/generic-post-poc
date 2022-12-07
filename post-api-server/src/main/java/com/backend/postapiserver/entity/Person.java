package com.backend.postapiserver.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

}
