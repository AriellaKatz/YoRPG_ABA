public class Tank extends Protagonist {

        public Tank() {
                super(190, 100, 40, .4);
        }

        public Tank(String inName) {
                this();
                name = inName;
        }

}
