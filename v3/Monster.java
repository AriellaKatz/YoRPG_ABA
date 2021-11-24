/*
  class Monster -- Represents random incarnations of
  the adventurer's natural enemy in Ye Olde RPG
**/

public class Monster extends Character {

  /**
     default constructor
     pre:  instance vars are declared
     post: initializes instance vars.
  **/
  public Monster() {
    hp = 150;
    strength = 20 + (int)(Math.random()*45);
    defense = 20;
    attackRating = 1;
  }

}//end class Monster
