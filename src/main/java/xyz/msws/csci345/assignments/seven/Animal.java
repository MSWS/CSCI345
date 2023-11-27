package xyz.msws.csci345.assignments.seven;

/**
 * Name: Isaac Boaz
 * Date: 11/26/23
 * Description: Represents an abstract animal that has an assigned
 * name, fly behavior, and swimming behavior. All animals
 * must be able to eat and make a sound, with the other
 * behaviors left to the implementing classes.
 */
public abstract class Animal {
    protected final String name;
    private IFlyable flyable;
    private ISwimmable swimmable;

    /**
     * Creates a new animal with the given name and behaviors.
     *
     * @param name      Name of the animal
     * @param flyable   The fly behavior this animal has
     * @param swimmable The swimming behavior this animal has
     */
    public Animal(String name, IFlyable flyable, ISwimmable swimmable) {
        this.name = name;
        this.flyable = flyable;
        this.swimmable = swimmable;
    }

    /**
     * Indicates that this animal should eat.
     */
    public abstract void Eat();

    /*
     * Indicates that this animal should fly.
     */
    public void Fly() {
        System.out.print(this.name);
        this.flyable.Fly();
    }

    /**
     * Indicates that this animal should make a sound.
     */
    public abstract void MakeSound();

    /**
     * Indicates that this animal should swim.
     */
    public void Swim() {
        System.out.print(this.name);
        this.swimmable.Swim();
    }
}
