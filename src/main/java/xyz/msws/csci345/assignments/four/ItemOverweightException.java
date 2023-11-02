package xyz.msws.csci345.assignments.four;

/**
 * Name: Isaac Boaz
 * Date: 10/31/23
 * Description: Thrown when adding an item weight would exceed the max weight of a pocket
 *     due to the item's weight in combination with the existing weight of the items.
 */
public class ItemOverweightException extends CausedException {
    /**
     * A default helper constructor to easily format the exception message.
     *
     * @deprecated Use {@link #ItemOverweightException(String, Throwable, Object...)} instead.
     * @param itemNotFoundException The message to be formatted.
     * @param args                  Optional varargs to format the string according to Java formatting specifications.
     */
    public ItemOverweightException(String itemNotFoundException, Object... args) {
        super(itemNotFoundException, args);
    }

    /**
     * A default helper constructor to easily format the exception message.
     *
     * @param itemNotFoundException The message to be formatted.
     * @param cause                 The underlying cause of this exception.
     * @param args                  Optional varargs to format the string according to Java formatting specifications.
     */
    public ItemOverweightException(String itemNotFoundException, Throwable cause, Object... args) {
        super(itemNotFoundException, cause, args);
    }
}