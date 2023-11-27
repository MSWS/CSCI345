package xyz.msws.csci345.assignments.seven;

/**
 * Name: Isaac Boaz
 * Date: 11/26/23
 * Description: A basic Horse implementation of {@link Animal}.
 */
public class Horse extends Animal {
    public Horse(String name, IFlyable flyable, ISwimmable swimmable) {
        super(name, flyable, swimmable);
    }

    @Override
    public void Eat() {
        System.out.printf("%s is eating like a horse...\n", this.name);
    }

    @Override
    public void MakeSound() {
        System.out.printf("%s says neigh!\n", this.name);
    }
}
