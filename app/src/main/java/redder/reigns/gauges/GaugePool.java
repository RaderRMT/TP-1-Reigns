package redder.reigns.gauges;

import java.util.List;

public final class GaugePool {

    private static GaugePool instance;

    private final List<Gauge> gauges = List.of(
            Gauge.builder(GaugeType.CHURCH).build(),
            Gauge.builder(GaugeType.ECONOMY).build(),
            Gauge.builder(GaugeType.MILITARY).build(),
            Gauge.builder(GaugeType.PEOPLE).build()
    );

    private GaugePool() {
    }

    /**
     * @return  true if at least one gauge is either empty of full
     *
     * @see Gauge
     */
    public boolean hasFilledOrEmptyGauge() {
        return this.gauges.stream()
                .anyMatch(
                        gauge -> gauge.getValue() <= 0 ||
                        gauge.getValue() >= gauge.getLength()
                );
    }

    /**
     * Print all the gauges to the standard output
     *
     * @see Gauge
     */
    public void printGauges() {
        this.gauges.forEach(System.out::println);
    }

    /**
     * Return the gauge associated with the given gauge type
     *
     * @param type  The gauge type
     * @return      The gauge
     * @see Gauge
     * @see GaugeType
     */
    public Gauge getGaugeByType(GaugeType type) {
        return this.gauges.stream()
                .filter(gauge -> gauge.getType().equals(type))
                .findFirst()
                .orElse(null);
    }

    /**
     * @return  The GaugePool instance, or a new instance if one hasn't been instantiated before
     */
    public static GaugePool getInstance() {
        if (instance == null) {
            instance = new GaugePool();
        }

        return instance;
    }
}
