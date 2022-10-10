package sem3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Calculator implements ActionListener{
    double num1,num2,result;
    String temp;
    char op;
    JFrame f;
    JButton b7,b8,b9,bdiv,b4,b5,b6,bmul,b3,b2,b1,badd,b0,beq,bc,bsub;
    JTextField tf;
    JPanel p;

    Calculator(){
        f=new JFrame("Calculator");
        f.setSize(500,500);
        f.setLayout(new FlowLayout());

        b7=new JButton("7");
        b7.addActionListener(this);
        b8=new JButton("8");
        b8.addActionListener(this);
        b9=new JButton("9");
        b9.addActionListener(this);
        bdiv=new JButton("/");
        b4=new JButton("4");
        b4.addActionListener(this);
        b5=new JButton("5");
        b5.addActionListener(this);
        b6=new JButton("6");
        b6.addActionListener(this);
        bmul=new JButton("x");
        bmul.addActionListener(this);
        b3=new JButton("3");
        b3.addActionListener(this);
        b2=new JButton("2");
        b2.addActionListener(this);
        b1=new JButton("1");
        b1.addActionListener(this);
        badd=new JButton("+");
        badd.addActionListener(this);
        b0=new JButton("0");
        b0.addActionListener(this);
        beq=new JButton("=");
        beq.addActionListener(this);
        bc=new JButton("C");
        bc.addActionListener(this);
        bsub=new JButton("-");
        bsub.addActionListener(this);

        tf=new JTextField(11);
        tf.setFont(new Font("Times New Roman",Font.BOLD, 33));
        f.add(tf);

        p=new JPanel();
        p.setLayout(new GridLayout(4,4,10,20));
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bdiv);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bmul);
        p.add(b3);
        p.add(b2);
        p.add(b1);
        p.add(badd);
        p.add(b0);
        p.add(beq);
        p.add(bc);
        p.add(bsub);
        p.setPreferredSize(new Dimension(300,300));
        
        f.add(p);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==bdiv)
        {
            num1 = Double.parseDouble(tf.getText());
            tf.setText(" ");
            op='/';
        }
        else if(e.getSource()==bmul)
        {
            num1 = Double.parseDouble(tf.getText());
            tf.setText(" ");
            op='x';
        }
        else if(e.getSource()==badd)
        {
            num1 = Double.parseDouble(tf.getText());
            tf.setText(" ");
            op='+';
        }
        else if(e.getSource()==bsub)
        {
            num1 = Double.parseDouble(tf.getText());
            tf.setText(" ");
            op='-';
        }
        else if(e.getSource()==beq)
        {
            num2 = Double.parseDouble(tf.getText());
            switch(op){
                case'/': if(num2!=0){
                        result=num1/num2;
                        };
                        tf.setText(String.valueOf(result));
                break;
                case'x': result=num1*num2;
                         tf.setText(String.valueOf(result));
                break;
                case'+': result=num1+num2;
                         tf.setText(String.valueOf(result));
                break;
                case'-': result=num1-num2;
                         tf.setText(String.valueOf(result));
                break;
                default: tf.setText("INVALID");
                break;
            }
        }
        else if(e.getSource()==bc)
        {
            tf.setText(" ");
        }
        else{
            temp=tf.getText() + e.getActionCommand();
            tf.setText(temp);
        }

    }

    public static void main(String[]args)
    {
        Calculator c=new Calculator();
    }
    
}
