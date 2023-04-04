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
    
    public abstract void gamePieces(int x);
    public abstract void print();
    public abstract void placePiece(int column, int piece);
    public abstract void removePiece(int row, int column);
    
}
