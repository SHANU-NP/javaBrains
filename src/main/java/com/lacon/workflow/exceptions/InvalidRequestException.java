package com.lacon.workflow.exceptions;

import jakarta.ws.rs.BadRequestException;

import java.io.Serial;

public class InvalidRequestException extends BadRequestException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidRequestException(String message) {
        super(message);
    }
}
