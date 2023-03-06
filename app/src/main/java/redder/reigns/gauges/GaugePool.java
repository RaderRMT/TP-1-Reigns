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

    public boolean hasFilledOrEmptyGauge() {
        return this.gauges.stream()
                .anyMatch(gauge -> gauge.getValue() <= 0 || gauge.getValue() >= gauge.getLength());
    }

    public void printGauges() {
        this.gauges.forEach(System.out::println);
    }

    public Gauge getGaugeByType(GaugeType type) {
        return this.gauges.stream()
                .filter(gauge -> gauge.getType().equals(type))
                .findFirst()
                .orElse(null);
    }

    public static GaugePool getInstance() {
        if (instance == null) {
            instance = new GaugePool();
        }

        return instance;
    }
}
