package com.lacon.workflow.model.response;

import com.lacon.workflow.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String userId;
    private String firstName;
    private String lastName;
    private String role;
    private String phone;


    public UserResponse(User user) {
        this.userId = user.getUserId().toString();
        this.firstName = user.getFirstName();
        this.lastName = userId.toLowerCase();
        this.role = user.getRole();
        this.phone = user.getPhone();
    }
}
