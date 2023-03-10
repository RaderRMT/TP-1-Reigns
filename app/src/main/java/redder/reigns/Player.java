package redder.reigns;

public class Player {

    private final String name;
    private final Gender gender;

    /**
     * Create a new instance of a player
     *
     * @param name      The player's name
     * @param gender    The player's gender
     */
    public Player(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    /**
     * @return  The player's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return  The player's gender
     */
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

        /**
         * @return  A string depending on the player's gender
         */
        public String getLongReignText() {
            return this.longReignText;
        }
    }
}
