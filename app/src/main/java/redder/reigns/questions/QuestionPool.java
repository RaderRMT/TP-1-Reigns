package redder.reigns.questions;

import redder.reigns.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public final class QuestionPool implements Iterable<AbstractQuestion> {

    private final List<AbstractQuestion> questions;

    public QuestionPool() {
        this.questions = new ArrayList<>();
    }

    public AbstractQuestion getRandomQuestion() {
        return RandomUtils.randomObject(this.questions);
    }

    @Override
    public Iterator<AbstractQuestion> iterator() {
        return this.questions.iterator();
    }

    @Override
    public void forEach(Consumer<? super AbstractQuestion> action) {
        this.questions.forEach(action);
    }
}
