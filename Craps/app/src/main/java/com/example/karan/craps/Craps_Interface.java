package com.example.karan.craps;

enum BetDestination
{
	passLine,
	come, dontCome,
	come4, come5, come6, come8, come9, come10,
	dontCome4, dontCome5, dontCome6, dontCome8, dontCome9, dontCome10,
	sideBet4, sideBet5, sideBet6, sideBet8, sideBet9, sideBet10,
	big6, big8,
	field, dontPassBar,
	mini7, hard6, hard10, hard8, hard4, mini2, mini3, mini12, mini11, mini_any,
    buy4, buy5, buy6, buy8, buy9, buy10,
    lay4, lay5, lay6, lay8, lay9, lay10;
}

public interface 	Craps_Interface{
	
	/*functions stubs go here*/
	
	
	boolean placeBet(BetDestination betDestination, int betValue); //passes in ID of destination and value to bet
																	// returns false if insufficient funds

	boolean newGame(); // This will clear last game and create a new one.

	int rollDice();   // This will roll the dice and process the result

	boolean loseGame();   // This will excutute a Lose game if the Dice rolls didnt go the players way.

	public boolean payout(BetDestination betDestination);

	int getPointValue(); //Returns value of point
	
	int getDie1() ;	//getter, useful for future graphics

	int getDie2() ;	//getter, useful for future graphics

	double getWallet();	//getter, useful for GUI

		
}