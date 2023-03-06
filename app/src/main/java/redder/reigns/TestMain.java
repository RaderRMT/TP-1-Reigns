package redder.reigns;

import redder.reigns.effects.Effect;
import redder.reigns.gauges.Gauge;
import redder.reigns.gauges.GaugePool;
import redder.reigns.questions.Question;
import redder.reigns.questions.QuestionPool;

import java.util.Scanner;

public class TestMain {

    public TestMain() {
    }

    public static void main(String[] args) {
        new TestMain().start();
    }

    private void start() {

        System.out.println("Bienvenue sur Reigns");

        QuestionPool questionPool = QuestionPool.getInstance();

        System.out.println("Création du personnage...");

        Player player = initPlayer();

        System.out.println(player.getGender().longReign());

        GaugePool gaugePool = GaugePool.getInstance();
        gaugePool.printGauges();

        int nbTours = 0;
        while(!gaugePool.hasFilledOrEmptyGauge()) {
            nbTours++;
            Question question = questionPool.getRandomQuestion();
            reponseQuestion(question, gaugePool);
            gaugePool.printGauges();
        }

        System.out.println(
                player.getName()
                        + " a perdu ! Son règne a duré "
                        + nbTours
                        + " tours");
    }

    private void reponseQuestion(Question question, GaugePool gaugePool) {
        question.afficheQuestion();

        for (int i = 0; i < Effect.Direction.values().length; i++) {
            System.out.print((i + 1) + " pour " + Effect.Direction.values()[i] + "\n");
        }

        Scanner scanner = new Scanner(System.in);
        int reponse = scanner.nextInt();
        for (Effect effect : question.getEffects()) {
            if (effect.getDirection() == Effect.Direction.values()[reponse-1]) {
                Gauge gauge = gaugePool.getGaugeByType(effect.getAffectedGauge());
                gauge.updateValue(effect.getStrength());
            }
        }
    }



    private Player initPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();

        System.out.println("Comment faut-il vous appeler?");
        for (int i = 0; i < Player.Gender.values().length; i++) {
            System.out.print((i + 1) + " pour " + Player.Gender.values()[i] + ", ");
        }
        int genre = scanner.nextInt();
        return new Player(nom, Player.Gender.values()[genre-1]);
    }
}
