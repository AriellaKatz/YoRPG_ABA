public class Healer extends Protagonist {

        public Healer() {
                super();
        }

        public Healer(String inName) {
                this();
                name = inName;
        }

	public void heal() {
		hp = 125;
	}

	public static String about() {
		String description = "Allows protagonist to fully replenish hp once per game.";
		 return description;
	}
}
