package connect4driver;

import java.util.*;

public class GameDriver {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfPlayers, columnPlaced;
        boolean winner = false;
        int turn = 0;

        //create game board
        Connect4Board connect4Board = new Connect4Board(6, 7);

        System.out.print("Please enter the number of players: ");
        numberOfPlayers = input.nextInt();

        String name1 = "", name2 = "";

        // enter names for each player
        if (numberOfPlayers == 1) {
            System.out.println("Enter the name for first Player: ");
            //input.nextLine(); 
            name1 = input.nextLine();

            name2 = "Computer";
        } else if (numberOfPlayers == 2) {
            System.out.println("Enter the name for first Player: ");
            //input.nextLine(); 
            name1 = input.nextLine();

            System.out.println("Enter the name for the second Player: ");
            name2 = input.nextLine();
        }

        //create game piece for each player
        connect4Board.gamePieces(numberOfPlayers, name1, name2);

        int currentPlayer = 1;

        //alternate turns in placing piece
        while (winner == false && turn < 42) {
            if (currentPlayer == 1) {
                System.out.print(name1 + "'s turn - choose a column (1-7) to place your piece: ");
                columnPlaced = input.nextInt();
                connect4Board.placePiece(columnPlaced, 1);
            } else if (currentPlayer == 2) {
                System.out.print(name2 + "'s turn - choose a column (1-7) to place your piece: ");
                columnPlaced = input.nextInt();
                connect4Board.placePiece(columnPlaced, 2);
            }

            //print the gameboard
            connect4Board.printBoard();

            //check win conditions
            if (turn >= 6) {
                winner = winCondition(connect4Board, currentPlayer);
            }

            //switch players
            if (currentPlayer == 1) {
                currentPlayer = 2;
            } else {
                currentPlayer = 1;
            }

            turn++;
        }

        if (winner) {
            if (currentPlayer == 1) {
                System.out.println(name1 + "won the game");
            } else {
                System.out.println(name2 + "won the game");
            }
        } else {
            System.out.println("The game is a tie");
        }
        /*   
        //play against computer if only one player
        if (numberOfPlayers == 1) {
            easyComputer();        
        }
        
         */
        //if only one player than uses a seperate loop to allow the player to play against the computer(multiple difficulties?)
        //randomizer that decides which player goes first
        //loop that lets each player place one piece then checks the win conditions function
        //print the game board or show a GUI of it that updates when each piece is placed
        //print a screen if theres a winner and who won
        //save to a file the current state of the game after every turn
        //asks players if they want to play again
  
    
    public static boolean winCondition(Connect4Board connect4Board, int currentPlayer) {

        // Check horizontally
        // Check vertically
        // Check diagonally (top-left to bottom-right)
        // Check diagonally (bottom-left to top-right)
    }

    /*
    public static boolean winCondition(){
        boolean winner=false;
            return winner;
        
        //after each move checks if theres a winner, only have to start checking after fourth move has been played
        //have to check in 8 directions(dont ever have to check above the piece)
        //can rule out possible wins in certain directions if placed piece is less than 3 spaces from edge of board
        //first check 3 spots out from placed piece first
        //returns a true or false if theres a winner
    }
     */
//    public static void easyComputer(){
    //easy mode computer opponent
//    }
}

}
