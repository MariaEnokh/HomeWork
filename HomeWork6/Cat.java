package HomeWork6;


public class Cat extends Animal {

    Cat(String name, float maxRun, Float maxSwim) {
        super("Кот", name, maxRun, maxSwim);
    }

    @Override
    protected int swim(float distance) {
        return Animal.SWIM_NONE;

    }
}