package redder.reigns.effects;

import redder.reigns.gauges.GaugeType;

public class Effect {

    private Direction direction;
    private GaugeType affectedGauge;
    private int strength;

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public GaugeType getAffectedGauge() {
        return this.affectedGauge;
    }

    public void setAffectedGauge(GaugeType affectedGauge) {
        this.affectedGauge = affectedGauge;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return this.direction + ": " +
                this.affectedGauge.getName() + " (" +
                this.strength + ")";
    }

    public enum Direction {

        LEFT,
        RIGHT
    }
}
