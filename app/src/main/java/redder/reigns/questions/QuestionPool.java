package redder.reigns.questions;

import redder.reigns.ConfigReader;
import redder.reigns.utils.OS;
import redder.reigns.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public final class QuestionPool {

    private static final String CONFIG_FILE_PATH = OS.getHomeFolder() + "questions.json";

    private static QuestionPool instance;

    private final List<Question> questions;

    private QuestionPool() {
        this.questions = new ArrayList<>();
    }

    /**
     * @return  A random question
     * @see RandomUtils#randomObject(List)
     * @see Question
     */
    public Question getRandomQuestion() {
        return RandomUtils.randomObject(this.questions);
    }

    /**
     * Return the instance of this QuestionPool.
     * The QuestionPool's data is loaded from a JSON file stored at {@link QuestionPool#CONFIG_FILE_PATH}
     *
     * @return  The QuestionPool instance, or a new instance if one hasn't been instantiated before
     */
    public static QuestionPool getInstance() {
        if (instance == null) {
            instance = ConfigReader.read(QuestionPool.class, CONFIG_FILE_PATH);
        }

        return instance;
    }
}
