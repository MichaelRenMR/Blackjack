//Michael Ren 

import java.util.*;

public class Hand {
	
	private ArrayList<Card> hand; 
	private boolean busted; 

	public Hand() {
		hand = new ArrayList<Card>(); 
		busted = false; 
	}

	public void addCard(Card a) {
		hand.add(a); 
	}

	public boolean getBust() {
		return busted; 
	}

	public void bust() {
		busted = true;
	}

	public Card getCard(int index) {
		return hand.get(index); 
	}

	public void removeCard(int index) {
		hand.remove(index); 
	}

	public int getSize() {
		return hand.size();
	}

	public int sum() {		//returns the BEST possible sum. 
		int sum = 0;
		int aceCount = 0; 
		for (Card a: hand) {
			sum += a.getRank(); 
			if (a.getRank() == 1) {
				aceCount++; 
			}
		}
		while((sum + 10*aceCount > 21) && (aceCount > 0)) { 		
			aceCount--;
		}
		return sum + 10 * aceCount; 
	}

	public int softSum() {	//returns the MINIMUM sum
		int sum = 0;
		for (Card a: hand) {
			sum += a.getRank(); 
		}
		return sum;
	}

	public boolean isBusted() {
		int sum = 0;
		for(Card a: hand) {
			sum += a.getRank(); 
		}
		return sum > 21; 
	}

	public String toString() {
		String s = "";
		for (Card card: hand) {
			s = s + card + ", ";  
		}
		s = s.substring(0, s.length() - 1); 
		return s;
	}
}