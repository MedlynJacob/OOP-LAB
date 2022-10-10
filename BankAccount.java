package sem3;
import java.util.*;
public class BankAccount {
    String id;
    double balance=0;
    int i=0;//transaction count
    public static void main(String[]args){
        BankAccount h1=new BankAccount();
        Scanner sc=new Scanner(System.in);
        int ch=0;
        double deposit,withdraw;
        do{
            System.out.println("1.Enter id\n2.Deposit\n3.Withdraw\n4.Balance\n5.EXIT\n");
            ch=sc.nextInt();
            if(ch==1){
                System.out.println("Enter the ID");
                h1.id=sc.nextLine();
            }
            else if(ch==2){
                System.out.println("Enter the amount to be deposited");
                deposit=sc.nextDouble();
                h1.TakeDeposit(deposit);
            }
            else if(ch==3){
                System.out.println("Enter the amount to be deposited");
                withdraw=sc.nextDouble();
                h1.giveWithdraw(withdraw);
                
            }
            else if(ch==4){
                System.out.println("Balance amount:"+h1.getBalance());
            }
            
            else if(ch==5){
                System.out.println("User Id :"+h1.getId());
                System.out.println("Exiting.....");
            }
        }while(ch!=5);
        sc.close();
    }
    public boolean transactionFee(double  fee){
        fee*=i;
        if(balance>0.00&&balance>fee){
            balance-=fee;
            return true;
        }
        else{
            return false;
        }

    }
    public String getId(){
        return id;
    }
    public void TakeDeposit(double amount){
        i++;
        balance+=amount;
        System.out.println("Amount has been deposited\n");
    }
    public void giveWithdraw(double w){
        double fee=1;
        if(balance>w&&transactionFee(fee)){
            if(balance-fee>0){
                balance-=fee;
                i++;
            }
            else{
                System.out.println("Not Enough Balance");
            }
        }
        else{
            System.out.println("Not Enough Balance");
        }
    }
    public double getBalance(){
        return balance;
    }
}
