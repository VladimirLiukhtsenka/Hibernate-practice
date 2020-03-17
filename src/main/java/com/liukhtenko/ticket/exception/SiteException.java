package com.liukhtenko.ticket.exception;

public class SiteException extends Exception {
    public SiteException() {
        super();
    }

    public SiteException(String message) {
        super(message);
    }

    public SiteException(String message, Throwable cause) {
        super(message, cause);
    }

    public SiteException(Throwable cause) {
        super(cause);
    }
}
