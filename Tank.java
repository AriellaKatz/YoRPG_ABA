public class Tank extends Protagonist {

        public Tank() {
                super();
                hp = 190;
        }

        public Tank(String inName) {
                this();
                name = inName;
        }

	public static String about() {
		String description = "Gives the protagonist a higher hp.";
		 return description;
	}
}
