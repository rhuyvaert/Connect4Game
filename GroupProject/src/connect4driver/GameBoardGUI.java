package connect4driver;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JOptionPane;

public class GameBoardGUI {

    static JFrame frame;
    private static JPanel panel;
    private static JLabel[][] slots;
    private static JButton[] buttons;

    private static int row;
    private static int column;
    static int currentPlayer;

    static boolean winner = false;
    static boolean draw = false;
    
    private static String imgFolder = "C:/Users/rhuyv/OneDrive - Indiana University/Git/GroupProject";
    ImageIcon redCircle = new ImageIcon("redPiece.png");
    ImageIcon blackCircle = new ImageIcon("blackPiece.png");

    static Connect4Board board;
    static ComputerOpponent cpu;

    /**
     * Constructor for the GUI
     *
     * @param x row length of the board
     * @param y column length of the board
     * @param gameBoard loads a copy of the game board to the gui
     */
    public GameBoardGUI(int x, int y, Connect4Board gameBoard) {
        row = x;
        column = y;
        currentPlayer = GameDriver.currentPlayer;
        frame = new JFrame("Connect 4");
        panel = (JPanel) frame.getContentPane();
        panel.setLayout(new GridLayout(row, column + 1));
        slots = new JLabel[row][column];
        buttons = new JButton[row];
        board = gameBoard;
    }

    //initializes the information for the game
    public void initGame() {
        int a = -1;
        while (a < 0) {
            String players = "";
            players = JOptionPane.showInputDialog(frame, "Please enter the number of players: ", "Starting the game", JOptionPane.QUESTION_MESSAGE);
            char response = players.charAt(0);
            if (response == '1' || response == '2') {
                GameDriver.numberOfPlayers = Integer.parseInt(players);
                a++;
                break;
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter either 1 or 2 players", "", JOptionPane.WARNING_MESSAGE);
            }
        }
        a = -1;
        if (GameDriver.numberOfPlayers == 1) {
            while (a < 0) {
                GameDriver.name1 = JOptionPane.showInputDialog(frame, "Please enter the name of the player: ", "Starting the game", JOptionPane.QUESTION_MESSAGE);
                if (GameDriver.name1.length() > 0) {
                    a++;
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter the name of the player!", "", JOptionPane.WARNING_MESSAGE);
                }
            }
            String[] responses = {"Easy", "Medium", "Hard", "Extreme"};
            int difficulty = JOptionPane.showOptionDialog(panel, "Choose computer difficulty", "Difficulty Setting", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, responses, responses[0]);
            GameDriver.name2 = "Computer";
            cpu = new ComputerOpponent(difficulty);
        } else if (GameDriver.numberOfPlayers == 2) {
            while (a < 0) {
                GameDriver.name1 = JOptionPane.showInputDialog(frame, "Please enter the name of player 1: ", "Starting the game", JOptionPane.QUESTION_MESSAGE);
                if (GameDriver.name1.length() > 0) {
                    a++;
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter the name of player 1!", "", JOptionPane.WARNING_MESSAGE);
                }
            }
            a = -1;
            while (a < 0) {
                GameDriver.name2 = JOptionPane.showInputDialog(frame, "Please enter the name of player 2: ", "Starting the game", JOptionPane.QUESTION_MESSAGE);
                if (GameDriver.name2.length() > 0) {
                    a++;
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter the name of player 2!", "", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        GameDriver.currentName = GameDriver.name1;
    }

    //initializes the board for the game
    public static void initBoard() {
        for (int i = 0; i < row; i++) {
            frame.setTitle("Connect 4 - player " + GameDriver.name1 + "'s turn");
            buttons[i] = new JButton("" + (i + 1));
            buttons[i].setBackground(Color.white);
            buttons[i].setIcon(new javax.swing.ImageIcon("black-triangle-icon-7.png"));
            buttons[i].setBorder(BorderFactory.createEtchedBorder(0));
            buttons[i].setActionCommand("" + i);
            buttons[i].addActionListener(new placePiece_ActionListener());
            panel.add(buttons[i]);
        }
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                slots[j][i] = new JLabel();
                slots[j][i].setHorizontalAlignment(SwingConstants.CENTER);
                slots[j][i].setBorder(new LineBorder(Color.BLACK));
                panel.add(slots[j][i]);
            }
        }

        frame.setContentPane(panel);
        frame.setSize(1050, 900);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board.returnPiece(i, j) == 'X') {
                    slots[i][j].setIcon(redCircle);
                }
                if (board.returnPiece(i, j) == 'O') {
                    slots[i][j].setIcon(blackCircle);
                }
            }
        }
    }

    public static void placePiece(int columnPlaced) {
        boolean fullCheck;
        int cpuMove;
        fullCheck = board.checkColumn(columnPlaced);
        if (fullCheck == false) {
            board.placePiece(columnPlaced, GameBoardGUI.currentPlayer);
            winner = GameDriver.winCondition(GameBoardGUI.currentPlayer);
            if (winner) {
                GameDriver.runtime = 1;
            } else if (GameDriver.turn == 41) {
                GameDriver.runtime = 2;
            }
            GameDriver.turn++;
        } else {
            JOptionPane.showMessageDialog(null, "choose a different column", "column is full", JOptionPane.INFORMATION_MESSAGE);
        }
        if (GameDriver.numberOfPlayers == 1) {
            cpu.rankColumns();
            cpu.columnRankings();
            cpuMove = cpu.placePiece();
            fullCheck = board.checkColumn(cpuMove);
            board.placePiece(cpuMove, 0);
            winner = GameDriver.winCondition(GameBoardGUI.currentPlayer);
            if (winner) {
                GameDriver.runtime = 1;
            } else if (GameDriver.turn == 41) {
                GameDriver.runtime = 2;
            }
            GameDriver.turn++;
        }
        else if (GameDriver.numberOfPlayers==2){
            GameDriver.changePlayer();
            GameBoardGUI.currentPlayer = GameDriver.currentPlayer;
        }
    }

    public void reset() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                slots[i][j].setOpaque(false);
                slots[i][j].setBackground(Color.white);
                slots[i][j].setIcon(null);
            }
        }
        winner = false;
        currentPlayer = 1;
        frame.setTitle("Connect 4 - player " + GameDriver.name1 + "'s turn");
    }

    public int gameWon() {
        String[] responses = {"Play Again?", "End Game"};
        if(GameDriver.numberOfPlayers==2)
            GameDriver.changePlayer();
        int answer = JOptionPane.showOptionDialog(panel, GameDriver.currentName + " has won", "Winner", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, responses, 0);
        if (answer == 0) {
            answer = 3;
        } else {
            answer = 4;
        }
        return answer;
    }

    public int gameDraw() {
        String[] responses = {"Play Again?", "End Game"};
        int answer = JOptionPane.showOptionDialog(panel, "The game is a draw", "Draw", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, responses, 0);
        if (answer == 0) {
            answer = 3;
        } else {
            answer = 4;
        }
        return answer;
    }
}

class placePiece_ActionListener implements ActionListener {

    int columnPlaced;

    @Override
    public void actionPerformed(ActionEvent e) {
        columnPlaced = (Integer.parseInt(e.getActionCommand()));
        GameBoardGUI.placePiece(columnPlaced);
        GameBoardGUI.frame.setTitle("Connect 4 - player " + GameDriver.currentName + "'s turn");
        
    }
}
