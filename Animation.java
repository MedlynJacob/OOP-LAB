package sem3;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Animation extends Frame{
    
    int x,y;
    Animation()
    {
        x=50;
        y=50;
        setSize(500,500);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.blue);
        g.fillRect(x, y, 70, 40);
        g.setColor(Color.black);
        g.fillOval(x, y+40, 20, 20);
        g.fillOval(x+50, y+40, 20, 20);
        x=x+1;
        try{
            Thread.sleep(100);
            repaint();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[]args)
    {
        Animation a=new Animation();
    }
    
}
