//Michael Ren


/*
1. Initialize and shuffle a deck
2. Initialize the players
3. Place bets. 
4. Deal cards. One to the house, 2 to the CPU and player. 
5. [GAME ACTION] Hit, stand, split, double down. 
6. House logic. 
7. Check win. 


*/
import java.util.*;

public class BlackjackMain {

	public static void main(String[] args) {

		Player house = new Player(); 	//players
		Player cpu = new Player(); 
		Player player = new Player(); 

		boolean keepPlaying = true;
		while(keepPlaying) {

			Deck deck = new Deck();
			deck.shuffle(); 

			GameMethods.placeBets(house, cpu, player); 
			GameMethods.initialDeals(deck, house, cpu, player);

			GameMethods.cpuTurn(cpu, deck);
			GameMethods.playerTurn(player, deck); 
			GameMethods.houseTurn(house, deck); 
			
			GameMethods.settle(house, cpu, player); 
			GameMethods.money(cpu, player);

			Scanner sc = new Scanner(System.in);
			String decision;
			System.out.println("Play another round? [Y/N]"); 
			decision = sc.nextLine(); 
			if (decision.equals("N")) {
				keepPlaying = false; 
			}
			//sc.close();
		} 
		
	}


}