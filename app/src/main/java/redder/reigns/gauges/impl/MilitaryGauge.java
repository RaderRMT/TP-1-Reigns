package redder.reigns.gauges.impl;

import redder.reigns.gauges.AbstractGauge;
import redder.reigns.gauges.GaugeType;

public class MilitaryGauge extends AbstractGauge {

    public MilitaryGauge() {
        super("Military", GaugeType.MILITARY);
    }
}
