//Michael Ren

import java.util.*; 
public class Deck { 
	
	private ArrayList<Card> deck; 

	public Deck() {
		deck = new ArrayList<Card>();
		for (int i = 1; i <= 13; i++) {
			deck.add(new Card(i, "Clubs"));
			deck.add(new Card(i, "Diamonds"));
			deck.add(new Card(i, "Spades"));
			deck.add(new Card(i, "Hearts")); 
		}
	}

	public void shuffle() {
		int randomIndex;
		for (int i = 0; i < 52; i++) {
			randomIndex = (int) (Math.random() * 52);
			swap(i, randomIndex);  
		}
	}

	public Card topDeck() {
		Card top = deck.get(0); 
		deck.remove(0); 
		return top; 
	}

	public void swap(int index1, int index2) {
		Card temp = deck.get(index1); 
		deck.set(index1, deck.get(index2)); 
		deck.set(index2, temp); 
	}

	public String toString() {
		String s = "";
		for (Card card: deck) {
			s = s + card + " ";
		}
		return s;
	}
}