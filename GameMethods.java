//Michael Ren

import java.util.*; 

public class GameMethods {
	
	static Scanner sc = new Scanner(System.in);

	public static void placeBets(Player house, Player cpu, Player player) {
		int bet;
		//Scanner sc = new Scanner(System.in);
		cpu.setBet(10);		//CPU bet
		System.out.println("\n\nInput bet amount.");	//player bet
		bet = sc.nextInt(); 
		while (bet < 10 ) {
			System.out.print("Bet must be at least $10. Enter another bet: ");
			bet = sc.nextInt(); 
		}
		player.setBet(bet);
		bet = 0;
		//sc.close();
	}

	public static void initialDeals(Deck deck, Player house, Player cpu, Player player) {

		house.clear();
		cpu.clear();
		player.clear();

		house.hit(deck.topDeck(), 0); 	
		cpu.hit(deck.topDeck(), 0); 
		cpu.hit(deck.topDeck(), 0);
		player.hit(deck.topDeck(), 0); 
		player.hit(deck.topDeck(), 0); 

		System.out.println("\nDealer cards: " + house + " unknown."); 		//game state
		System.out.println("CPU cards: " + cpu);
		System.out.println(("Player cards: "+ player));

	}

	public static void cpuTurn(Player cpu, Deck deck) {
		System.out.println("\nCPU turn.");		//CPU logic
		System.out.println("CPU's initial Cards: " + cpu);
		PlayerLogic.cpuLogic(cpu, deck); 
		System.out.println("CPU's final Cards: " + cpu);
	}

	public static void playerTurn(Player player, Deck deck) {
		System.out.println("\nYour turn.");		//player logic
		System.out.println("Your initial cards: " + player);
		PlayerLogic.playerLogic(player, deck); 
		System.out.println("Your final cards: " + player);
	}

	public static void houseTurn(Player house, Deck deck) {
		System.out.println("\nDealer's turn."); //dealer logic 
		System.out.println("Dealer's initial cards: " + house);
		PlayerLogic.houseLogic(house, deck); 
		System.out.println("Dealer's final cards: " + house);
	}


	public static void settle(Player house, Player cpu, Player player) {
		if (house.getHand(0).isBusted()) {
			System.out.println("\nValue to beat: any valid sum");
			if (!cpu.getHand(0).isBusted()) {
				cpu.win(); 
				System.out.println("CPU won!");
			}
			for (int i = 0; i < player.numHands(); i++) {
				if (!player.getHand(i).isBusted()) {
					player.win(); 
					System.out.println("Player won!");
				}
			}
		}
		else {
			int houseValue = 0;
			houseValue = house.getHand(0).sum(); 
			System.out.println("\nValue to beat: " + houseValue);

			cpuSettle(houseValue, cpu);
			playerSettle(houseValue, player); 	

		}
	}

	public static void cpuSettle(int houseValue, Player cpu) {
		int cpuValue = 0;
		cpuValue = cpu.getHand(0).sum(); 
		if (cpuValue > houseValue && cpuValue <= 21) {
			cpu.win(); 
			System.out.println("CPU won!");
		}
		else if (cpuValue < houseValue || cpuValue > 21) {
			cpu.lose(); 
			System.out.println("CPU lost!");
		}
	}

	public static void playerSettle(int houseValue, Player player) {

		int playerValue = 0;
		for (int i = 0; i < player.numHands(); i++) {
			playerValue = player.getHand(i).sum(); 
			if (playerValue > houseValue && playerValue <= 21) {
				player.win(); 
				System.out.println("You won on Hand " + i + "!");
			}
			else if (playerValue < houseValue || playerValue > 21) {
				player.lose();
				System.out.println("You lost on Hand " + i + ".");
			}
		}
	}

	public static void money(Player cpu, Player player) {
		System.out.println("\nCPU money: " + cpu.getMoney());
		System.out.println("Player money: " + player.getMoney()); 

		if (cpu.getMoney() < 10) {
			System.out.println("\nCPU does not have enough money to bet again and has been played off the table!");
			System.exit(0);
		}

		if (player.getMoney() < 10) {
			System.out.println("\nYou don't have enough money to bet again! Better luck next time.");
			System.exit(0); 
		}
	}
}