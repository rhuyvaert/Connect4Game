package connect4driver;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SwingUtilities {
    
}

class triangleButton extends JButton{
    private Shape triangle =createTriangle();
    private boolean mouseOver=false;

    triangleButton(String string) {
        super(string);
        setOpaque(false);
        setFocusPainted(false);
        createTriangle();
    }
    
    private Shape createTriangle(){
        Polygon p=new Polygon();
        p.addPoint(50,75);
        p.addPoint(0,25);
        p.addPoint(95,25);
        return p;
    }
    
    public void paintBorder(Graphics g){
        ((Graphics2D)g).draw(triangle);
    }
    
    public void paintComponent(Graphics g){
        ((Graphics2D)g).fill(triangle);
        
    }
    
    public Dimension getPreferredSize(){
        return new Dimension(50,100);
    }
    
    public boolean contains(int x, int y){
        return triangle.contains(x,y);
    }
}

class circleLabel extends JLabel{
    
    private Color circleColor=Color.white;
    
    circleLabel(String string){
        super(string);
    }

    circleLabel() {
        super();
    }
    
    public void setColor(Color color){
        circleColor=color;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Dimension originalSize=super.getPreferredSize();
        int gap=(int)(originalSize.height*0.2);
        int x=originalSize.width+gap;
        int y=gap;
        int diameter=originalSize.height-(gap*2);
        
        g.setColor(circleColor);
        g.fillOval(x, y, diameter, diameter);
    }
    
    @Override
    public Dimension getPreferredSize(){
        Dimension size=super.getPreferredSize();
        size.width+=size.height;
        return size;
    }
}
