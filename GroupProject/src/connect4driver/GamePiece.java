package connect4driver;

import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.*;

public class GamePiece {

    char piece;
    //private BufferedImage image;
    private String pieceName;

    public GamePiece() {
        piece = ' ';
    }

    public GamePiece(char x, String name)throws IOException {
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
    
    public void printPiece() {
        System.out.print(piece);
    }
}
