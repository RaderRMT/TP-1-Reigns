package redder.reigns.questions;

import redder.reigns.effects.Effect;

import java.util.List;

public class Question {

    private String npcName;
    private String question;
    private List<Effect> effects;

    private Question() {
    }

    public String getNpcName() {
        return this.npcName;
    }

    public String getQuestion() {
        return this.question;
    }

    public List<Effect> getEffects() {
        return this.effects;
    }

    public void printQuestion() {
        System.out.println("[" + this.npcName + "] " + this.question);

        this.effects.forEach(System.out::println);
    }
}
