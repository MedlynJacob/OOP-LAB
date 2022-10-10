package sem3;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class umbrella extends Frame implements ItemListener{
    int x1=50,x2=50,y1=40,y2=30,xr=10;
    String str="";
    Checkbox c1, c2;
    CheckboxGroup cbg;
    umbrella(){
        cbg=new CheckboxGroup();
        c1=new Checkbox("Rain",true,cbg);
        c2=new Checkbox(" no Rain", true,cbg);

        setTitle("Man in the Rain");
        setSize(300,300);
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(c1);
        c1.addItemListener(this);
        add(c2);
        c2.addItemListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public void itemStateChanged(ItemEvent e){
        str=(e.getItem()).toString();
        repaint();
    }

    public void paint(Graphics g){
        g.drawLine(x1,250,x2, 400);//man
        g.setColor(Color.black);
        g.fillOval(x1-15,250,30,30);//head
        g.drawLine(10, 400,1000, 400);//road

        if(str.equals("Rain")){
            g.setColor(Color.red);
            g.fillOval(x1-50, 160, 150,30);
            g.drawLine(x1,190,x2,255);
            g.setColor(Color.blue);
            g.drawLine(10,y1, 10, y2);
            g.drawLine(30,y1, 30, y2);
            g.drawLine(50,y1, 50, y2);
            g.drawLine(70,y1, 70, y2);
            g.drawLine(90,y1, 90, y2);
            g.drawLine(110,y1, 110, y2);
            g.drawLine(130,y1, 130, y2);
            g.drawLine(150,y1, 150, y2);
            g.drawLine(170,y1, 170, y2);
            g.drawLine(190,y1, 190, y2);
            g.drawLine(210,y1, 210, y2);
            g.drawLine(230,y1, 230, y2);
            g.drawLine(250,y1, 250, y2);
            g.drawLine(270,y1, 270, y2);
            g.drawLine(290,y1, 290, y2);
            g.drawLine(310,y1, 310, y2);
            g.drawLine(330,y1, 330, y2);
            g.drawLine(350,y1, 350, y2);
            g.drawLine(370,y1, 370, y2);
            g.drawLine(390,y1, 390, y2);
            g.drawLine(410,y1,410,y2);

            x1=x1+1; 
            x2=x2+1;

            if(y2<400){
                y2+=10;
            }
            else{
                y2=40;
            }

            try{
                Thread.sleep(50);
                repaint();
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args){
        umbrella um=new umbrella();
    }
}
