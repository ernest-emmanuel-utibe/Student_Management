package com.real.student.exception;
/**
 * @author ERNEST EMMANUEL UTIBE
 * */
import org.springframework.security.core.AuthenticationException;

public final class UnusualLocationException extends AuthenticationException {

    private static final long serialVersionUID = 5861310537366287163L;

    public UnusualLocationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UnusualLocationException(final String message) {
        super(message);
    }

}
