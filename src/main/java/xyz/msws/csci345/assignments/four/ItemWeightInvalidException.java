package xyz.msws.csci345.assignments.four;

/**
 * Name: Isaac Boaz
 * Date: 10/31/23
 * Description: Thrown when an item's weight is invalid (ie negative).
 */
public class ItemWeightInvalidException extends CausedException {
    /**
     * A default helper constructor to easily format the exception message.
     *
     * @deprecated Use {@link #ItemWeightInvalidException(String, Throwable, Object...)} instead.
     * @param itemNotFoundException The message to be formatted.
     * @param args                  Optional varargs to format the string according to Java formatting specifications.
     */
    public ItemWeightInvalidException(String itemNotFoundException, Object... args) {
        super(itemNotFoundException, args);
    }

    /**
     * A default helper constructor to easily format the exception message.
     *
     * @param itemNotFoundException The message to be formatted.
     * @param cause                 The underlying cause of this exception.
     * @param args                  Optional varargs to format the string according to Java formatting specifications.
     */
    public ItemWeightInvalidException(String itemNotFoundException, Throwable cause, Object... args) {
        super(itemNotFoundException, cause, args);
    }
}