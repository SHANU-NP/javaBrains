package com.javaBrains.javaBrains.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoreKafKaMessage implements Serializable {


    private String type;
    private User userCreateRequest;
}
