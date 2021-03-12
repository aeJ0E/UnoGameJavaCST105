package card;

import deck.Deck;
import player.Player;
import java.util.Scanner;

public class Card {

	private String color;
	private int value;
	private static int effect;
	private String choosenColor;

	public Card(String color, int value) {
		this.color = color;
		this.value = value;
		// effect = effect;
		this.choosenColor = color;
	}

	// create card effect constructors

	// wild
	// public static void effectWildChooseColor(Card topCard, boolean clockWise, Player[] players, int currentPlayerIndex) {

	// 	Scanner playerColorChoice = new Scanner(System.in); // Create a Scanner object
	// 	System.out.println("please choose a color by typing it in the console. 1: Red, 2: Blue, 3: Yellow, 4: Green");

	// 	String color = playerColorChoice.toString();
	// 	topCard.setColor(color);
	// 	playerColorChoice.close();

	// }

	// plus 4
	public static void effectPlusFour(Player currentPlayer, Deck deck, boolean clockWise, Player[] players, int currentPlayerIndex) {
		Player NextPlayer = nextPlayerFunction(currentPlayerIndex, clockWise, players);
		for (int i = 0; i < 4; i++) {
			NextPlayer.playerHand.add(deck.drawTopCard());
		}

	}

	// plus 2
	public static void effectPlusTwo(Player currentPlayer, Deck deck, boolean clockWise, Player[] players, int currentPlayerIndex) {
		for (int i = 0; i < 2; i++) {
			currentPlayer.playerHand.add(deck.drawTopCard());
		}

	}

	// skip
	public static int effectSkip(int currentPlayerIndex, boolean clockWise, Player[] players) {
		if (clockWise) { // change to false for reverse
			currentPlayerIndex++;
			if (currentPlayerIndex >= players.length) {
				currentPlayerIndex -= players.length;
			}
		} else {
			currentPlayerIndex--;
			if (currentPlayerIndex < 0) { // had to reverse for counter clockwise motion.
				currentPlayerIndex += players.length;
			}

		}
		return currentPlayerIndex;
	}


	public static Player nextPlayerFunction(int currentPlayerIndex, boolean clockWise, Player[] players) {

		if (clockWise) { // change to false for reverse
			currentPlayerIndex++;
			if (currentPlayerIndex >= players.length) {
				currentPlayerIndex -= players.length;
			}
		} else {
			currentPlayerIndex--;
			if (currentPlayerIndex < 0) { // had to reverse for counter clockwise motion.
				currentPlayerIndex += players.length;
			}

		}
		Player nextPlayer = players[currentPlayerIndex];
		return nextPlayer;
	}

	// reverse
	public static boolean effectReverse(boolean clockWise, Player[] players, int currentPlayerIndex) {
		if (clockWise == false) {
			clockWise = true;
		}
		if (clockWise == true) {
			clockWise = false;
		} else {
			System.out.println("you messed something up.");
		}
		return clockWise;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getChoosenColor() {
		return choosenColor;
	}

	public void setChoosenColor(String choosenColor) {
		this.choosenColor = choosenColor;
	}

	public int getEffect() {
		return effect;
	}

	public static void setEffect(int effect) {
		Card.effect = effect;
	}

	public String toString() {
		if (value < 0) {
			if (value == -1) {
				return color;
			}
			if (value == -2) {
				return color + " +4";
			}
			if (value == -3) {
				return color + " skip";
			}
			if (value == -4) {
				return color + " reverse";
			}
			if (value == -5) {
				return color + " +2";
			}
		}
		return color + " " + value;
	}
}

	
// 	public static void checkForCardEffects(Card topCard, Card choosenCard, Player currentPlayer, Deck deck, int currentPlayerIndex,
// 			boolean clockWise, Player[] players) {
// 		if (choosenCard.value == -1) {
// 			System.out.println(currentPlayer + " played a wild.");
// 			Card.effectWildChooseColor(topCard, clockWise, players, currentPlayerIndex);
// 		}
// 		if (choosenCard.value == -2) {
// 			System.out.println(currentPlayer + " played a plus 4!");
// 			Card.effectPlusFour(currentPlayer, deck, clockWise, players, currentPlayerIndex);
// 		}
// 		if (choosenCard.value == -3) {
// 			System.out.println(currentPlayer + " played a skip. ");
// 			effectSkip(currentPlayerIndex, clockWise, players);

// 		}
// 		if (choosenCard.value == -4) {
// 			System.out.println(currentPlayer + " played a reverse.");
// 			Card.effectReverse(clockWise, players, currentPlayerIndex);
// 		}
// 		if (choosenCard.value == -5) {
// 			System.out.println(currentPlayer + " played a +2");
// 			Card.effectPlusTwo(currentPlayer, deck, clockWise, players, currentPlayerIndex);
// 		}
// 		System.out.println("No card effects to play");
// 	}

// }
