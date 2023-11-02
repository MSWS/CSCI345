package xyz.msws.csci345.assignments.four;


/**
 * Name: Isaac Boaz
 * Date: 10/31/23
 * Description: Thrown when an item is not found in a pocket.
 */
public class ItemNotFoundException extends CausedException {
    /**
     * A default helper constructor to easily format the exception message.
     *
     * @param itemNotFoundException The message to be formatted.
     * @param cause                 The underlying cause of this exception.
     * @param args                  Optional varargs to format the string according to Java formatting specifications.
     */
    public ItemNotFoundException(String itemNotFoundException, Throwable cause, Object... args) {
        super(itemNotFoundException, cause, args);
    }

    /**
     * A helper constructor to easily format the exception message.
     *
     * @param itemNotFoundException The message to be formatted.
     * @param cause                 The underlying cause of this exception.
     * @param args                  Optional varargs to format the string according to Java formatting specifications.
     */
    public ItemNotFoundException(String itemNotFoundException, String cause, Object... args) {
        super(itemNotFoundException, new Exception(cause), args);
    }
}
