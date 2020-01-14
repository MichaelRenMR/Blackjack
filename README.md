# Blackjack
A simple Blackjack game coded in Java utilizing objected oriented programming. Runs in terminal. Features a dealer class, player class, and CPU class which plays according to predetermined rules. Double downs and splits are fully implemented as well. 

## Code Parts
### BlackjackMain.java 
The main driver code for the game. 

### Card.java 
Code for the card object. Utilized by the `Deck` class and `Hand` class.

### Deck.java
Code for the deck object. Utilizes the `Card` class. 

### GameMethods.java 
Responsible for the main methods which BlackjackMain calls on to run the game. Included methods: 

* `placeBets()` allows each player in the game to place their bet for the round.
* `initialDeals()` deals cards to each player for the first round of betting. 
* `cpuTurn()` initiates the CPU's turn (distinct from the dealer/house!) and points to `PlayerLogic.java`.
* `playerTurn()` initiates the player's turn and points to `PlayerLogic.java`.
* `houseTurn()` initiates the house's turn and points to `PlayerLogic.java`.
* `settle()` is called at the end of a complete round to allocate money accordingly based on the bets for that round.
* `cpuSettle()` and `playerSettle()` are helper methods for `settle()` which serve to settle the CPU and player's bets. 
* `money()` serves as a toString method for the current gamestate by displaying the CPU and player's money at the end of a round.

### Hand.java 
Code for a player's current hand. Utilized by the `Player` class.' Utilizes the `Card` class. Written to support dynamic summing with aces. 

### Player.java
Code for attributes every player (including CPU and house) should have. Utilizes the `Hand` class. Keeps track of splits, hits, bets, and money. 

### PlayerLogic.java 
Driver code for how the CPU and house play the game as well as player inputs. 



