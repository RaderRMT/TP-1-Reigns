package redder.reigns.questions;

import redder.reigns.effects.Effect;
import redder.reigns.gauges.Gauge;
import redder.reigns.gauges.GaugePool;

import java.util.List;

public class Question {

    private String npcName;
    private String question;
    private List<Effect> effects;

    private Question() {
    }

    /**
     * @return  The NPC name associated with this question
     */
    public String getNpcName() {
        return this.npcName;
    }

    /**
     * @return  The question string associated with this question
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * @return  The effects associated with this question
     * @see Effect
     */
    public List<Effect> getEffects() {
        return this.effects;
    }

    /**
     * Apply the effect from the given directions to the gauges
     *
     * @param selectedDirection The direction
     * @see Gauge
     * @see Effect
     * @see Effect.Direction
     */
    public void applyEffects(Effect.Direction selectedDirection) {
        this.effects.stream()
                .filter(effect -> effect.getDirection().equals(selectedDirection))
                .forEach(effect -> {
                    Gauge gauge = GaugePool.getInstance().getGaugeByType(effect.getAffectedGauge());
                    gauge.updateValue(effect.getStrength());
                });
    }

    /**
     * Print the question to the standard output
     */
    public void printQuestion() {
        System.out.println("[" + this.npcName + "] " + this.question);

        this.effects.forEach(System.out::println);
    }
}
