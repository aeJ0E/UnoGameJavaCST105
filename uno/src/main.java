import deck.Deck;
import player.Player;
import card.Card;

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
		
		while (!gameWin) {   // starts game loop
			currentPlayer = players[currentPlayerIndex];
			
			System.out.println("Top card is: " + deck.getShownCard());
			System.out.println(currentPlayer.getName() + "'s turn");
			
			Card choosenCard = currentPlayer.getPlayerChoice(Deck.getShownCard()); 
			
			
			if (choosenCard != null) {
				System.out.println(currentPlayer.getName() + " played " + choosenCard);	
				// System.out.println("chossen card value is :" );
				Card.checkForCardEffects(choosenCard, choosenCard, currentPlayer, deck, currentPlayerIndex, clockWise,
						players);
				deck.addToDiscard(choosenCard);
				
				// make then draw if they have to
				currentPlayer.playerHand.add(deck.drawTopCard());
				
			} else {
				System.out.println(currentPlayer.getName() + " drew a card");
				currentPlayer.playerHand.add(deck.drawTopCard());
				

				// make then draw if they have 
			
			}
			// make then draw if they have to

			// Card.checkForCardEffects(choosenCard, choosenCard, currentPlayer, deck, currentPlayerIndex, clockWise,
			// 		players);

			// other things

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
