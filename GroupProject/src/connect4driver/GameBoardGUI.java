
package connect4driver;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JOptionPane;

public class GameBoardGUI {
    
    private final JFrame frame;
    private JPanel panel;
    private JLabel[][] slots;
    private JButton[] buttons;
    
    private final int row;
    private final int column;
    private int currentPlayer;
    
    boolean winner=false;
    boolean draw=false;
    
    private Connect4Board board;
    /**
     * Constructor for the GUI
     * @param x row length of the board
     * @param y column length of the board
     * @param player starting player
     */
    public GameBoardGUI(int x, int y, Connect4Board gameBoard) {
        row=x;
        column=y;
        currentPlayer=GameDriver.currentPlayer;
        frame=new JFrame("Connect 4");
        panel=(JPanel) frame.getContentPane();
        panel.setLayout(new GridLayout(row, column+1));
        slots=new JLabel[row][column];
        buttons=new triangleButton[row];
        board=gameBoard;
    }
    
    //initializes the information for the game
    public void initGame(){
        int a=-1;
        String players="";
        while(a<0){
            players = JOptionPane.showInputDialog(frame, "Please enter the number of players: ", "Starting the game", JOptionPane.QUESTION_MESSAGE);
            GameDriver.numberOfPlayers=Integer.parseInt(players);
            if(GameDriver.numberOfPlayers==1||GameDriver.numberOfPlayers==2){
                a++;
            }
            else{
                JOptionPane.showMessageDialog(frame, "Please enter either 1 or 2 players","", JOptionPane.WARNING_MESSAGE);
            }
        }
        a=-1;
        if (GameDriver.numberOfPlayers==1){
            while(a<0){
               GameDriver.name1 = JOptionPane.showInputDialog(frame, "Please enter the name of the player: ", "Starting the game", JOptionPane.QUESTION_MESSAGE);
               if(GameDriver.name1.length()>0){
                   a++;
               }
               else{
                    JOptionPane.showMessageDialog(frame, "Please enter the name of the player!","", JOptionPane.WARNING_MESSAGE);
               }
            }
        }
        else if(GameDriver.numberOfPlayers==2){
            while(a<0){
               GameDriver.name1 = JOptionPane.showInputDialog(frame, "Please enter the name of player 1: ", "Starting the game", JOptionPane.QUESTION_MESSAGE);
               if(GameDriver.name1.length()>0){
                   a++;
               }
               else{
                    JOptionPane.showMessageDialog(frame, "Please enter the name of player 1!","", JOptionPane.WARNING_MESSAGE);
               }
            }
            a=-1;
            while(a<0){
               GameDriver.name2 = JOptionPane.showInputDialog(frame, "Please enter the name of player 2: ", "Starting the game", JOptionPane.QUESTION_MESSAGE);
               if(GameDriver.name2.length()>0){
                   a++;
               }
               else{
                    JOptionPane.showMessageDialog(frame, "Please enter the name of player 2!","", JOptionPane.WARNING_MESSAGE);
               }
            }
        }
        GameDriver.currentName=GameDriver.name1;
    }
    
    //initializes the board for the game
    public void initBoard(){
        for(int i=0;i<row;i++){
           frame.setTitle("Connect 4 - player "+GameDriver.name1+"'s turn");
           buttons[i]=new triangleButton(""+(i+1));
           buttons[i].setBackground(Color.white);
           buttons[i].setActionCommand(""+i);
           buttons[i].addActionListener((ActionEvent e) -> {
               int a=(Integer.parseInt(e.getActionCommand()));
               boolean b= board.checkColumn(a);
               if(b==false){
                   board.placePiece(a,currentPlayer);
                   winner=GameDriver.winCondition(currentPlayer);
                   if (winner==true){
                       GameDriver.runtime=1;
                   }
                   else if (GameDriver.turn==42){
                       GameDriver.runtime=2;
                   }
                   GameDriver.changePlayer();
                   currentPlayer=GameDriver.currentPlayer;
                   frame.setTitle("Connect 4 - player "+GameDriver.currentName+"'s turn");
               }
               else{
                   JOptionPane.showMessageDialog(null, "choose a different column", "column is full", JOptionPane.INFORMATION_MESSAGE);
               }
           });
        panel.add(buttons[i]);
        }
        for(int i=0;i<column;i++){
            for(int j=0; j<row;j++){
                slots[j][i]=new circleLabel();
                slots[j][i].setHorizontalAlignment(SwingConstants.CENTER);
                slots[j][i].setBorder(new LineBorder(Color.BLACK));
                panel.add(slots[j][i]);
            }
        }
        
        frame.setContentPane(panel);
        frame.setSize(700,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void updateBoard(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board.returnPiece(i,j)=='X') {
                    slots[i][j].setOpaque(true);
                    slots[i][j].setBackground(Color.red);
                }
                if (board.returnPiece(i,j)=='O') {
                    slots[i][j].setOpaque(true);
                    slots[i][j].setBackground(Color.yellow);
                }
            }
        }
    }
    
    public void reset(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                    slots[i][j].setOpaque(false);
                    slots[i][j].setBackground(Color.white);  
            }
        }
        winner=false;
        currentPlayer=1;
        frame.setTitle("Connect 4 - player "+GameDriver.name1+"'s turn");
    }
    
    public int gameWon(){
        String[] responses={"Play Again?","End Game"};
        GameDriver.changePlayer();
        int answer=JOptionPane.showOptionDialog(panel, GameDriver.currentName+" has won", "Winner", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, responses, 0);
        if (answer==0){
            answer=3;
        }
        else{
            answer=4;
        }
        return answer;
    }
    
    public int gameDraw(){
        String[] responses={"Play Again?","End Game"};
        int answer=JOptionPane.showOptionDialog(panel, "The game is a draw", "Draw", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, responses, 0);
        if (answer==0){
            answer=3;
        }
        else{
            answer=4;
        }
        return answer;
    }
}
