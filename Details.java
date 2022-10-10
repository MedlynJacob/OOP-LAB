package sem3;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class Details extends Frame implements ActionListener {
    Button s;
    Label l_name,l_phone;
    TextField tf_name,tf_phone;
    Panel p;
    ArrayList<People>list=new ArrayList<People>();
    int c;

    Details(){

        setTitle("Enter Telephone Details");
        setSize(300,300);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        Label l_name =new Label("Name:");
        tf_name=new TextField(30);
        tf_name.setFont(new Font("Times New Roman",Font.BOLD, 20));
        Label l_phone=new Label("Telephone number");
        tf_phone=new TextField(10);
        tf_phone.setFont(new Font("Times New Roman",Font.BOLD, 20));
        
        p=new Panel();
        p.setLayout(new GridLayout(2,2));
        p.setSize(200,200);
        p.add(l_name);

        p.add(tf_name);
        p.add(l_phone);
        p.add(tf_phone);
        add(p);
        s=new Button("Submit");
        s.setSize(20,30);
        s.addActionListener(this);
        add(s);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand()=="Submit"){
            String name=tf_name.getText();
            String phone=tf_phone.getText();
            tf_name.setText("");
            tf_phone.setText("");
            People p=new People(name, phone);
            list.add(p);
            try{
                FileWriter fw= new FileWriter("Telephone_Directory.txt");
                FileReader fr= new FileReader("Telephone_Directory.txt");
                Iterator<People> itr= list.iterator();
                while(itr.hasNext()){
                    People st=(People)itr.next();
                    fw.write(st.name+"-"+st.phone+"\n");
                }
                fw.close();
                while((c=fr.read())!=-1){
                    System.out.print((char)c);
                }
                fr.close();
            }
            catch(Exception h){
                h.printStackTrace();
            }
        }
    }


    public static void main(String[]args){
        Details d=new Details();
    }

}
