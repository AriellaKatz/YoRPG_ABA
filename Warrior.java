public class Warrior extends Protagonist {

	private String name;

	public Warrior() {
		super();
		strength = 150;
	}

	public Warrior(String inName) {
		this();
		name = inName;
	}

	public static String about() {
		String description = "Gives protagonist higher attack level.";
		 return description;
	}
}
