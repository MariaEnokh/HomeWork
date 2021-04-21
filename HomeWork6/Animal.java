package HomeWork6;

import java.util.Random;

public abstract class Animal {
    static final int SWIM_FAIL = 0;
    static final int SWIM_OK = 1;
    static final int SWIM_NONE = -1;

    private final String type;
    private final String name;
    private final float maxRun;
    private final float maxSwim;
    private final Random random = new Random();

    Animal(String type, String name,  float maxRun, float maxSwim) {
        float runDiff = random.nextFloat() * maxRun - (maxRun / 2);
        float swimDiff = random.nextFloat() * maxSwim - (maxSwim / 2);

        this.type = type;
        this.name = name;
        this.maxRun = maxRun + runDiff;
        this.maxSwim = maxSwim + swimDiff;
    }
    String getName() {
        return this.name;
    }
    String getType() {
        return this.type;
    }
    float getMaxRun() {
        return this.maxRun;
    }
    float getMaxSwim() {
        return this.maxSwim;
    }


    protected boolean run(float distance) {
        return (distance <= maxRun);
    }

    protected int swim(float distance) {
        return (distance <= maxSwim) ? SWIM_OK : SWIM_FAIL;
    }



}