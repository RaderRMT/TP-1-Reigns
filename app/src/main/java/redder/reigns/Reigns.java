package redder.reigns;

import redder.reigns.effects.Effect;
import redder.reigns.gauges.Gauge;
import redder.reigns.gauges.GaugePool;
import redder.reigns.questions.Question;
import redder.reigns.questions.QuestionPool;
import redder.reigns.utils.Input;

public final class Reigns {

    private final QuestionPool questionPool;
    private final GaugePool gaugePool;

    private Reigns() {
        this.questionPool = QuestionPool.getInstance();
        this.gaugePool = GaugePool.getInstance();
    }

    private void start() {
        System.out.println("Bienvenue sur Reigns");
        System.out.println("Création du personnage...");

        Player player = initPlayer();

        System.out.println(player.getGender().getLongReignText());

        int nbTours = 0;
        while (!this.gaugePool.hasFilledOrEmptyGauge()) {
            this.gaugePool.printGauges();

            showRandomQuestion();

            nbTours++;
        }

        this.gaugePool.printGauges();

        System.out.println(
                player.getName() + " a perdu ! " +
                        "Son règne a duré " + nbTours + " tours"
        );
    }

    private void showRandomQuestion() {
        Question question = this.questionPool.getRandomQuestion();
        question.printQuestion();

        Effect.Direction[] directions = Effect.Direction.values();
        printEnumEntries(directions);

        int answer = Input.readClampedInt(1, directions.length) - 1;
        Effect.Direction selectedDirection = directions[answer];

        question.getEffects()
                .stream()
                .filter(effect -> effect.getDirection().equals(selectedDirection))
                .forEach(effect -> {
                    Gauge gauge = gaugePool.getGaugeByType(effect.getAffectedGauge());
                    gauge.updateValue(effect.getStrength());
                });
    }

    private Player initPlayer() {
        System.out.println("Entrez le nom du personnage: ");
        String nom = Input.readString();

        System.out.println("Comment faut-il vous appeler?");

        Player.Gender[] genders = Player.Gender.values();
        printEnumEntries(genders);

        int gender = Input.readClampedInt(1, genders.length) - 1;
        return new Player(nom, genders[gender]);
    }

    private <T extends Enum<?>> void printEnumEntries(T[] enumeration) {
        for (int i = 1; i <= enumeration.length; i++) {
            System.out.print(i + " pour " + enumeration[i - 1]);

            if (i < enumeration.length) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Reigns main = new Reigns();
        main.start();
    }
}
