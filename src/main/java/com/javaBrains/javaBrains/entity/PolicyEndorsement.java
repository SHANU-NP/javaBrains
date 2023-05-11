package com.javaBrains.javaBrains.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "policy_endorsement")
public class PolicyEndorsement extends Policy{

    @Enumerated(EnumType.STRING)
    private FlowType flowType;

    public PolicyEndorsement() {
        this.flowType = FlowType.ENDORSEMENT;
    }
}
