package connect4driver;

public abstract class GameBoard {
    
    GamePiece gameBoard[][];
    
    public GameBoard(){
       //default constructor that sets game board as null
       gameBoard=new GamePiece[0][0];
    }
    
    public GameBoard(int height, int width){
        //constructor that takes a height and width and sets gameboard size
        gameBoard=new GamePiece[height][width];
    }
    
    //prints the entire array with brackets around each piece
    public void printBoard(){
        for (GamePiece[] gameBoard1 : gameBoard) {
            for (GamePiece gameBoard11 : gameBoard1) {
                System.out.print("[");
                gameBoard11.printPiece();
                System.out.print("]");
            }
            System.out.println("");
        }
    }
    
    public abstract void gamePieces(int x,String name1, String name2); //number of different pieces used
    public abstract void placePiece(int column, int piece);
    public abstract void removePiece(int row, int column);
    
}
