/**


import java.util.*;
import java.util.Collections;

import card.Card;

public class Deck {

	public ArrayList<Card> deck = new ArrayList<Card>();  // makes a public "deck" arrList
	public ArrayList<Card> discard = new ArrayList<Card>();
	 // makes a public "discard" arrList

	public Deck() {

		// Create number Cards
		// const colors = ["Red", "Blue", "Yellow", "Green"]
		String[] colors = { "Red", "Blue", "Yellow", "Green" };
		// values = [0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,]
		int[] values = { 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, -3, -3, -4, -4, -5, -5, };
		// -3 = skip, -4 = reverse, -5 = +2

		// for (let color of colors) {
		for (String color : colors) {
			for (int value : values) {
				this.deck.add(new Card(color, value, effect));
			}
		}

		// for (let value of values) {
		// deck.add(new Card(color, value, ""));
		//
		// Create wild cards
		for (int i = 0; i < 4; i++) {
			this.deck.add(new Card("wild", -1, "wild"));
			this.deck.add(new Card("wild", -2, "+4"));
		}
		
		Collections.shuffle(deck);
//		addToDiscard(drawTopCard());
	}


	
	public Card drawTopCard() { 
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}
	
	public void addToDiscard(Card card) {
		discard.add(card);
	}
	
	public Card getShownCard() {
		return discard.get(discard.size() - 1);
	}
}





 * 
 */