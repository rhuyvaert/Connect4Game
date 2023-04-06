package connect4driver;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class GameDriver {

    static Scanner input = new Scanner(System.in);
    static boolean winner=false;
    static int turn=0;
    static int currentPlayer=1;
    static int numberOfPlayers, columnPlaced;
    static String name1, name2;
    static Connect4Board connect4Board = new Connect4Board(6, 7);
    static int runtime=0;
    
    
    public static void main(String[] args) {
         //create game board
        GameBoardGUI gui = new GameBoardGUI(7,6,connect4Board);
        gui.initGame();
        gui.initBoard();
        connect4Board.gamePieces(numberOfPlayers, name1, name2); //create game piece for each player
        while(runtime!=-1){
            switch(runtime){
                case 0 -> {
                    gui.updateBoard();
                    if(gui.winner){
                        runtime=1;
                    }
                    else if(gui.draw){
                        runtime=2;
                    }
                }
                case 1 -> {
                    //gui win message
                    //if play again == true
                        //runtime=3
                    //else
                        //runtime=-1
                }
                case 2 -> {
                    //gui draw message
                    //if play again == true
                        //runtime=3
                    //else
                        //runtime=-1
                }
                case 3 ->{
                    //reset gameboard
                    //reset gui
                    //runtime =0
                }
            }       
        }
    }
        
        //print a screen if theres a winner and who won
        //save to a file the current state of the game after every turn
        //asks players if they want to play again
    
    public static boolean winCondition(int currentPlayer) {
        // Check horizontally
        // Check vertically
        // Check diagonally (top-left to bottom-right)
        // Check diagonally (bottom-left to top-right)
        return winner;
    }
    
    public static void changePlayer(){
        if (currentPlayer == 1) {
                currentPlayer = 2;
            } else {
                currentPlayer = 1;
            }
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
