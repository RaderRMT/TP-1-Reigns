package redder.reigns.gauges;

import redder.reigns.utils.RandomUtils;

public abstract class AbstractGauge {

    private final String name;

    private int value;

    protected AbstractGauge(String name) {
        this.name = name;

        this.value = startValue();
    }

    protected int startValue() {
        return RandomUtils.between(15, 35);
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    // todo: remove
    public void setValue(int value) {
        this.value = value;
    }
}
