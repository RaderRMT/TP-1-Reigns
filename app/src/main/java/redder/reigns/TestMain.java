package redder.reigns;

import redder.reigns.effects.Effect;
import redder.reigns.gauges.Gauge;
import redder.reigns.gauges.GaugePool;
import redder.reigns.questions.Question;
import redder.reigns.questions.QuestionPool;
import redder.reigns.utils.MathUtils;

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
        while (!gaugePool.hasFilledOrEmptyGauge()) {
            nbTours++;
            Question question = questionPool.getRandomQuestion();
            showQuestion(question, gaugePool);
            gaugePool.printGauges();
        }

        System.out.println(
                player.getName()
                        + " a perdu ! Son règne a duré "
                        + nbTours
                        + " tours");
    }

    private void showQuestion(Question question, GaugePool gaugePool) {
        Effect.Direction[] directions = Effect.Direction.values();

        question.printQuestion();
        for (int i = 0; i < directions.length; i++) {
            System.out.print((i + 1) + " pour " + directions[i]);

            if (i + 1 < directions.length) {
                System.out.print(", ");
            }
        }

        System.out.println();

        Scanner scanner = new Scanner(System.in);

        int answer = MathUtils.clamp(scanner.nextInt(), 1, directions.length);
        Effect.Direction direction = directions[answer - 1];

        question.getEffects()
                .stream()
                .filter(effect -> effect.getDirection().equals(direction))
                .forEach(effect -> {
                    Gauge gauge = gaugePool.getGaugeByType(effect.getAffectedGauge());
                    gauge.updateValue(effect.getStrength());
                });
    }

    private Player initPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();

        Player.Gender[] genders = Player.Gender.values();
        System.out.println("Comment faut-il vous appeler?");
        for (int i = 0; i < genders.length; i++) {
            System.out.print((i + 1) + " pour " + genders[i]);

            if (i + 1 < genders.length) {
                System.out.print(", ");
            }
        }

        System.out.println();

        int genre = MathUtils.clamp(scanner.nextInt(), 1, genders.length);
        return new Player(nom, genders[genre - 1]);
    }
}
