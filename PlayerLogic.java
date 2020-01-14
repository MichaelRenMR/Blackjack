//Michael Ren

import java.util.*;
public class PlayerLogic {

	static Scanner sc = new Scanner(System.in);

	public static void cpuLogic(Player cpu, Deck deck) {

		Card topCard; 
		while (cpu.getHand(0).sum() < 16) {		
			topCard = deck.topDeck(); 
			System.out.println(topCard + " added to CPU's hand.");
			cpu.hit(topCard, 0); 
		}
		System.out.println("CPU chose to stand.");
		System.out.println("Valued at: " + cpu.getHand(0).sum());
		if (cpu.getHand(0).isBusted()) {
			cpu.lose(); 
			System.out.println("CPU went over. LUL");
		}
	}

	public static void houseLogic(Player house, Deck deck) { 

		Card topCard;
		while (house.getHand(0).softSum() < 17 ) {
			topCard = deck.topDeck();
			System.out.println(topCard + " added to dealer's hand.");
			house.hit(topCard, 0); 
		}

		System.out.println("Dealer Cards: " + house);	//CPU endstate. 
		System.out.println("Valued at: " + house.getHand(0).sum());
		if (house.getHand(0).isBusted()) { 
			System.out.println("House lost! LUL");
		}
	}

	public static void playerLogic(Player player, Deck deck) {		//QOL features to add: autosum, autoblackjack. 
		
		//Scanner sc = new Scanner(System.in);
		String stand = "";
		System.out.println("Stand? [Y/N]");
		stand = sc.nextLine(); 
		Card topCard; 
 
		if (!stand.equals("Y")) {
			String doubleDown = "";
			System.out.println("Double down? [Y/N]");
			doubleDown = sc.nextLine(); 
			if (doubleDown.equals("Y")) {
				topCard = deck.topDeck();
				System.out.println(topCard + " added to your hand.");
				player.hit(topCard, 0); 
				player.doubleDown();
			}
		}

		String hitStand = "";
		while(!stand.equals("Y")) {

			System.out.println(player);

			if (player.canSplit()) {
				String split = "";
				System.out.println("\nSplit? [Y/N]");
				split = sc.nextLine(); 
				if (split.equals("Y")) {
					split(player);
				}
				/*(hitStand = null;
				System.out.println("\nHit or stand? Enter 'hit' for hit and 'stand' for stand."); 
				hitStand = sc.nextLine(); 
				if (hitStand.equals("hit")) {
					hitAllHands(player, deck);
						continue;
				}
				else {
					break;
				}*/
			}

				hitStand = null;
				//System.out.println("Hitting initiated.");
				if (player.canHit()) {
					System.out.println("\nHit or stand? Enter 'hit' for hit and 'stand' for stand."); 
					hitStand = sc.nextLine(); 
					if (hitStand.equals("hit")) {
						hitAllHands(player, deck);
						continue;
					}
					else {
						break;
					}
				}
			
			break;
		}
		//sc.close();
	}

	

	public static boolean validSplit(Player player, int splitHand, int splitRank) {

		int suitCount = 0; 
		for (int i = 0; i < player.getHand(splitHand).getSize(); i++) {
			if (player.getHand(splitHand).getCard(i).getTrueRank() == splitRank) {
				suitCount++;
			}
		}
		return suitCount >= 2; 
	}

	public static void split(Player player) {

		//Scanner sc = new Scanner(System.in); 
		System.out.println(player);
		System.out.println("Enter the number of the hand followed by the rank of the pair in that hand which you would like to split. ");
		System.out.println("For example, if you wanted to split your two kings in your first hand, you would enter \"1 13\".");
		System.out.println("Enter split: ");
		int splitHand = 0; 
		int splitRank = 0; 
		splitHand = sc.nextInt(); //sc.nextLine();
		splitRank = sc.nextInt(); sc.nextLine();
		//System.out.println("Splithand: " + splitHand + "Splitrank: " + splitRank + validSplit(player, splitHand, splitRank));
		if (validSplit(player, splitHand, splitRank)) {
			int rankIndex = 0;
			for (int i = 0; i < player.getHand(splitHand).getSize(); i++) {
				if (player.getHand(splitHand).getCard(i).getTrueRank() == splitRank) {
					break;
				}
				rankIndex++; 
			}
			player.split(); 
			player.hit(player.getHand(splitHand).getCard(rankIndex), player.numHands() - 1); 
			player.discard(splitHand, rankIndex); 
		}
		//sc.close();
	}

	public static void hitAllHands(Player player, Deck deck) {

		Card faceCard;
		for (int handIndex = 0; handIndex < player.numHands(); handIndex++) {
			faceCard = deck.topDeck(); 
			if (!player.getHand(handIndex).isBusted()) {
				player.hit(faceCard, handIndex); 
				System.out.print(faceCard + " added to Hand " + handIndex + ".\n");
			}
		}
	}
}