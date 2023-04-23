package connect4driver;

import static connect4driver.GameDriver.connect4Board;
import java.util.Random;

public class ComputerOpponent {

    private int[] columnRanking;
    private static int bestColumn, secBestColumn, randColumn, worstColumn, difficulty;
    static Random rand = new Random();

    public ComputerOpponent(int x) {
        columnRanking = new int[]{1, 2, 3, 4, 5, 6, 7};
        bestColumn = 0;
        secBestColumn = 1;
        randColumn = 3;
        worstColumn = 6;
        difficulty(x);
    }
    
    
    //uses a weighted system based on the win condition function to assign ranked values
    //to the 7 different columns.
    public void rankColumns() {
        char p = 'X';
        char e = ' ';
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7 - 2; j++) {
                if (connect4Board.returnBoard(i, j) == p
                        && connect4Board.returnBoard(i, j + 1) == p
                        && connect4Board.returnBoard(i, j + 2) == p) {
                    columnRanking[j + 3] = 1;
                } else if (connect4Board.returnBoard(i, j) == p
                        && connect4Board.returnBoard(i, j + 1) == p) {
                    columnRanking[j + 2] = 2;
                } else if (connect4Board.returnBoard(i, j) == p) {
                    columnRanking[j + 1] = 3;
                } else if (connect4Board.returnBoard(i, j + 1) == p) {
                    columnRanking[j] = 4;
                } else {
                    columnRanking[j] = 6;
                }
            }
        }
        for (int i = 0; i < 6 - 2; i++) {
            for (int j = 0; j < 7; j++) {
                if (connect4Board.returnBoard(i, j) == p
                        && connect4Board.returnBoard(i + 1, j) == p
                        && connect4Board.returnBoard(i + 2, j) == p) {
                    columnRanking[j] = 1;
                } else if (connect4Board.returnBoard(i, j) == p
                        && connect4Board.returnBoard(i + 1, j) == p) {
                    columnRanking[j] = 2;
                } else if (connect4Board.returnBoard(i, j) == p) {
                    columnRanking[j] = 3;
                } else {
                    columnRanking[j] = 4;
                }
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 7 - 3; j++) {
                if (connect4Board.returnBoard(i, j) == p
                        && connect4Board.returnBoard(i - 1, j + 1) == p
                        && connect4Board.returnBoard(i - 2, j + 2) == p) {
                    columnRanking[j] = 1;
                } else if (connect4Board.returnBoard(i, j) == p
                        && connect4Board.returnBoard(i - 1, j + 1) == p) {
                    columnRanking[j] = 2;
                } else if (connect4Board.returnBoard(i, j) == p) {
                    columnRanking[j] = 3;
                } else {
                    columnRanking[j] = 4;
                }
            }
        }
        for (int i = 0; i < 6 - 3; i++) {
            for (int j = 0; j < 7 - 3; j++) {
                if (connect4Board.returnBoard(i, j) == p
                        && connect4Board.returnBoard(i + 1, j + 1) == p
                        && connect4Board.returnBoard(i + 2, j + 2) == p) {
                    columnRanking[j] = 1;
                } else if (connect4Board.returnBoard(i, j) == p
                        && connect4Board.returnBoard(i + 1, j + 1) == p) {
                    columnRanking[j] = 2;
                } else if (connect4Board.returnBoard(i, j) == p) {
                    columnRanking[j] = 3;
                } else {
                    columnRanking[j] = 4;
                }
            }
        }
        columnRankings();
    }
    
    //for each of the 4 difficulty options it selects the next corresponding move
    //to be played by the computer
    public void columnRankings() {
        int storedColumn = -1, storedColumnRank = 8, storedColumn2 = -1, storedColumnRank2 = 8;
        boolean fullCheck;
        for (int i = 0; i < 7; i++) {
            fullCheck = connect4Board.checkColumn(i);
            if (fullCheck) {
                continue;
            }
            bestColumn = -1;
            secBestColumn = -1;
            switch (columnRanking[i]) {
                case 1 -> {
                    if (bestColumn == -1) {
                        bestColumn = i;
                    } else if (secBestColumn == -1) {
                        secBestColumn = i;
                        break;
                    }
                }
                case 2 -> {
                    if (bestColumn != -1 || secBestColumn == -1) {
                        secBestColumn = i;
                        break;
                    } else if (bestColumn != -1 || secBestColumn != -1) {
                        storedColumn2 = i;
                        storedColumnRank2 = 2;
                    }
                    storedColumn = i;
                    storedColumnRank = 2;
                }
                case 3 -> {
                    if (storedColumnRank <= 3) {
                        if (storedColumnRank2 <= 3) {
                            continue;
                        }
                        storedColumn2 = i;
                        storedColumnRank2 = 3;
                        continue;
                    }
                    storedColumn = i;
                    storedColumnRank = 3;
                }
                case 4 -> {
                    if (storedColumnRank <= 4) {
                        if (storedColumnRank2 <= 4) {
                            continue;
                        }
                        storedColumn2 = i;
                        storedColumnRank2 = 4;
                        continue;
                    }
                    storedColumn = i;
                    storedColumnRank = 4;
                }
                case 5 -> {
                    if (storedColumnRank <= 5) {
                        if (storedColumnRank2 <= 5) {
                            continue;
                        }
                        storedColumn2 = i;
                        storedColumnRank2 = 5;
                        continue;
                    }
                    storedColumn = i;
                    storedColumnRank = 5;
                }
                case 6 -> {
                    if (storedColumnRank <= 6) {
                        if (storedColumnRank2 <= 6) {
                            continue;
                        }
                        storedColumn2 = i;
                        storedColumnRank2 = 6;
                        continue;
                    }
                    storedColumn = i;
                    storedColumnRank = 6;
                }
                case 7 -> {
                    if (storedColumnRank <= 7) {
                        if (storedColumnRank2 <= 7) {
                            continue;
                        }
                        storedColumn2 = i;
                        storedColumnRank2 = 7;
                        continue;
                    }
                    storedColumn = i;
                    storedColumnRank = 7;
                }
            }
        }
        if (bestColumn == -1 || secBestColumn == -1) {
            if (storedColumn != -1 || storedColumn2 != -1) {
                bestColumn = storedColumn;
                secBestColumn = storedColumn2;
            } else if (storedColumn2 == -1) {
                bestColumn = storedColumn;
                secBestColumn = storedColumn;
            }
        } else if (secBestColumn == -1) {
            if (storedColumn == -1) {
                secBestColumn = bestColumn;
            }
            secBestColumn = storedColumn;
        }
        for (int i = 0; i < 7; i++) {
            storedColumn = -1;
            storedColumnRank = 1;
            fullCheck = connect4Board.checkColumn(i);
            if (fullCheck) {
                continue;
            } else if (i == bestColumn || i == secBestColumn) {
                continue;
            }
            switch (columnRanking[i]) {
                case 1 -> {
                    if (storedColumnRank < 1) {
                        continue;
                    }
                    storedColumn = i;
                    storedColumnRank = 1;
                }
                case 2 -> {
                    if (storedColumnRank <= 2) {
                        continue;
                    }
                    storedColumn = i;
                    storedColumnRank = 2;
                }
                case 3 -> {
                    if (storedColumnRank <= 3) {
                        continue;
                    }
                    storedColumn = i;
                    storedColumnRank = 3;
                }
                case 4 -> {
                    if (storedColumnRank <= 4) {
                        continue;
                    }
                    storedColumn = i;
                    storedColumnRank = 4;
                }
                case 5 -> {
                    if (storedColumnRank <= 5) {
                        continue;
                    }
                    storedColumn = i;
                    storedColumnRank = 5;
                }
                case 6 -> {
                    if (storedColumnRank <= 6) {
                        continue;
                    }
                    storedColumn = i;
                    storedColumnRank = 6;
                }
                case 7 -> {
                    if (worstColumn == -1) {
                        worstColumn = i;
                        break;
                    }
                }
            }
        }
        if (worstColumn == 0) {
            if (storedColumn == -1) {
                worstColumn = secBestColumn;
            }
            worstColumn = storedColumn;
        }
        fullCheck = false;
        int rng;
        do {
            rng = rand.nextInt(0, 7);
            fullCheck = connect4Board.checkColumn(rng);
            if (fullCheck == false) {
                randColumn = rng;
                break;
            }
        } while (fullCheck);
    }
    
    /*the 4 difficulties that can be selected for the cpu, the hardest always plays
    the best move, the second hardest plays the second best move, the third difficult
    plays a random move decided by a random number generator and the easiest plays
    the worst move available*/
    public void difficulty(int diff) {
        switch (diff) {
            case 0 ->
                difficulty = 4; //hardest difficuly
            case 1 ->
                difficulty = 3;
            case 2 ->
                difficulty = 2;
            default ->
                difficulty = 1; //easiest difficulty
        }
    }
    
    //function called by game to place the cpu's piece
    public static int placePiece() {
        return switch (difficulty) {
            case 1 ->
                bestColumn;
            case 2 ->
                secBestColumn;
            case 3 ->
                randColumn;
            default ->
                worstColumn;
        };
    }
}
