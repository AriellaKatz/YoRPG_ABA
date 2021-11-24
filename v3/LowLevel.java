public class LowLevel extends Monster {

	public LowLevel() {
		super();
		strength = (int)(Math.random()*45);
	}

	public static String about() {
		String description = "Monster with low attack level.";
		return description;
	}
}
