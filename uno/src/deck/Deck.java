package deck;

import java.util.ArrayList;
import java.util.Collections;

import card.Card;

public class Deck {

	public static ArrayList<Card> deck = new ArrayList<Card>();
	public static ArrayList<Card> discard = new ArrayList<Card>();

	public Deck() {

		// Create number Cards
		// const colors = ["Red", "Blue", "Yellow", "Green"]
		String[] colors = { "Red", "Blue", "Yellow", "Green" };
		// values = [0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,]
		int[] values = { 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, -3, -3, -4, -4, -5, -5, };
		// -3 = skip, -4 = reverse, -5 = +2
		// int effect = 0;

		// Loop to make color atributed cards
		for (String color : colors) {
			for (int value : values) {
				this.deck.add(new Card(color, value));

				// to make color card have effects
				// if(value == -3){
				// Card.setEffect(-3);
				// }
				// if(value == -4){
				// Card.setEffect(-4);
				// }
				// if(value == -5){
				// Card.setEffect(-5);
				// }
			}
		}

		// Create wild cards
		for (int i = 0; i < 4; i++) {
			this.deck.add(new Card("wild", -1));
			this.deck.add(new Card("wild", -2));
		}

		Collections.shuffle(deck);
		addToDiscard(drawTopCard());

		// To Debug Code
		// System.out.println(deck.toString());
	}

	public Card drawTopCard() {
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}

	public void addToDiscard(Card card) {
		discard.add(card);
	}

	public static Card getShownCard() {
		return discard.get(discard.size() - 1);
	}

	public static void reShuffleDeck()	{   // reshuffle discard into deck saving top discard
		Card tempTopCard = getShownCard();
		discard.remove(discard.size()-1); // remove top card and save it

		Collections.shuffle(discard); // shuffle
		for(int i=0; i<discard.size(); i++){
			deck.add(discard.get(i));
		}

		discard.clear();
		discard.add(tempTopCard);
		System.out.println("The discard was reshuffled.");
	}
}
