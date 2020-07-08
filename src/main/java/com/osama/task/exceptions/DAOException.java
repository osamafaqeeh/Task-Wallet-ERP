package com.osama.task.exceptions;

/**
 * The type of checked exception that thrown from DAO-level.
 *
 * @author Osama Alfaqeeh
 * @see Exception
 */
public class DAOException extends Exception {

    /**
     * Instantiates a new DAOException.
     */
    public DAOException() {
    }

    /**
     * Instantiates a new DAOException.
     *
     * @param message the message.
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Instantiates a new DAOException.
     *
     * @param message the message.
     * @param cause   the cause.
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new DAOException.
     *
     * @param cause the cause.
     */
    public DAOException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new DAOException.
     *
     * @param message            the message.
     * @param cause              the cause.
     * @param enableSuppression  the enable suppression.
     * @param writableStackTrace the writable stack trace.
     */
    public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}