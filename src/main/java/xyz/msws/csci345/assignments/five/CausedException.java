package xyz.msws.csci345.assignments.five;

/**
 * Name: Isaac Boaz
 * Date: 11/06/23
 * Description: Super class to allow for easily formatting messages alongside supplying a {@link Throwable} cause.
 *     In this project all exceptions are expected to have a Cause, as such this class
 *     ensures this. Ideally, all constructions of this class should specify an underlying cause,
 *     otherwise the cause will be a generic {@link Exception}  with the message "Unknown cause".
 */
public class CausedException extends Exception {
    /**
     * A helper constructor to easily format the exception message with a Throwable cause.
     *
     * @param itemNotFoundException The message to be formatted.
     * @param cause                 The underlying cause of this exception.
     * @param args                  Optional varargs to format the string according to Java formatting specifications.
     */
    public CausedException(String itemNotFoundException, Throwable cause, Object... args) {
        super(itemNotFoundException.formatted(args), cause);
    }

    /**
     * A helper constructor to easily format the exception message with a String cause.
     *
     * @param itemNotFoundException The message to be formatted.
     * @param cause                 The underlying cause of this exception.
     * @param args                  Optional varargs to format the string according to Java formatting specifications.
     */
    public CausedException(String itemNotFoundException, String cause, Object... args) {
        super(itemNotFoundException.formatted(args), new Exception(cause));
    }
}