package sem3;

import java.awt.*;
import java.awt.event.*;

public class car extends Frame implements ItemListener{
    Checkbox c1,c2,c3;
    CheckboxGroup cbg;
    String str;
    int x=50,y=150;
    int xr=450,yr=50;
    car(){
        setTitle("Car stops for train");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(500,500);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        cbg=new CheckboxGroup();
        c1=new Checkbox("Start",true,cbg);
        add(c1);
        c1.addItemListener(this);
        c2=new Checkbox("Stop",true,cbg);
        add(c2);
        c2.addItemListener(this);
        c3=new Checkbox("Stop Animation", true, cbg);
        add(c3);
        c3.addItemListener(this);
    }
    public void itemStateChanged(ItemEvent e){
        str=(e.getItem()).toString();
        repaint();
    }
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x, y, 70, 40);
        g.setColor(Color.black);
        g.fillOval(x, y+40, 20, 20);
        g.fillOval(x+50, y+40, 20, 20);
        g.setColor(Color.black);
        g.fillOval(xr-5, yr+40, 20, 20);
        g.fillOval(xr+25, yr+40, 20, 20);
        g.fillOval(xr-5, yr+10, 20, 20);
        g.fillOval(xr+25, yr+10, 20, 20);
        g.setColor(Color.MAGENTA);
        g.fillRect(xr, yr, 40, 70);
        g.setColor(Color.BLACK);
        g.drawLine(420,50,420,700);
        g.drawLine(520,50,520,700);
        if(str.equalsIgnoreCase("Start")){
            if(x<=700){
                x=x+1;
            }
            try{
                Thread.sleep(60);
                repaint();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        else if(str.equalsIgnoreCase("Stop")){
            if(yr!=400){
                yr=yr+1;
            }
            try{
                Thread.sleep(60);
                repaint();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[]args){
        new car();
    } 

}