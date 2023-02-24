package redder.reigns.gauges.impl;

import redder.reigns.gauges.AbstractGauge;
import redder.reigns.gauges.GaugeType;

public class PeopleGauge extends AbstractGauge {

    public PeopleGauge() {
        super("People", GaugeType.PEOPLE);
    }
}
