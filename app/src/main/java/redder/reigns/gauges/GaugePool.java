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
        for (Gauge gauge : this.gauges) {
            if (gauge.getValue() <= 0 || gauge.getValue() >= gauge.getLength()) {
                return true;
            }
        }

        return false;
    }

    public void printGauges() {
        this.gauges.forEach(System.out::println);
    }

    public Gauge getGaugeByType(GaugeType type) {
        for (Gauge gauge : this.gauges) {
            if (gauge.getType().equals(type)) {
                return gauge;
            }
        }

        return null;
    }

    public static GaugePool getInstance() {
        if (instance == null) {
            instance = new GaugePool();
        }

        return instance;
    }
}
