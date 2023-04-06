
package connect4driver;

public class Connect4Board extends GameBoard {
    
    private GamePiece player1;
    private GamePiece player2;
    private GamePiece computer;
    private final GamePiece emptySlot;
    
    public Connect4Board(int height, int width){
        super(height,width);
        emptySlot=new GamePiece(' ',"emptyPiece","Blank");
        for (GamePiece[] gameBoard1 : gameBoard) {
            for (int j = 0; j < gameBoard1.length; j++) {
                gameBoard1[j] = emptySlot;
            }
        }
    }
    
    public void printBoard(){
        super.printBoard();
    }
    
    /**
     * @param numberOfPlayers
     * Passed in parameters is number of players playing the game.
     */
    @Override
    public void gamePieces(int numberOfPlayers,String name1, String name2){
        switch (numberOfPlayers) {
            case 1 -> {
                player1=new GamePiece('X',"redPiece",name1);
                computer=new GamePiece('O',"blackPiece", name2);
            }
            case 2 -> {
                player1=new GamePiece('X',"redPiece", name1);
                player2=new GamePiece('O',"blackPiece", name2);
            }
            default -> System.out.println("Game can only be played with 1 or 2 players, please re-enter the number of players and try again.");
        }
    }
    
    /**
     * @param column
     * @param player
     * Parameters are the column the player wants the place the piece in
     * and which players turn it is, the main driver should automatically pass this 
     * in without any input from user.
     */
    @Override
    public void placePiece(int column, int player){
        int length=(gameBoard.length-1);
        switch (player) {
            case 1 -> {
                for(int i=0;i<=length;i++){
                    if(gameBoard[0][column].getPiece()!=emptySlot.getPiece()){
                        System.out.println("Can't place piece here, column full. ");
                        return;
                    }
                    else if(gameBoard[i][column].getPiece()!=emptySlot.getPiece()){
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
                    if(gameBoard[i][column].getPiece()!=emptySlot.getPiece()){
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
                    if(gameBoard[i][column].getPiece()!=emptySlot.getPiece()){
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
    
    //checks if a column is empty or full
    public boolean checkColumn(int x){
        return gameBoard[0][x].getPiece()!=emptySlot.getPiece(); //the column is full
    }
    
    /**
     * @param row
     * @param column
     * removes a piece from a specific location of the board.
     */
    @Override
    public void removePiece(int row,int column){
        gameBoard[row][column]=emptySlot;
    }
    
    public char returnPiece(int row, int column){
        return gameBoard[column][row].getPiece();
    }
}
