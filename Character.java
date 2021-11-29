/*
ABA - Ariella katz, Alif Rahman, Brianna Tieu, Tom, Grippy, Pepe
APCS
L01 -- An Adventurer is You!
2021-11-22
time spent: 0.5 hrs
*/

/*
DISCO:
0.
QCC:
0. Can objects of superclasses and subclasses be treated as though they're the same?
   (Not in terms of their actual contents, but in the ways they're created,
   referenced, etc.)
1. Do we assume that the values of the attributes will be set in the subclasses?
   Is this always the case, or just for this program?
2. What is the purpose of getDefense()?
*/

public class Character {

	protected int hp;
	protected int strength;
	protected int defense;
	protected double attackRating;

	public boolean isAlive() {
		return (hp > 0);
	}

	public int getDefense() {
		return defense;
	}

	public void lowerHP(int damage) {
		hp = hp - damage;
	}

	public int attack(Character opponent) {
		int damage = (int)(strength * attackRating) - opponent.defense;
		if (damage < 0) { damage = 0; }
		opponent.lowerHP(damage);
		return damage;
	}

}
