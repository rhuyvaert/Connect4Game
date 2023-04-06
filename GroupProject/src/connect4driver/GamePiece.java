package connect4driver;

public class GamePiece {

    private char piece;
    private String pieceName;
    private String playerName;
    
    /**
     * Default constructor
     */
    public GamePiece() {
        piece = ' ';
    }
    
    /**
     * @param x
     * @param color
     * @param name
     * The x parameter is a character value passed in automatically by the Connect4Board
     * class that can be used as a visual representation in the Connect4Board.print()
     * function.
     * The name parameter verifies for the gui whether to place a red piece or a 
     * black piece
     */
    public GamePiece(char x, String color, String name){
        piece = x;
        pieceName = color;
        playerName= name;
    }
    
    //returns the player name assigned to that piece
    public String getName(){
        return playerName;
    }
    
    //returns the color of that piece
    public char getPiece(){
        return piece;
    }
    
    //prints out the character assigned to that piece for CLI and debugging purposes
    public void printPiece() {
        System.out.print(piece);
    }
}
