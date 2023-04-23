package connect4driver;

import java.util.Scanner;

//debug mode that allows the game to be played in the command line interface
public class GameBoardCLI {

    Scanner input = new Scanner(System.in);

    private final int row;
    private final int column;
    private int currentPlayer, numberOfPlayers, turn;
    private String name1, name2;
    boolean winner = false;
    boolean draw = false;
    private Connect4Board board;

    public GameBoardCLI(int x, int y, Connect4Board gameBoard) {
        row = x;
        column = y;
        currentPlayer = GameDriver.currentPlayer;
        board = gameBoard;
    }
    
    //initializes the cli game
    public void initGame() {
        System.out.print("Please enter the number of players: ");
        GameDriver.numberOfPlayers = input.nextInt();
        numberOfPlayers = GameDriver.numberOfPlayers;
        if (numberOfPlayers == 1) {
            System.out.print("Enter the name for the first Player: ");
            name1 = input.next();
            GameDriver.name1 = name1;
            name2 = "Computer";
            GameDriver.name2 = name2;
        } else if (numberOfPlayers == 2) {
            System.out.print("Enter the name for the first Player: ");
            name1 = input.next();
            GameDriver.name1 = name1;
            System.out.print("\nEnter the name for the second Player: ");
            name2 = input.next();
            GameDriver.name2 = name2;
        }
    }

    public void playGame() {
        //alternate turns in placing piece
        int columnPlaced;
        while (winner == false && turn < 42) {
            if (GameDriver.currentPlayer == 1) {
                System.out.print(name1 + "'s turn - choose a column (1-7) to place your piece: ");
                columnPlaced = input.nextInt() - 1;
                board.placePiece(columnPlaced, 1);
                board.printBoard();
            } else if (GameDriver.currentPlayer == 2) {
                System.out.print(name2 + "'s turn - choose a column (1-7) to place your piece: ");
                columnPlaced = input.nextInt() - 1;
                board.placePiece(columnPlaced, 2);
                board.printBoard();
            }
            if (turn >= 6) {
                winner = GameDriver.winCondition(GameDriver.currentPlayer);
                if (winner) {
                    winner = true;
                    break;
                }
            }
            GameDriver.changePlayer();
            turn++;
        }
        if (turn == 42) {
            draw = true;
        }
    }

    public int gameWon() {
        if (GameDriver.currentPlayer == 1) {
            System.out.println(name1 + " won the game");
        } else {
            System.out.println(name2 + " won the game");
        }
        System.out.print("Would you like to play again?(Y/N): ");
        char response = input.next().charAt(0);
        if (response == 'Y' || response == 'y') {
            return 3;
        } else {
            return 4;
        }
    }

    public int gameDraw() {
        System.out.println("The game was a tie");
        System.out.print("Would you like to play again?(Y/N): ");
        char response = input.next().charAt(0);
        if (response == 'Y' || response == 'y') {
            return 3;
        } else {
            return 4;
        }
    }
}
