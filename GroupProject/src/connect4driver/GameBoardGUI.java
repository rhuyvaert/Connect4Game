package connect4driver;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GameBoardGUI extends JFrame{
    private final int size;
    private final int offset;
    private final int circleSize;
    private final int pos;
    private final int incr;
    
    public GameBoardGUI() {
        super("GameBoardGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.size = 400;
        this.offset = 10;
        this.circleSize=(size/4)-(offset*2);
        this.pos=offset/2;
        this.incr=size/4;   
    }
    
}
