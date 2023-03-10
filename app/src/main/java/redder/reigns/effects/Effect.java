package redder.reigns.effects;

import redder.reigns.gauges.GaugeType;

public class Effect {

    private Direction direction;
    private GaugeType affectedGauge;
    private int strength;

    private Effect() {
    }

    /**
     * @return  The effect's direction
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * @return  The gauge type this effect will affect
     */
    public GaugeType getAffectedGauge() {
        return this.affectedGauge;
    }

    /**
     * @return  The effect's strength
     */
    public int getStrength() {
        return this.strength;
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
