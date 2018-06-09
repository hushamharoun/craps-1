package com.example.karan.craps;
import java.util.Random;

public class Craps_Model implements Craps_Interface{
	private int wallet, passLineBet, point;

	private boolean comeOutRoll;
	int[] dice;
	int[] bets;
	//Bets array has an int corresponding to every possible value of betsDestination
	
	public Craps_Model() {
		dice = new int[2];
		wallet=500;
		bets=new int[BetDestination.values().length];
		newGame();
	}

	public int getWallet() {
		return wallet;
	}
	


		private void initializeDice() {
			Random rand= new Random();

			dice[0]=rand.nextInt(6)+1;
			dice[1]=rand.nextInt(6)+1;
		}
	public boolean placeBet(BetDestination betDestination, int betValue)	//returns false if insufficient funds
	{
		if(wallet >= betValue)
		{
			wallet-=betValue;
			passLineBet+=betValue;
			return true;
		}
		return false;
	}

	public boolean newGame() // This will clear last game and create a new one.
	{
		point=0;
		passLineBet=0;
		comeOutRoll=true;
		//TODO: initialize text fields in interface
		return true;
	}
	public boolean loseGame()   // This will excutute a Lose game if the Dice rolls didnt go the players way.
	{
		//TODO
		return false;
	}
	public boolean winGame()	// This will excutute a Win if the Dice rolls went the players way.
	{
		FieldBetPayout();
		return true;
	}
	public boolean FieldBetPayout()
	{
		wallet+=passLineBet;
		return true;
	}
	
	public int rollDice()
	{
		initializeDice();
		
		if(comeOutRoll) {
			switch(getPointValue()) {
				case 2:
				case 3:
				case 12:
					loseGame();
					break;
				case 7:
				case 11:
					winGame();
					break;
				default:
					comeOutRoll=false;
			}

		}
		else {
			if(getPointValue()==7)
				loseGame();
			else /*if (getPointValue()==pointTextBox.Text)*/ {						// Disabled if statement for the moment for we dont have pointTextBox implemented yet.
				//TODO: change pointTextBox to the equivalent for our interface
				//might have to be an argument? not sure
				winGame();
			}
		}
		return dice[0]+dice[1];
	}
	
	public int getPointValue() {
		return point;
	}
	
	public int getDie1() {
		return dice[0];
	}
	
	public int getDie2() {
		return dice[1];
	}
}