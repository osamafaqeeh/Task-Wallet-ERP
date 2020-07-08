package com.osama.task.exceptions;

/**
 * The type of checked exception that thrown from service-level.
 *
 * @author Osama Alfaqeeh
 * @see Exception
 */
public class ServiceException extends Exception {


    /**
     * Instantiates a new ServiceException.
     */
    public ServiceException() {
    }

    /**
     * Instantiates a new ServiceException.
     *
     * @param message the message.
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Instantiates a new ServiceException.
     *
     * @param message the message.
     * @param cause   the cause.
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new ServiceException.
     *
     * @param cause the cause.
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new ServiceException.
     *
     * @param message            the message.
     * @param cause              the cause.
     * @param enableSuppression  the enable suppression.
     * @param writableStackTrace the writable stacktrace.
     */
    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
