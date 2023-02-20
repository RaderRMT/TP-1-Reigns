package redder.reigns;

public class Player {

    private final String name;
    private final Gender gender;

    public Player(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    enum Gender {
        KING("Long règne au roi"),
        QUEEN("Long règne à la reine");

        private final String longReignText;

        Gender(String longReignText) {
            this.longReignText = longReignText;
        }

        public String longReign() {
            return this.longReignText;
        }
    }
}
