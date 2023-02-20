package redder.reigns;

import redder.reigns.gauges.GaugePool;

public class TestMain {

    public static void main(String[] args) {
        GaugePool gaugePool = new GaugePool();
        gaugePool.printGauges();
    }
}
