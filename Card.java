//Michael Ren 

import java.util.*;

public class Card {

	private int rank;
	private int actualRank; 
	private String suit; 

	public Card (int rank, String suit) {
		this.rank = rank; 
		if (rank > 10) {
			this.rank = 10; 
		}
		actualRank = rank;
		this.suit = suit; 
	}

	public int getRank() {
		return rank;
	}

	public int getTrueRank() {
		return actualRank;
	}
	
	public String getSuit() {
		return suit; 
	}

	public String toString() {
		String wordRank; 

		switch(actualRank) {
			case 1: 
				wordRank = "Ace"; 
				break;
			case 11: 
				wordRank = "Jack"; 
				break;
			case 12: 
				wordRank = "Queen";
				break; 
			case 13: 
				wordRank = "King"; 
				break; 
			default: 
				wordRank = Integer.toString(rank); 
		}
		return wordRank + " of " + suit; 
	}
}