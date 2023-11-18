package com.javaBrains.javaBrains.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegisterRequest {

    private String firstName;
    private String lastName;
    private String dob;
    private Integer batch;
    private Integer contactNumber;
    private String Address;

}
