
public class Main{

     public static void main(String []args){
        Bank obj1=new Bank("Abc",101,5000.00);
        Bank obj2=new Bank("Xyz",102,2000.00);
        System.out.println("Initial Balance amount of obj1=" +obj1.bal);
        
        obj1.deposit(1000.00);
        obj1.withdraw(200.00);
        obj2=obj1.transfer(300.00);
        System.out.println("The final balance amount of obj2 is=" +obj2.bal);
     }
}
class Bank{
    String name;
    int ac;
    double bal;
    
    Bank(String n,int a,double b){
        name=n;
        ac=a;
        bal=b;
       
    }
    
    void deposit(double d){
        bal=bal+d;
        System.out.println("The amount deposied by obj1 is=" +d);
        System.out.println("final account balance of obj1 is=" +bal);
    }
    void withdraw(double w){
       if(bal>w){ bal=bal-w;
        System.out.println("Amount withdrawn by obj1 is=" +w);
        System.out.println("final account balance of obj1 is=" +bal);}
        else{
            System.out.println("Insufficient Balance");
        }
    }
    Bank transfer(double t){
        bal=bal-t;
        Bank temp=new Bank("Xyz",102,2000.0);
        temp.bal=temp.bal+t;
        
        System.out.println("The amount transfered by obj1 is=" +t);
        System.out.println("your final account balance of obj1 is=" +bal);
        return temp;
    }
    
}