package net.javaguides.springboot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;
}
