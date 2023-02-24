package redder.reigns.gauges;

import redder.reigns.utils.RandomUtils;

public abstract class AbstractGauge {

    private static final int DEFAULT_LENGTH = 50;

    private final GaugeType gaugeType;
    private final String name;
    private final int length;

    private int value;

    protected AbstractGauge(String name, int length, GaugeType gaugeType) {
        this.name = name;
        this.length = length;
        this.gaugeType = gaugeType;

        this.value = startValue();
    }

    protected AbstractGauge(String name, GaugeType gaugeType) {
        this(name, DEFAULT_LENGTH, gaugeType);
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

    public int getLength() {
        return this.length;
    }

    // todo: remove
    public void setValue(int value) {
        this.value = value;
    }

    public GaugeType getType() {
        return this.gaugeType;
    }

    @Override
    public String toString() {
        return '[' + "#".repeat(this.value) + "_".repeat(this.length - this.value) + "] " + this.name;
    }
}
