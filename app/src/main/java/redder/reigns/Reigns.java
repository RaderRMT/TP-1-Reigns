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
        int answer = Input.getUserInputIndexFromArray(directions);

        Effect.Direction selectedDirection = directions[answer];
        question.applyEffects(selectedDirection);
    }

    /**
     * Ask the user a few questions to create its player instance
     *
     * @return  The new player instance
     * @see     Player
     * @see     Player.Gender
     */
    private Player initPlayer() {
        System.out.println("Création du personnage...");
        System.out.println("Entrez le nom du personnage: ");
        String nom = Input.readString();

        System.out.println("Comment faut-il vous appeler?");

        Player.Gender[] genders = Player.Gender.values();
        int gender = Input.getUserInputIndexFromArray(genders);

        return new Player(nom, genders[gender]);
    }

    public static void main(String[] args) {
        Reigns main = new Reigns();
        main.start();
    }
}
