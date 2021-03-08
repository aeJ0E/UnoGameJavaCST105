package player;

import java.util.ArrayList;
import java.util.Scanner;

import card.Card;
import deck.Deck;

public class Player {

	public ArrayList<Card> playerHand = new ArrayList<Card>(); // Makes an array playerHand
	private String name;

	public Player(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Card getPlayerChoice(Card topCard) {
		Card choosenCard = null;
		var s = new Scanner(System.in);
		
			System.out.println("-1 if you have to draw.");
			System.out.println("Cards to choose:");
			for (int i = 0; i < playerHand.size(); i++) {
				System.out.println(i + ": " + playerHand.get(i));
			}
			
			
			int choice = 0;
			choice = s.nextInt();
			s.nextLine();
			
			
			// s.close();
			
			if (choice < 0 || choice >= playerHand.size()){   // if you choose something outside of you player bound it returns a card to you 
				return null;
			}
			choosenCard = playerHand.get(choice);
			
			if (getPlayable(topCard, choosenCard)) {
				return choosenCard;
			}
			else{return null;}
	}
	
	
	

	public boolean getPlayable(Card topCard, Card choosenCard) { // check if card is playable
		if (choosenCard.getColor().equals(topCard.getColor())) { // checks color
			playerHand.remove(choosenCard);
			return true;
		}
		if (choosenCard.getColor() == ("wild")) {// check wilds
			// constructor to set wild color. If i get around to it
			Card.effectWildChooseColor(topCard);
			playerHand.remove(choosenCard);
			return true;
		}
		if (choosenCard.getValue() == topCard.getValue()) { // check value
			playerHand.remove(choosenCard);
			return true;
		}
		if (topCard.getColor() == ("wild")) {
			playerHand.remove(choosenCard);
			return true;
		}

		System.out.println("You can't place that card"); // if you can't play
		System.out.println("Top card is: " + Deck.getShownCard());

		return false;
	}

	public String toString() {
		String output = name + "'s cards:\n";
		for (Card card : playerHand) {
			output += card + "\n";
		}
		return output;
	}

	public ArrayList<Card> getPlayerHand() {
		return this.playerHand;
	}

}
