
package connect4driver;


public class Connect4Board extends GameBoard {
    
    GamePiece player1;
    GamePiece player2;
    GamePiece computer;
    GamePiece emptySlot;
    
    public Connect4Board(int height, int width){
        super(height,width);
        emptySlot=new GamePiece(' ');
        for (GamePiece[] gameBoard1 : gameBoard) {
            for (int j = 0; j < gameBoard1.length; j++) {
                gameBoard1[j] = emptySlot;
            }
        }
    }
    
    @Override
    public void print(){
        for (GamePiece[] gameBoard1 : gameBoard) {
            for (GamePiece gameBoard11 : gameBoard1) {
                System.out.print("[");
                gameBoard11.printPiece();
                System.out.print("]");
            }
            System.out.println("");
        }
    }
    
    /**
     * @param numberOfPlayers
     */
    @Override
    public void gamePieces(int numberOfPlayers){
        switch (numberOfPlayers) {
            case 1 -> {
                player1=new GamePiece('X');
                computer=new GamePiece('O');
            }
            case 2 -> {
                player1=new GamePiece('X');
                player2=new GamePiece('O');
            }
            default -> System.out.println("Game can only be played with 1 or 2 players, please re-enter the number of players and try again.");
        }
    }
    
    /**
     * @param column
     * @param player
     */
    public void placePieces(int column, int player){
        int length=(gameBoard.length-1);
        switch (player) {
            case 1 -> {
                for(int i=0;i<=length;i++){
                    if(gameBoard[0][column].piece!=emptySlot.piece){
                        System.out.println("Can't place piece here, column full. ");
                        return;
                    }
                    else if(gameBoard[i][column].piece!=emptySlot.piece){
                        gameBoard[i-1][column]=player1;
                        break;
                    }
                    else if(i==length){
                        gameBoard[i][column]=player1;
                        break;
                    }
                    
                }  }
            case 2 -> {
                for(int i=0;i<=length;i++){
                    if(gameBoard[i][column].piece!=emptySlot.piece){
                        gameBoard[i-1][column]=player2;
                        break;
                    }
                    else if(i==length){
                        gameBoard[i][column]=player2;
                        break;
                    }
                }  }
            case 0 -> {
                for(int i=0;i<=length;i++){
                    if(gameBoard[i][column].piece!=emptySlot.piece){
                        gameBoard[i-1][column]=computer;
                        break;
                    }
                    else if(i==length){
                        gameBoard[i][column]=computer;
                        break;
                    }
                }  }
            default -> {
                System.out.println("Can't place piece in that location");
            }
        }
    }    
    
}
