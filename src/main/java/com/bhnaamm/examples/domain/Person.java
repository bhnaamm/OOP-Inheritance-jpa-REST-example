package com.bhnaamm.examples.domain;

import javax.persistence.*;

@Entity(name = "person")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "address")
    private String address;

    //etc
}
