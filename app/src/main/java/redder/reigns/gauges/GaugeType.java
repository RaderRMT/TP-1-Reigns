package redder.reigns.gauges;

import redder.reigns.localization.I18n;

public enum GaugeType {

    CHURCH("gaugetype.church"),
    PEOPLE("gaugetype.people"),
    MILITARY("gaugetype.military"),
    ECONOMY("gaugetype.economy");

    private final String name;

    /**
     * Create a new gauge type
     *
     * @param name  The gauge's display name
     */
    GaugeType(String name) {
        this.name = name;
    }

    /**
     * @return  The gauge name
     */
    public String getName() {
        return I18n.get(this.name);
    }
}
