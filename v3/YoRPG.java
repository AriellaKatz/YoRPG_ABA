/**********************************************
 * class YoRPG -- Driver file for Ye Olde Role Playing Game.
 * Simulates monster encounters of a wandering adventurer.
 * Required classes: Protagonist, Monster
 *
 * USAGE:
 * Compile. Note messages generated.
 * Devise a plan of attack with your trio.
 * Code incrementally, testing each bit of new functionality as you go.
 * The only modification you should make to this driver file is moving comment bar down in main method, and filling in DISCO/QCC
 * (If you feel other changes are merited, note what and why, so that we may discuss on the 'morrow.)
 *
 * DISCO:
 *  Inheritance
 *  super, super()
 *  protector is a 3rd option for privacy
 * QCC:
 *
 **********************************************/

/*
OUR DRIVER MODS:
Removed instantiations of the protagonist and the monster so that we would later be able to specify what type of protagonist or
monster it would be. Added code to choose protagonist based on player input and choose monster type based on how many rounds
had been played. Added code to allow player to utilize Healer capabilities if the player is a Healer.
*/

import java.io.*;
import java.util.*;

public class YoRPG {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 5;

  private Protagonist pat;
  private Monster smaug;

  private int moveCount;
  private boolean gameOver;
  private int difficulty;

  private boolean isHealer = false;
  private boolean alreadyHealed = false;

  private InputStreamReader isr;
  private BufferedReader in;
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
  public YoRPG() {
    moveCount = 0;
    gameOver = false;
    isr = new InputStreamReader( System.in );
    in = new BufferedReader( isr );
    newGame();
  }
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

  /*=============================================
    void newGame() -- gathers info to begin a new game
    pre:
    post: according to user input, modifies instance var for difficulty
    and instantiates a Protagonist
    =============================================*/
  public void newGame() {
    String s;
    String name = "";
    s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

    s += "\nChoose your difficulty: \n";
    s += "\t1: Easy\n";
    s += "\t2: Not so easy\n";
    s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    s += "Selection: ";
    System.out.print( s );

    try {
	    difficulty = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }

    s = "Intrepid protagonist, what doth thy call thyself? (State your name): ";
    System.out.print( s );

    try {
	    name = in.readLine();
    }
    catch ( IOException e ) { }
//  System.out.println("Your name: " + name);

    s += name + ", choose your player:\n";
    s += "\t1: Healer\n";
    s += "\t2: Tank\n";
    s += "\t3: Warrior\n";
    s += "Selection: ";
    System.out.print(s);

    try {
	    if (Integer.parseInt(in.readLine()) == 1) {
	      pat = new Healer (name);
              isHealer = true;
//	      System.out.println("\n" + name + "is a Healer")
            }
	    else if (Integer.parseInt(in.readLine()) == 2) {
	      pat = new Tank (name);
//            System.out.println("\n" + name + "is a Tank")
            }
	    else if (Integer.parseInt(in.readLine()) == 3) {
              pat = new Warrior (name);
//            System.out.println("\n" + name + "is a Warrior")
            }
    }
    catch ( IOException e ) { }

    //instantiate the player's character

  }//end newGame()


  /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    post: Returns true if player wins (monster dies).
    Returns false if monster wins (player dies).
    =============================================*/
  public boolean playTurn(int encounters) {
    int i = 1;
    int d1, d2;

    if ( Math.random() >= ( difficulty / 3.0 ) )
      System.out.println( "\nNothing to see here. Move along!" );
    else {
      System.out.println( "\nLo, yonder monster approacheth!" );

      if (encounters < 2) {
        smaug = new LowLevel();
//      System.out.println("smaug is LowLevel");
//      System.out.println("smaug's stats:\n" + "hp: " +
//      smaug.hp + "\tstrength: " + smaug.strength +
//      "\tdefense: " + smaug.getDefense() + "\tattackRating: " +
//      smaug.attackRating);
      }
      else if (encounters > 3) {
        smaug = new Boss();
//      System.out.println("smaug is Boss");
//      System.out.println("smaug's stats:\n" + "hp: " +
//      smaug.hp + "\tstrength: " + smaug.strength +
//      "\tdefense: " + smaug.getDefense() + "\tattackRating: " +
//      smaug.attackRating);
      }
      else {
        smaug = new MidLevel();
//      System.out.println("smaug is MidLevel");
//      System.out.println("smaug's stats:\n" + "hp: " +
//      smaug.hp + "\tstrength: " + smaug.strength +
//      "\tdefense: " + smaug.getDefense() + "\tattackRating: " +
//      smaug.attackRating);
      }

      while( smaug.isAlive() && pat.isAlive() ) {

        // Give user the option of using a special attack:
        // If you land a hit, you incur greater damage,
        // ...but if you get hit, you take more damage.
        try {
          System.out.println( "\nDo you feel lucky?" );
          System.out.println( "\t1: Nay.\n\t2: Aye!" );
          i = Integer.parseInt( in.readLine() );
        }
        catch ( IOException e ) { }

        if ( i == 2 ) {
          pat.specialize();
//        System.out.println(name + "'s attack rating is " + pat.attackRating);
//        System.out.println(name + "'s defense is " + pat.getDefense());
        }
        else {
          pat.normalize();
//        System.out.println(name + "'s attack rating is " + pat.attackRating);
//        System.out.println(name + "'s defense is " + pat.getDefense());
        }

        d1 = pat.attack( smaug );
        d2 = smaug.attack( pat );

        System.out.println( "\n" + pat.getName() + " dealt " + d1 +
                            " points of damage.");

        System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
                            " for " + d2 + " points of damage.");
//      System.out.println("pat's stats:\n" + "hp: " +
//      pat.hp + "\tstrength: " + pat.strength +
//      "\tdefense: " + pat.getDefense() + "\tattackRating: " +
//      pat.attackRating);
//      System.out.println("smaug's stats:\n" + "hp: " +
//      smaug.hp + "\tstrength: " + smaug.strength +
//      "\tdefense: " + smaug.getDefense() + "\tattackRating: " +
//      smaug.attackRating);


	if ((isHealer) && (!alreadyHealed)) {
		try {
	          System.out.println( "\nHeal yourself?" );
        	  System.out.println( "\t1: Nay.\n\t2: Aye!" );
       		  i = Integer.parseInt( in.readLine() );
       		}
	        catch ( IOException e ) { }
		if (i == 2) { pat.heal();  alreadyHealed = true; System.out.println("You have been restored to full health! However, you have used up all your mana!"); }
	}
      }//end while

      //option 1: you & the monster perish
      if ( !smaug.isAlive() && !pat.isAlive() ) {
        System.out.println( "'Twas an epic battle, to be sure... " +
                            "You cut ye olde monster down, but " +
                            "with its dying breath ye olde monster. " +
                            "laid a fatal blow upon thee." );
        return false;
      }
      //option 2: you slay the beast
      else if ( !smaug.isAlive() ) {
        System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
        return true;
      }
      //option 3: the beast slays you
      else if ( !pat.isAlive() ) {
        System.out.println( "Ye olde self hath expired. You got dead." );
        return false;
      }
    }//end else

    return true;
  }//end playTurn()
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  public static void main( String[] args ) {
    //As usual, move the begin-comment bar down as you progressively
    //test each new bit of functionality...

    //loading...
    YoRPG game = new YoRPG();

    int encounters = 0;

    while( encounters < MAX_ENCOUNTERS ) {
      if ( !game.playTurn(encounters) )
        break;
      encounters++;
      System.out.println();
    }

    System.out.println( "Thy game doth be over." );
    /*================================================
      ================================================*/
  }//end main

}//end class YoRPG
