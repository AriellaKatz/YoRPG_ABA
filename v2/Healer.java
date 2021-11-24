public class Healer extends Protagonist {

        public Healer() {
                super(125, 100, 40, .4);
        }

        public Healer(String inName) {
                this();
                name = inName;
        }

	public void heal() {
		hp = 125;
	}

}
