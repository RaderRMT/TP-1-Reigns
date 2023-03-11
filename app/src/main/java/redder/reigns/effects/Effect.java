package redder.reigns.effects;

import redder.reigns.IDisplayable;
import redder.reigns.gauges.GaugeType;
import redder.reigns.localization.I18n;

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
        return this.direction.getDisplayName() + ": " +
                this.affectedGauge.getName() + " (" +
                this.strength + ")";
    }

    public enum Direction implements IDisplayable {

        LEFT("effect.left"),
        RIGHT("effect.right");

        private final String displayName;

        Direction(String displayName) {
            this.displayName = displayName;
        }

        /**
         * @return The element's display name
         */
        @Override
        public String getDisplayName() {
            return I18n.get(this.displayName);
        }
    }
}
