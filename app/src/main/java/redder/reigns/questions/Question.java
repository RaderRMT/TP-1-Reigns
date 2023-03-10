package redder.reigns.questions;

import redder.reigns.effects.Effect;

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
     */
    public List<Effect> getEffects() {
        return this.effects;
    }

    /**
     * Print the question to the standard output
     */
    public void printQuestion() {
        System.out.println("[" + this.npcName + "] " + this.question);

        this.effects.forEach(System.out::println);
    }
}
