package redder.reigns;

import redder.reigns.questions.QuestionPool;

public class TestMain {

    public static void main(String[] args) {
        QuestionPool pool = QuestionPool.getInstance();
        System.out.println(pool.getRandomQuestion().getEffects().get(0).getAffectedGauge());
    }
}
