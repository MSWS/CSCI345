package xyz.msws.csci345.assignments.seven;

/**
 * Name: Isaac Boaz
 * Date: 11/26/23
 * Description: A basic Hawk implementation of {@link Animal}.
 */
public class Hawk extends Animal {

    /**
     * Creates a new hawk with the given name and behaviors.
     *
     * @param name      Name of the hawk
     * @param flyable   The fly behavior this hawk has
     * @param swimmable The swimming behavior this hawk has
     */
    public Hawk(String name, IFlyable flyable, ISwimmable swimmable) {
        super(name, flyable, swimmable);
    }

    /**
     * Indicates that this hawk should eat.
     */
    @Override
    public void Eat() {
        System.out.printf("%s is eating like a hawk...\n", this.name);
    }

    /**
     * Indicates that this hawk should make a sound.
     */
    @Override
    public void MakeSound() {
        System.out.printf("%s says aaawwwkkk!\n", this.name);
    }
}
