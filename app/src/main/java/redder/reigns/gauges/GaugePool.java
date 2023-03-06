package redder.reigns.gauges;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public final class GaugePool implements Iterable<Gauge> {

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
        for (Gauge gauge : this) {
            if (gauge.getValue() <= 0 || gauge.getValue() >= gauge.getLength()) {
                return true;
            }
        }

        return false;
    }

    public void printGauges() {
        for (Gauge gauge : this) {
            System.out.println(gauge);
        }
    }

    public Gauge getGaugeByType(GaugeType type) {
        for (Gauge gauge : this) {
            if (gauge.getType().equals(type)) {
                return gauge;
            }
        }

        return null;
    }

    @Override
    public Iterator<Gauge> iterator() {
        return this.gauges.iterator();
    }

    @Override
    public void forEach(Consumer<? super Gauge> action) {
        this.gauges.forEach(action);
    }

    public static GaugePool getInstance() {
        if (instance == null) {
            instance = new GaugePool();
        }

        return instance;
    }
}
