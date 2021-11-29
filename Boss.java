public class Boss extends Monster {

        public Boss() {
                super();
                strength = 50 + (int)(Math.random()*50);
        }

	public static String about() {
		String description = "Monster with high attack level, faced by protagonist later in the game.";
		return description;
	}
}
