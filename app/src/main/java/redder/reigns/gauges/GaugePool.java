package redder.reigns.gauges;

import redder.reigns.gauges.impl.ChurchGauge;
import redder.reigns.gauges.impl.EconomyGauge;
import redder.reigns.gauges.impl.MilitaryGauge;
import redder.reigns.gauges.impl.PeopleGauge;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public final class GaugePool implements Iterable<AbstractGauge> {

    private final List<AbstractGauge> gauges = List.of(
            new ChurchGauge(),
            new EconomyGauge(),
            new MilitaryGauge(),
            new PeopleGauge()
    );

    public GaugePool() {
    }

    public boolean hasFilledOrEmptyGauge() {
        for (AbstractGauge gauge : this) {
            if (gauge.getValue() <= 0 || gauge.getValue() >= gauge.getLength()) {
                return true;
            }
        }

        return false;
    }

    public void printGauges() {
        for (AbstractGauge gauge : this) {
            System.out.println(gauge);
        }
    }

    @Override
    public Iterator<AbstractGauge> iterator() {
        return this.gauges.iterator();
    }

    @Override
    public void forEach(Consumer<? super AbstractGauge> action) {
        this.gauges.forEach(action);
    }
}
