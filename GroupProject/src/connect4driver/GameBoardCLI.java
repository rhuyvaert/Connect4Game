package connect4driver;

import java.util.Scanner;

public class GameBoardCLI {
    
    Scanner input = new Scanner(System.in);
    
    private final int row;
    private final int column;
    private int currentPlayer;
    private int numberOfPlayers;
    private String name1, name2;
    
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
}
