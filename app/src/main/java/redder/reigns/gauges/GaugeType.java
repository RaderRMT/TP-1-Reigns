package redder.reigns.gauges;

public enum GaugeType {

    CHURCH("Church"),
    PEOPLE("People"),
    MILITARY("Military"),
    ECONOMY("Economy");

    private final String name;

    GaugeType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
