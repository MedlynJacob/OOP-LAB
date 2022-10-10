package sem3;
import java.awt.*;
import java.awt.event.*;

public class smiley extends Frame implements ActionListener{
    Button b1,b2;
    int x1;

    smiley()
    {
        x1=0;
        b1=new Button("Good");
        b1.addActionListener(this);
        add(b1);

        b2=new Button("Bad");
        b2.addActionListener(this);
        add(b2);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,500);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g) {
        g.drawOval(180, 100, 150, 150); // For face
        g.setColor(Color.black);
        g.fillOval(210, 140, 15, 25); // Left Eye
        g.fillOval(280, 140, 15, 25); // Right Eye

        g.drawArc(210, 180, 80, 52, 3, x1); // Smile or sad
    }

    public void actionPerformed(ActionEvent e) {

        if ((e.getActionCommand()) == "Good") {
            x1 = -180;
        }
        if ((e.getActionCommand()) == "Bad") {
            x1 = 180;
        }
        repaint();
       
    }
    public static void main(String[]args)
    {
        smiley s=new smiley();
    }

}