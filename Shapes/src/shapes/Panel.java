/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Timer;
/**
 *
 * @author 073903999
 */
public class Panel extends javax.swing.JPanel implements MouseListener {
    Color newColor;
    int count = 0;
    ArrayList a = new ArrayList();
    boolean create = false;
    char shape;
    Point a1 = new Point(-10, -10);
    Point b1 = new Point(-10, -10);
    /**
     * Creates new form Panel
     */
    public Panel() {
        initComponents();
        addMouseListener(this);
    }
    
    public void anim(){
        Timer t1 = new Timer(50, new TimerListener());
        t1.start();
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
    //    System.out.println(create);
        g.setColor(Color.BLACK);
        g.fillRect( (int)a1.getX()-3, (int)a1.getY()-3, 6,6);
        g.fillRect( (int)b1.getX()-3, (int)b1.getY()-3, 6,6);
        g.setColor(newColor);
        
        
        for( Object val: a){
            if(val instanceof Line){
                Line l = (Line) val;
                g.drawLine( (int)l.getP1().getX(), (int)l.getP1().getY(), (int)l.getP2().getX(), (int)l.getP2().getY());
            }
            
            
            
            else if(val instanceof Rectangle){
                Rectangle r = (Rectangle) val;
               
                    
                    int width = (int) (r.getP2().getX()-r.getP1().getX() ) ;
                    int length = (int) (r.getP2().getY()-r.getP1().getY())  ;
                    
                    g.drawRect( (int )r.getP1().getX(), (int)r.getP1().getY(), width, length);
                    
            }
            else if(val instanceof Circle){
                Circle c = (Circle) val;
                g.drawOval((int)( c.getCent().getX() - c.getR() ) , (int) ( c.getCent().getY() - c.getR() ), (int) (c.getR() *2), (int) ( c.getR() *2) );
           
            }
        }
    }
        
    private Object check(){
        
            Point a2 = a1;
            Point b2  = b1;
            switch(shape){
                
                case 'a':
                    Rectangle r = new Rectangle (a2, b2);
                    
                    create = false;
                    shape = ' ';
                    return r;
                case 'b':
                    Circle c = new Circle (a2, a2.distance(b2));
                    create = false;
                    shape = ' ';
                    return c;
                default:
                    Line l = new Line (a2, b2);
                          
                    create = false;
                    shape = ' ';
                    return l;    
            }
    }
    
    private class TimerListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            repaint();
        
        }
    }   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        //left click
        if (e.getButton() == 1){
            count +=1;
            
            if(count== 2){
                b1 = new Point(e.getX(), e.getY());
                create = true;
                count = 0;
                a.add(check());
            }
            else{
                a1 = new Point(e.getX(), e.getY());
                b1 = new Point(-10, -10);
                
            }
        }
        
        // right click
        else if(e.getButton() == 3){
            
            System.out.println("ok");
        }
        
        //middle mouse click
        else {
            System.out.println("huhhhh");
        }
        
        
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
     
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
