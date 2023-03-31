
package connect4driver;

import java.util.*;

public class GroupProject {
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        int numberOfPlayers, columnPlaced;
        Connect4Board connect4Board=new Connect4Board(6,7); //create game board
        System.out.print("Please enter the number of players: ");
        numberOfPlayers=input.nextInt(); //two seperate loops first for 2 players, second for one player vs computer
        connect4Board.gamePieces(numberOfPlayers); //create game piece for each player
            //if only one player than uses a seperate loop to allow the player to play against the computer(multiple difficulties?)
        //randomizer that decides which player goes first
        //loop that lets each player place one piece then checks the win conditions function
        //print the game board or show a GUI of it that updates when each piece is placed
        //print a screen if theres a winner and who won
        //save to a file the current state of the game after every turn
        //asks players if they want to play again
    }
    
    public static boolean winCondition(){
        boolean winner=false;
        //after each move checks if theres a winner, only have to start checking after fourth move has been played
        //have to check in 8 directions(dont ever have to check above the piece)
        //can rule out possible wins in certain directions if placed piece is less than 3 spaces from edge of board
        //returns a true or false if theres a winner
        return winner;
    }
    
    public static void easyComputer(){
        //easy mode computer opponent
    }
    
}
