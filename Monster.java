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
  public Monster(int hp, int strength, int defense, double attackRating) {
    super(hp, strength, defense, attackRating)
  }

}//end class Monster
