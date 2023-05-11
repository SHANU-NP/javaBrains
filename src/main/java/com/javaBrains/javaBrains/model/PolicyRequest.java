package com.javaBrains.javaBrains.model;

import com.javaBrains.javaBrains.entity.Policy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PolicyRequest {

    private Policy.FlowType flowType;
    private String comment;
}
