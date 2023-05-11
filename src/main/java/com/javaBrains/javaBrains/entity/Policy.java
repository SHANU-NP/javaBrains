package com.javaBrains.javaBrains.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@MappedSuperclass
public abstract class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public enum FlowType{
        PURCHASE("PURCHASE"),
        RENEWAL("RENEWAL"),
        ENDORSEMENT("ENDORSEMENT");

        private final String flowType;
        FlowType(String type) {
            this.flowType = type;
        }

        @Override
        public String toString() {
            return this.flowType;
        }
    }

    private String comment;
}
