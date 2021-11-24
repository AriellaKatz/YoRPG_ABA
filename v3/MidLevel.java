public class MidLevel extends Monster {

        public MidLevel() {
                super();
                strength = 20 + (int)(Math.random()*45);
        }

	public static String about() {
		String description = "Monster with average attack level";
		return description;
	}
}
