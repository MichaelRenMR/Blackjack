//Michael Ren

import java.util.*;

public class Player { 

	private ArrayList<Hand> hands; 
	private int money; 
	private int bet; 

	public Player() {
		hands = new ArrayList<Hand>();
		hands.add(new Hand());
		money = 100; 
		bet = 0;
	}

	public void clear() {
		int k = hands.size();
		for (int i = 0; i < k; i++) {
			hands.remove(0);
		}
		hands.add(new Hand());
	}
	public Hand getHand(int handIndex) {
		return hands.get(handIndex); 
	}

	public int numHands() {
		return hands.size(); 
	}

	public void addHand() {
		hands.add(new Hand()); 
	}

	public void hit(Card card, int handIndex) {		//not named addCard to remove confusion with addCard method in class Hand
		hands.get(handIndex).addCard(card); 
	}

	public boolean canSplit() {
		for (Hand hand: hands) {
			if (!hand.getBust()) {
				for (int i = 0; i < hand.getSize(); i++) {
					for (int j = i+1; j < hand.getSize(); j++) {
						if (hand.getCard(i).getTrueRank() == hand.getCard(j).getTrueRank()) {
							return true;
						}
					}
				}
			}
		}
		return false; 
	}

	public boolean canHit() {
		for (Hand hand: hands) {
			System.out.println(hand);
			if (hand.sum() < 21) {
				return true;
			}
		}
		return false;
	}

	public void split() {
		hands.add(new Hand());
	}

	public void discard(int handIndex, int index) {
		hands.get(handIndex).removeCard(index); 
	}
	public void doubleDown() {
		bet *= 2; 
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public void lose() {
		money -= bet;
	}

	public void win() {
		money += bet;
	}

	public int getMoney() {
		return money;
	}

	public String toString() {
		String s = ""; 
		int handCounter = 0;
		for (Hand hand: hands) {
			s = s + "Hand " + Integer.toString(handCounter) + ": " + hand + "\n";
			handCounter++; 
		}
		s = s.substring(0, s.length() - 1);
		return s;
	}

}