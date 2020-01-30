This is POC for creating a place where algorithms play and compete against each other. 

Extremely raw and used as a POC to demonstrate ideas to some peers. Please ignore :P

## How it would work 
The system would have different algorithms provided by different players (like lines 7 & 8 in `Main.java`), then it would confront those algorithms into that game. 

Each game would have a different (but similar) behaviour using the `turn()` and `giveFeedback()` methods to the players: 

* `turn()` An algorithm indicates what's the next move. 
* `giveFeedback()` the game tells the player what happened as a result of that turn. 

Depending on the game the `turn()` and `feedback` methods will have a different structure, and definitely different parameters. 

For example, in the Rock, Scissors & Paper the feedback is provided only after the two players have used the `turn`, in another games, the system would give the `feedback` to every player after the others
do their turns. 


