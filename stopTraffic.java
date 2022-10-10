package sem3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class stopTraffic extends Frame implements ActionListener {
    Button red,green,yellow;
    ActionEvent e;
    int st;
    int xc=300,y=350;

    stopTraffic()
    {
        red=new Button("RED");
        red.addActionListener(this);
        add(red);

        yellow=new Button("YELLOW");
        yellow.addActionListener(this);
        add(yellow);

        green=new Button("GREEN");
        green.addActionListener(this);
        add(green);
        
        setLayout(new FlowLayout());
        setSize(500,500);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getActionCommand())=="RED")
        {
            st=1;
        }
        if((e.getActionCommand())=="YELLOW")
        {
            st=2;
        }
        if((e.getActionCommand())=="GREEN")
        {
            st=3;
        }
        
        repaint();   
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.blue);
        g.fillRect(xc, y, 70, 40);
        g.setColor(Color.black);
        g.fillOval(xc, y+40, 20, 20);
        g.fillOval(xc+50, y+40, 20, 20);
        g.drawLine(300,400,850,400);

        g.setColor(Color.black);
        g.fillRect(30, 100, 200, 550);
        g.setColor(Color.red);
        g.drawOval(50, 150, 150, 150);
       

        g.setColor(Color.yellow);
        g.drawOval(50, 300, 150, 150);
        

        g.setColor(Color.green);
        g.drawOval(50, 450, 150, 150);

        

        if(st==1)
        {
            g.setColor(Color.red);
            g.fillOval(50, 150, 150, 150);
        }
        else if(st==2)
        {
            g.setColor(Color.yellow);
            g.fillOval(50, 300, 150, 150);
        }
        else if(st==3)
        {
            g.setColor(Color.green);
            g.fillOval(50, 450, 150, 150);
            if(xc<=800){
                xc=xc+1;
            }
            try{
                Thread.sleep(10);
                repaint();
            }
            catch(Exception t){
            }
        }
    }
    
    public static void main(String[]args)
    {
        new stopTraffic();
    }
    
}
