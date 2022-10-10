package sem3;
import java.util.*;
import java.io.*;
public class tele {
  public static void main(String[]args) throws IOException{
      int n,c;
      ArrayList<People>list= new ArrayList<People>();
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the number of people to be added in the telephone directory");
      n=sc.nextInt();
      sc.nextLine();
      for(int i=0;i<n;i++){
        System.out.println("Enter the name :");
        String nme=sc.nextLine();
        String ph=sc.nextLine();
        People p= new People(nme, ph);
        list.add(p);
        }
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                People e=list.get(i);
                People e1=list.get(j);
                if(e.name.compareTo(e1.name)>0){
                    People temp=e;
                    list.set(i,e1);
                    list.set(j,temp);
                }
            }
            
        }
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
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Enter the name to be searched\t");
        int flag=0;
        String _Name=sc.nextLine();
        Iterator<People> i= list.iterator();
        while(i.hasNext()){
            People st=(People)i.next();
            if(st.name.toLowerCase().contains(_Name)){
                System.out.println(st.name+"-"+st.phone+"\n");
                flag++;
            }
        }
        if(flag==0){
            System.out.println("Not Found\n");
        }
        System.out.println("Enter the index letter\t");
        char IN=sc.next().charAt(0);
        Iterator<People> in= list.iterator();
        while(in.hasNext()){
            People t=(People)in.next();
            String tname=t.name.toLowerCase();
            if(tname.charAt(0)==IN){
                System.out.println(t.name+"-"+t.phone+"\n");
            }
        }


    sc.close();

  }  
}

class People{
    String name;
    long phone;
    People(String name,String phone){
        this.name=name;
        this.phone=Long.parseLong(phone);
    }
}


