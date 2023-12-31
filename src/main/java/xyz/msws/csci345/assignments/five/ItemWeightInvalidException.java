package xyz.msws.csci345.assignments.five;

/**
 * Name: Isaac Boaz
 * Date: 11/06/23
 * Description: Thrown when an item's weight is invalid (ie negative).
 */
public class ItemWeightInvalidException extends CausedException {
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