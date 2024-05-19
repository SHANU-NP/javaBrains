package com.lacon.workflow.model.response;

import com.lacon.workflow.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private String token;
    private String role;

    public LoginResponse(User user, String token) {
        this.role = user.getRole();
        this.token = token;
    }
}
