
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
    static char p = ' ';
    
    
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
    
    //checks win condition
    public static boolean winCondition(int currentPlayer) {
        if (currentPlayer == 1){
            p = 'X';
        }else{
            p = 'O';
        }
        
        // Check horizontally
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7-3; j++){    
                if (connect4Board.returnBoard(i,j) == p &&
                    connect4Board.returnBoard(i,j+1) == p &&
                    connect4Board.returnBoard(i,j+2) == p &&
                    connect4Board.returnBoard(i,j+3) == p) {
                    return true;               
                }
            }
        }
                    
        // Check vertically
        for(int i = 0; i < 6-3; i++){
            for(int j = 0; j < 7; j++){   
                if (connect4Board.returnBoard(i,j) == p &&
                    connect4Board.returnBoard(i+1,j) == p &&
                    connect4Board.returnBoard(i+2,j) == p &&
                    connect4Board.returnBoard(i+3,j) == p) {
                    return true;              
                }
            }
        }              
        
        // Check diagonally (bottom-left to top-right)
        for(int i = 3; i < 6; i++){
            for(int j = 0; j < 7-3; j++){   
                if (connect4Board.returnBoard(i,j) == p &&
                    connect4Board.returnBoard(i-1,j+1) == p &&
                    connect4Board.returnBoard(i-2,j+2) == p &&
                    connect4Board.returnBoard(i-3,j+3) == p) {
                    return true;                
                }
            }
        }
        
        // Check diagonally (top-left to bottom-right)
        for(int i = 3; i < 6-3; i++){
            for(int j = 0; j < 7-3; j++){  
                if (connect4Board.returnBoard(i,j) == p &&
                    connect4Board.returnBoard(i+1,j+1) == p &&
                    connect4Board.returnBoard(i+2,j+2) == p &&
                    connect4Board.returnBoard(i+3,j+3) == p) {
                    return true;               
                }
            }
        }
        return false;
    }
    
    public static void changePlayer(){
        if (currentPlayer == 1) {
                currentPlayer = 2;
            } else {
                currentPlayer = 1;
            }
    }
    
//    public static void easyComputer(){
    //easy mode computer opponent
//    }
}