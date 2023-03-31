
package connect4driver;

import java.io.*;

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
    
    public abstract void gamePieces(int x)throws IOException;
    public abstract void print();
    
}
