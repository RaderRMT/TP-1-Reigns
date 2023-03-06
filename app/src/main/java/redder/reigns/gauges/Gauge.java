package redder.reigns.gauges;

import redder.reigns.utils.RandomUtils;

public class Gauge {

    private static final int DEFAULT_LENGTH = 50;

    private final GaugeType gaugeType;
    private final String name;
    private final int length;

    private int value;

    private Gauge(String name, GaugeType gaugeType, int length, int start) {
        this.name = name;
        this.gaugeType = gaugeType;
        this.length = length;
        this.value = start;
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

    public void updateValue(int value) {
        this.value += value;
        if(this.value < 0){
            this.value = 0;
        }
        if(this.value > this.length){
            this.value = this.length;
        }
    }

    public GaugeType getType() {
        return this.gaugeType;
    }

    @Override
    public String toString() {
        return '[' + "#".repeat(this.value) + "_".repeat(this.length - this.value) + "] " + this.name;
    }

    public static GaugeBuilder builder(GaugeType type) {
        return new GaugeBuilder(type, type.getName());
    }

    static class GaugeBuilder {

        private final GaugeType type;
        private final String name;

        private int start = RandomUtils.between(15, 35);
        private int length = DEFAULT_LENGTH;

        private GaugeBuilder(GaugeType type, String name) {
            this.type = type;
            this.name = name;
        }

        public GaugeBuilder start(int start) {
            this.start = start;
            return this;
        }

        public GaugeBuilder startBetween(int start, int end) {
            this.start = RandomUtils.between(start, end);
            return this;
        }

        public GaugeBuilder length(int length) {
            this.length = length;
            return this;
        }

        public Gauge build() {
            return new Gauge(this.name, this.type, this.length, this.start);
        }
    }
}
