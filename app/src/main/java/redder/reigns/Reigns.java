package redder.reigns;

import org.apache.commons.cli.*;
import redder.reigns.effects.Effect;
import redder.reigns.gauges.Gauge;
import redder.reigns.gauges.GaugePool;
import redder.reigns.localization.I18n;
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
        I18n.print("reigns.welcome");

        Player player = initPlayer();

        System.out.println(player.getGender().getLongReignText());

        int nbTours = 0;
        while (!this.gaugePool.hasFilledOrEmptyGauge()) {
            this.gaugePool.printGauges();

            showRandomQuestion();

            nbTours++;
        }

        this.gaugePool.printGauges();

        I18n.printFormat("reigns.lost", player.getName(), nbTours);
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
        I18n.print("reigns.player.creation");
        I18n.print("reigns.player.creation.playername");
        String nom = Input.readString();

        I18n.print("reigns.player.creation.calling");

        Player.Gender[] genders = Player.Gender.values();
        int gender = Input.getUserInputIndexFromArray(genders);

        return new Player(nom, genders[gender]);
    }

    public static void main(String[] args) {
        Options options = new Options();

        Option lang = new Option("l", "lang", true, "Change the game's language");
        options.addOption(lang);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Reigns", options);

            System.exit(1);
        }

        I18n.setLang(cmd.getOptionValue('l', "fr_FR"));

        Reigns main = new Reigns();
        main.start();
    }
}
