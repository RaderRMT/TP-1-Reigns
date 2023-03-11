package redder.reigns;

import redder.reigns.localization.I18n;

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

    public enum Gender implements IDisplayable {

        KING("player.gender.king", "player.gender.king.text"),
        QUEEN("player.gender.queen", "player.gender.queen.text");

        private final String displayName;
        private final String longReignText;

        Gender(String displayName, String longReignText) {
            this.displayName = displayName;
            this.longReignText = longReignText;
        }

        /**
         * @return  A string depending on the player's gender
         */
        public String getLongReignText() {
            return I18n.get(this.longReignText);
        }

        /**
         * @return The element's display name
         */
        @Override
        public String getDisplayName() {
            return I18n.get(this.displayName);
        }
    }
}
