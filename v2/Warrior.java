public class Warrior extends Protagonist {

	private String name;

	public Warrior() {
		super(125, 150, 40, .4);
	}

	public Warrior(String inName) {
		this();
		name = inName;
	}

}
