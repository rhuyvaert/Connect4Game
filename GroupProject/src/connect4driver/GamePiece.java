package connect4driver;

import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.*;

public class GamePiece {

    char piece;
    //private BufferedImage image;
    private String pieceName;
    
    /**
     * Default constructor
     */
    public GamePiece() {
        piece = ' ';
    }
    
    /**
     * @param x
     * @param name
     * The x parameter is a character value passed in automatically by the Connect4Board
     * class that can be used as a visual representation in the Connect4Board.print()
     * function.
     * The name parameter verifies for the gui whether to place a red piece or a 
     * black piece
     */
    public GamePiece(char x, String name){
        piece = x;
        pieceName = name;
        //image=ImageIO.read(new File(name+".png"));
    }
    
    public String getPiece(){
        return pieceName;
    }
    
    //public BufferedImage getImage()throws IOException{
        //return image;
    //}
    
    /**
     * Used by the boards print function to visualize the 2D array.
     */
    public void printPiece() {
        System.out.print(piece);
    }
}
