package redder.reigns.gauges;

import redder.reigns.utils.MathUtils;
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

    /**
     * @return  The gauge name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return  The gauge's value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * @return  The gauge's length
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Add the given value to the gauge's value and clamp it
     * to the gauge's bounds (so 0 and {@link Gauge#getLength() })
     *
     * @param value The value to add
     * @see MathUtils#clamp(int, int, int)
     */
    public void updateValue(int value) {
        this.value += value;
        this.value = MathUtils.clamp(this.value, 0, this.length);
    }

    /**
     * @return  The gauge type
     * @see GaugeType
     */
    public GaugeType getType() {
        return this.gaugeType;
    }

    @Override
    public String toString() {
        return '[' + "#".repeat(this.value) + "_".repeat(this.length - this.value) + "] " + this.name;
    }

    /**
     * Create a new GaugeBuilder instance with the given gauge type
     *
     * @param type  The gauge type for the gauge builder
     * @return      The new GaugeBuilder instance
     */
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

        /**
         * Set the start value of the gauge
         *
         * @param start The start value
         * @return      The GaugeBuilder instance to chain statements
         */
        public GaugeBuilder start(int start) {
            this.start = start;
            return this;
        }

        /**
         * Set the gauge's start value to be between {@code start } and {@code end } randomly
         *
         * @param start The random start value
         * @param end   The random end value
         * @return      The GaugeBuilder instance to chain statements
         * @see RandomUtils#between(int, int)
         */
        public GaugeBuilder startBetween(int start, int end) {
            this.start = RandomUtils.between(start, end);
            return this;
        }

        /**
         * Set the length of the gauge
         *
         * @param length    The gauge's length
         * @return          The GaugeBuilder instance to chain statements
         */
        public GaugeBuilder length(int length) {
            this.length = length;
            return this;
        }

        /**
         * Build the Gauge from the GaugeBuilder
         *
         * @return  The new Gauge
         * @see Gauge
         */
        public Gauge build() {
            return new Gauge(this.name, this.type, this.length, this.start);
        }
    }
}
