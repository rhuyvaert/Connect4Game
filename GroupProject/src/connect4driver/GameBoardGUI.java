
package connect4driver;

import java.awt.*;
import java.awt.event.*;
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
        buttons=new JButton[row];
        board=gameBoard;
    }
    
    //initializes the information for the game
    public void initGame(){
        int a=-1;
        String players="";
        while(a<0){
            players = JOptionPane.showInputDialog(null, "Please enter the number of players: ", "Starting the game", JOptionPane.QUESTION_MESSAGE);
            GameDriver.numberOfPlayers=Integer.parseInt(players);
            if(GameDriver.numberOfPlayers==1||GameDriver.numberOfPlayers==2){
                a++;
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter either 1 or 2 players","", JOptionPane.WARNING_MESSAGE);
            }
        }
        a=-1;
        if (GameDriver.numberOfPlayers==1){
            while(a<0){
               GameDriver.name1 = JOptionPane.showInputDialog(null, "Please enter the name of the player: ", "Starting the game", JOptionPane.QUESTION_MESSAGE);
               if(GameDriver.name1.length()>0){
                   a++;
               }
               else{
                    JOptionPane.showMessageDialog(null, "Please enter the name of the player!","", JOptionPane.WARNING_MESSAGE);
               }
            }
        }
        else if(GameDriver.numberOfPlayers==2){
            while(a<0){
               GameDriver.name1 = JOptionPane.showInputDialog(null, "Please enter the name of player 1: ", "Starting the game", JOptionPane.QUESTION_MESSAGE);
               if(GameDriver.name1.length()>0){
                   a++;
               }
               else{
                    JOptionPane.showMessageDialog(null, "Please enter the name of player 1!","", JOptionPane.WARNING_MESSAGE);
               }
            }
            a=-1;
            while(a<0){
               GameDriver.name2 = JOptionPane.showInputDialog(null, "Please enter the name of player 2: ", "Starting the game", JOptionPane.QUESTION_MESSAGE);
               if(GameDriver.name2.length()>0){
                   a++;
               }
               else{
                    JOptionPane.showMessageDialog(null, "Please enter the name of player 2!","", JOptionPane.WARNING_MESSAGE);
               }
            }
        }
    }
    
    //initializes the board for the game
    public void initBoard(){
        for(int i=0;i<row;i++){
           buttons[i]=new JButton(""+(i+1));
           buttons[i].setActionCommand(""+i);
           buttons[i].addActionListener((ActionEvent e) -> {
               int a=(Integer.parseInt(e.getActionCommand()));
               boolean b= board.checkColumn(a);
               if(b==false){
                   board.placePiece(a,currentPlayer);
                   winner=GameDriver.winCondition(currentPlayer);
                   GameDriver.changePlayer();
                   currentPlayer=GameDriver.currentPlayer;
                   frame.setTitle("Connect 4 - player "+currentPlayer+"'s turn");
                   if (GameDriver.winner==true){
                       winner=true;
                   }
                   else if (GameDriver.turn==42){
                       draw=true;
                   }
               }
               else{
                   JOptionPane.showMessageDialog(null, "choose a different column", "column is full", JOptionPane.INFORMATION_MESSAGE);
               }
           });
        panel.add(buttons[i]);
        }
        for(int i=0;i<column;i++){
            for(int j=0; j<row;j++){
                slots[j][i]=new JLabel();
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
                    slots[row-1][column-1].setOpaque(true);
                    slots[row-1][column-1].setBackground(Color.red);
                }
                if (board.returnPiece(i,j)=='O') {
                    slots[row-1][column-1].setOpaque(true);
                    slots[row-1][column-1].setBackground(Color.yellow);
                }
            }
        }
    }
    
}
