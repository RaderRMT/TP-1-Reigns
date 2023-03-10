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


    /**
     * Initialize the player then enter the main game loop.
     * We only exit the game loop if one of the gauge is
     * either completely empty or completely full
     *
     * @see Player
     * @see Gauge
     */
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

    /**
     * Print a random question from the question pool, wait for the user
     * to enter a direction and apply the effects from the direction to the gauges
     *
     * @see Question
     * @see QuestionPool
     * @see Effect
     * @see Effect.Direction
     * @see Gauge
     */
    private void showRandomQuestion() {
        Question question = this.questionPool.getRandomQuestion();
        question.printQuestion();

        Effect.Direction[] directions = Effect.Direction.values();
        int answer = getInputIndexFromArray(directions);

        Effect.Direction selectedDirection = directions[answer];

        question.getEffects()
                .stream()
                .filter(effect -> effect.getDirection().equals(selectedDirection))
                .forEach(effect -> {
                    Gauge gauge = gaugePool.getGaugeByType(effect.getAffectedGauge());
                    gauge.updateValue(effect.getStrength());
                });
    }

    /**
     * Ask the user a few questions to create its player instance
     *
     * @return  The new player instance
     * @see     Player
     * @see     Player.Gender
     */
    private Player initPlayer() {
        System.out.println("Entrez le nom du personnage: ");
        String nom = Input.readString();

        System.out.println("Comment faut-il vous appeler?");

        Player.Gender[] genders = Player.Gender.values();
        int gender = getInputIndexFromArray(genders);

        return new Player(nom, genders[gender]);
    }

    /**
     * Print the given list's values with it's associated index
     * and wait for the user to enter a number before returning.
     *
     * <p>The return value will be clamped between 0 and the length
     * of the array minus one
     *
     * @param array The values to print
     * @return      The selected entry index
     */
    private int getInputIndexFromArray(Object[] array) {
        int arrayLength = array.length;

        for (int i = 1; i <= arrayLength; i++) {
            System.out.print(i + " pour " + array[i - 1]);

            if (i < arrayLength) {
                System.out.print(", ");
            }
        }

        System.out.println();

        return Input.readClampedInt(1, arrayLength) - 1;
    }

    public static void main(String[] args) {
        Reigns main = new Reigns();
        main.start();
    }
}
