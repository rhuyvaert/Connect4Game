package connect4driver;

import static connect4driver.GameDriver.connect4Board;
import java.util.Random;

public class ComputerOpponent {
    
    private int[] columnRanking;
    private int bestColumn, secBestColumn, worstColumn,difficulty;
    Random rand=new Random();
    
    public ComputerOpponent(){
        columnRanking=new int[]{1,2,3,4,5,6,7};
        bestColumn=0;secBestColumn=1;worstColumn=6;
    }
    
    public void rankColumns(){
        char p='X';
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7-2; j++){    
                if (connect4Board.returnBoard(i,j) == p &&
                    connect4Board.returnBoard(i,j+1) == p &&
                    connect4Board.returnBoard(i,j+2) == p) 
                    columnRanking[j+3]=1;
                else if(connect4Board.returnBoard(i,j) == p &&
                    connect4Board.returnBoard(i,j+1) == p)
                    columnRanking[j+2]=2;
                else if(connect4Board.returnBoard(i,j) == p)
                    columnRanking[j+1]=3;
                else if(connect4Board.returnBoard(i,j+1)==p||
                        connect4Board.returnBoard(i,j-1)==p)
                    columnRanking[j]=4;
                else
                    columnRanking[j]=5;
                }            
        }
        for(int i = 0; i < 6-2; i++){
            for(int j = 0; j < 7; j++){   
                if (connect4Board.returnBoard(i,j) == p &&
                    connect4Board.returnBoard(i+1,j) == p &&
                    connect4Board.returnBoard(i+2,j) == p)
                    columnRanking[j]=1;
                else if(connect4Board.returnBoard(i,j) == p &&
                    connect4Board.returnBoard(i+1,j) == p)
                    columnRanking[j]=2;
                else if(connect4Board.returnBoard(i, j)==p)
                    columnRanking[j]=3;
                else
                    columnRanking[j]=4;
            }
        }              
        for(int i = 3; i < 6; i++){
            for(int j = 0; j < 7-3; j++){   
                if (connect4Board.returnBoard(i,j) == p &&
                    connect4Board.returnBoard(i-1,j+1) == p &&
                    connect4Board.returnBoard(i-2,j+2) == p)
                    columnRanking[j]=1;
                else if(connect4Board.returnBoard(i,j) == p &&
                    connect4Board.returnBoard(i-1,j+1) == p)
                    columnRanking[j]=2;
                else if(connect4Board.returnBoard(i,j) == p)
                    columnRanking[j]=3;
                else
                    columnRanking[j]=4;
            }
        }
        for(int i = 0; i < 6-3; i++){
            for(int j = 0; j < 7-3; j++){  
                if (connect4Board.returnBoard(i,j) == p &&
                    connect4Board.returnBoard(i+1,j+1) == p &&
                    connect4Board.returnBoard(i+2,j+2) == p)
                    columnRanking[j]=1;
                else if(connect4Board.returnBoard(i,j) == p &&
                    connect4Board.returnBoard(i+1,j+1) == p)
                    columnRanking[j]=2;
                else if(connect4Board.returnBoard(i,j) == p)
                    columnRanking[j]=3;
                else
                    columnRanking[j]=4;
            }
        }
        for(int i=0;i<7;i++){
            switch (columnRanking[i]) {
                case 1 -> bestColumn=i;
                case 2 -> secBestColumn=i;
                case 5 -> worstColumn=i;
                default -> {
                }
            }
        }
    }
    
    public void difficulty(int diff){
        switch(diff){
            case 0-> difficulty=4;
            case 1-> difficulty=3;
            case 2-> difficulty=2;
            default-> difficulty=1;
        }
    }
    
    public int placePiece(){
        return switch (difficulty) {
            case 1 -> bestColumn;
            case 2 -> secBestColumn;
            case 3 -> rand.nextInt(6);
            default -> worstColumn;
        };
    }
}
