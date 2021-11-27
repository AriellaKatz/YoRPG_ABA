/**
  class Protagonist -- protagonist of Ye Olde RPG
  **/

public class Protagonist extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    protected String name = "J. Doe";

    /**
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      **/
    public Protagonist() {
        hp = 125;
        strength = 100;
        defense = 40;
        attackRating = .4;
    }


    /**
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      **/
    public Protagonist( String name ) {
        this();
        this.name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return name; }

    //prepare a Protagonist for a special attack
    public void specialize() {
        attackRating = .75;
        defense = 20;
    }

    //revert to normal mode
    public void normalize() {
        attackRating = .4;
        defense = 40;
    }

    public void heal() {
    }

}//end class Protagonist
