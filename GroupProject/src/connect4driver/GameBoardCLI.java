
package connect4driver;

import static connect4driver.GameDriver.connect4Board;
import java.util.Scanner;

public class GameBoardCLI {
    
    Scanner input = new Scanner(System.in);
    
    private final int row;
    private final int column;
    private int currentPlayer, numberOfPlayers, turn;
    private String name1, name2;
    private boolean winner;
    
    public GameBoardCLI(int x, int y, Connect4Board gameBoard){
        row=x;
        column=y;
        currentPlayer=GameDriver.currentPlayer;
    }
    
    public void initGame(){
        System.out.println("Please enter the number of players: ");
        GameDriver.numberOfPlayers=input.nextInt();
        numberOfPlayers=GameDriver.numberOfPlayers;
        if (numberOfPlayers== 1) {
            System.out.print("Enter the name for the first Player: ");
            name1 = input.nextLine();
            GameDriver.name1=name1;
            name2 = "Computer";
            GameDriver.name2=name2;
        } else if (numberOfPlayers == 2) {
            System.out.print("Enter the name for the first Player: "); 
            name1 = input.nextLine();
            GameDriver.name1=name1;
            System.out.print("\nEnter the name for the second Player: ");
            name2 = input.nextLine();
            GameDriver.name2=name2;
        }
    }
    
    public void playGame(){
        //alternate turns in placing piece
        int columnPlaced;
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
            connect4Board.printBoard();
            if (turn >= 6) {
                winner = GameDriver.winCondition(currentPlayer);
                if (winner){
                    winner();
                    break;}
            }
            GameDriver.changePlayer();
            turn++;
        }
        if (turn==42)
            winner();
                
    }
    
    public void winner(){
        if (winner) {
            if (currentPlayer == 1) {
                System.out.println(name1 + "won the game");
            } else {
                System.out.println(name2 + "won the game");
            }
        } else {
            System.out.println("The game is a tie");
        }
    }
}
