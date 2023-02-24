package redder.reigns.gauges.impl;

import redder.reigns.gauges.AbstractGauge;
import redder.reigns.gauges.GaugeType;

public class EconomyGauge extends AbstractGauge {

    public EconomyGauge() {
        super("Economy", GaugeType.PEOPLE);
    }
}
