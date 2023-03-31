
package connect4driver;


public class GamePiece {
        char piece;
    public GamePiece(){
        piece=' ';
    }
    
    public GamePiece(char x){
        piece=x;
    }
    
    public void printPiece(){
        System.out.print(piece);
    }
}
