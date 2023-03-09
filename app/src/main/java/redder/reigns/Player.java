package redder.reigns;

public class Player {

    private final String name;
    private final Gender gender;

    public Player(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }


    /**
     * Returns the Name of the player
     *
     * @return      A string chosed by the player
     */
    public String getName() {
        return this.name;
    }


    /**
     * Returns the Gender of the player
     *
     * @return      A Gender chosed by the player
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
         * Returns a quote depending of the player's gender
         *
         * @return      A string depending of the player's gender
         */
        public String getLongReignText() {
            return this.longReignText;
        }
    }
}
