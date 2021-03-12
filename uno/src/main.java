import deck.Deck;
import player.Player;
import card.Card;
import java.util.*;

public class main {
	public static Player[] players = { new Player("Joe"), new Player("Austin"), new Player("Guy"), new Player("Joe2") };
	public static Deck deck = new Deck();
	public static Player currentPlayer = players[0];

	public static void main(String[] args) {
		int currentPlayerIndex = 0;
		boolean clockWise = true;
		boolean gameWin = false;

		// MAIN GAME
		deck.addToDiscard(deck.drawTopCard());

		assignPlayers();

		while (!gameWin) { // starts game loop
			currentPlayer = players[currentPlayerIndex];
			Player nextPlayer = players[currentPlayerIndex];
			
			System.out.println("Top card is: " + deck.getShownCard());
			System.out.println(currentPlayer.getName() + "'s turn");
			
			Card choosenCard = currentPlayer.getPlayerChoice(Deck.getShownCard());
			
			if (choosenCard != null) {
				System.out.println(currentPlayer.getName() + " played " + choosenCard);
				deck.addToDiscard(choosenCard);  // add card to top of discard deck
				// System.out.println("chossen card value is :" );
				// Card.checkForCardEffects(choosenCard, choosenCard, currentPlayer, deck,
				// currentPlayerIndex, clockWise,
				// players);

				if (choosenCard.getValue() == -1) {
					System.out.println(currentPlayer + " played a wild.");
					// Card.effectWildChooseColor(Deck.getShownCard(), clockWise, players,
					// currentPlayerIndex);
					Scanner playerColorChoice = new Scanner(System.in); // Create a Scanner object
					System.out.println("please choose a color by typing it in the console. 1: Red, 2: Blue, 3: Yellow, 4: Green");
					int colorChoice = playerColorChoice.nextInt();
					String color = "";

					if(colorChoice == 1){
						color = "Red";
					}
					else if(colorChoice == 2){
						color = "Blue";
					}
					else if(colorChoice == 3){
						color = "Yellow";
					}
					else if(colorChoice == 4){
						color = "Green";
					} else	{
						System.out.println("Not a color. Please choose from  1: Red, 2: Blue, 3: Yellow, 4: Green");
					}

					Deck.getShownCard().setColor(color);
					// playerColorChoice.close();

				}
				if (choosenCard.getValue() == -2) {
					System.out.println(currentPlayer + " played a plus 4!");
					Card.effectPlusFour(currentPlayer, deck, clockWise, players, currentPlayerIndex);
					
				
					Scanner playerColorChoice = new Scanner(System.in); // Create a Scanner object
					System.out.println("please choose a color by typing it in the console. 1: Red, 2: Blue, 3: Yellow, 4: Green");
					int colorChoice = playerColorChoice.nextInt();
					String color = "";

					if(colorChoice == 1){
						color = "Red";
					}
					else if(colorChoice == 2){
						color = "Blue";
					}
					else if(colorChoice == 3){
						color = "Yellow";
					}
					else if(colorChoice == 4){
						color = "Green";
					} else	{
						System.out.println("Not a color. Please choose from  1: Red, 2: Blue, 3: Yellow, 4: Green");
					}

					Deck.getShownCard().setColor(color);
					// playerColorChoice.close();
				}
				if (choosenCard.getValue() == -3) {
					System.out.println(currentPlayer + " played a skip. ");

					currentPlayerIndex = Card.effectSkip(currentPlayerIndex, clockWise, players);

				}
				if (choosenCard.getValue() == -4) {
					System.out.println(currentPlayer + " played a reverse.");
					clockWise = Card.effectReverse(clockWise, players, currentPlayerIndex);
					
				}
				if (choosenCard.getValue() == -5) {
					System.out.println(currentPlayer + " played a +2");
					Card.effectPlusTwo(currentPlayer, deck, clockWise, players, currentPlayerIndex);
				}
		


				// make then draw if they have to
				// currentPlayer.playerHand.add(deck.drawTopCard());

			} else {

				if (deck.deck.size() <= 5) { // check if we need to reshuffle
					deck.reShuffleDeck();
				}

				System.out.println(currentPlayer.getName() + " drew a card");
				currentPlayer.playerHand.add(deck.drawTopCard());
				// make then draw if they have

			}

			// Card.checkForCardEffects(choosenCard, choosenCard, currentPlayer, deck,
			// currentPlayerIndex, clockWise,
			// players);

			// other things

			if (clockWise) { // change to false for reverse
				currentPlayerIndex++;
				if (currentPlayerIndex >= players.length) {
					currentPlayerIndex -= players.length;
				}
			} else {
				currentPlayerIndex--;
				if (currentPlayerIndex < 0) { // had
												// to
												// reverse
												// for
												// counter
												// clockwise
												// motion.
					currentPlayerIndex += players.length;
				}

				// How would a skip work?

				// make methode to move to next player

			}

			if (currentPlayer.getPlayerHand().isEmpty()) {
				gameWin = true;

			}
		}
	}

	public static void assignPlayers() {
		for (Player player : players) {
			for (int i = 0; i < 7; i++) {
				player.playerHand.add(deck.drawTopCard());
			}
			// To Debug Code
			// System.out.println("Player hand check " + player);
		}
	}

}
