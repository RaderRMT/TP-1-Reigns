package redder.reigns.questions;

import com.google.gson.Gson;
import redder.reigns.utils.OS;
import redder.reigns.utils.RandomUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class QuestionPool {

    private static final String CONFIG_FILE_PATH = OS.getHomeFolder() + "questions.json";

    private static QuestionPool instance;

    private final List<Question> questions;

    public QuestionPool() {
        this.questions = new ArrayList<>();
    }

    public Question getRandomQuestion() {
        return RandomUtils.randomObject(this.questions);
    }

    public static QuestionPool getInstance() {
        if (instance == null) {
            try (FileReader reader = new FileReader(CONFIG_FILE_PATH)) {
                instance = new Gson().fromJson(reader, QuestionPool.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return instance;
    }
}
