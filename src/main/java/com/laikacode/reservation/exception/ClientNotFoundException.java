package com.laikacode.reservation.exception;

/**
 * Client not found exception
 * @author Francisco
 * */
public class ClientNotFoundException extends RuntimeException{
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ClientNotFoundException() {
        super("Client not found");
    }
}
