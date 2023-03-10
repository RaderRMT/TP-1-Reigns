package redder.reigns.gauges;

public enum GaugeType {

    CHURCH("Church"),
    PEOPLE("People"),
    MILITARY("Military"),
    ECONOMY("Economy");

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
        return this.name;
    }
}
