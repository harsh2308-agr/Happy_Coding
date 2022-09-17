
interface IOwner
{
//double cal_pay();
double cal_equity();
}
class Person
{
    String name;
    String Address;
    int ph;
    Person(String name, String Address, int ph){
        this.name=name;
        this.Address=Address;
        this.ph=ph;
    }
    void display()
    {
        System.out.println("Name: "+name);
        System.out.println("Address: "+Address);
        System.out.println("Phno:"+ph);
    }
}
class Employee extends Person 
{
    int eno;
    String title;
    double bsal;
    double gsal;
    Employee(String name, String Address, int ph,int eno,String title, double bsal, double gsal) {
        super(name, Address, ph);
        this.eno=eno;
        this.title=title;
        this.bsal=bsal;
        this.gsal=gsal;
    }
    double cal_pay(double bsal, double gsal)
    {
        double HRA=0.1*bsal;
        double DA=0.5*bsal;
        gsal=bsal+HRA+DA;
        return gsal;
    }
    
}
class Employee_Owner extends Employee implements IOwner
{
    double capitalmoney;
    double equityshare;
    double equityrs;
    Employee_Owner(String name, String Address,int ph,int eno,String title,double bsal, double gsal,double equityshare, double equityrs, double capitalmoney) {
        super(name, Address,ph,eno,title, bsal,gsal);
        
        this.capitalmoney=capitalmoney;
        this.equityshare=equityshare;
        this.equityrs=equityrs;
    }
    double cal_equity(double capitalmoney,double equityshare, double equityrs)
    {
        equityrs=(capitalmoney*equityshare)/100;
        return equityrs;
    }

    double cal_pay(double bsal, double gsal)
    {
        double HRA=0.1*bsal;
        double DA=0.5*bsal;
        gsal=bsal+HRA+DA;
        return gsal;
    }
    @Override
    public double cal_equity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}    

class Owner extends Person implements IOwner
{
    double capitalmoney;
    double equityshare;
    double equityrs;
    public Owner(String name, String Address, int ph, double equityshare, double equityrs, double capitalmoney) {
        super(name, Address, ph);
        this.capitalmoney=capitalmoney;
        this.equityshare=equityshare;
        this.equityrs=equityrs;
    }
    double cal_equity(double capitalmoney,double equityshare, double equityrs)
    {
        equityrs=(capitalmoney*equityshare)/100;
        return equityrs;
    }

    public double cal_pay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double cal_equity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}



public class Main {

    
    public static void main(String[] args) {
        
        System.out.println("Employee-");
        Employee e1 = new Employee("Ajay","Nagpur",9265,1,"head",5000,0);
        double a=e1.cal_pay(5000,0);
        e1.display();
        System.out.println("Gross salary of the Employee is= "+a);
        System.out.println("--------------------------------------");
        System.out.println("Employee_Owner-");
        Employee_Owner e2 = new Employee_Owner("Raj","Mumbai",98745,2,"Hod",6000,0,20,0,8000);
        e2.display();
        double b=e2.cal_pay(6000, 0);
        double c= e2.cal_equity(8000,20,0);
        System.out.println("gross Salary:" +b);
        System.out.println("Equity rs: "+c);
        System.out.println("----------------------------------------");
        System.out.println("Owner--");
        Owner e3= new Owner("Jay","Pune",985465,10,0,7000);
        e3.display();
        double d=e3.cal_equity(7000,10,0);
        System.out.println("Equity Rs: " +d);
        System.out.println("------------------------------------------");
        
        
    }
    
}
