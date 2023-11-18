package com.javaBrains.javaBrains.entity.school;

import com.javaBrains.javaBrains.entity.DBTimeStamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student extends DBTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long admissionNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private String dob;

    @Column(name = "address",columnDefinition = "text")
    private String address;

    @Column(name = "contact_number")
    private Integer contactNumber;




}
