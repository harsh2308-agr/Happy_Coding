/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;
import java.sql.*;


class counter{
    int count=1;
    public synchronized void increment(){
        for(int i=0;i<10;i++){
            count=count+1;
        }
    
}
}


/*Creating a thraed using a runnamble interface*/
class thread1 implements Runnable{
   private String tname;
   private Thread t;
   thread1(String name){
       tname= name;
       System.out.println("Creating:: "+ name);
   }
   
    @Override
    public void run() {
        try{
        int i=0;
       //System.out.println("Creating:: "+ tname);
       while(i<5)
        {
            System.out.println("Runnable thread is working "+i);
            i=i+1;
            Thread.sleep(20);
        }
        }catch(InterruptedException e){
            System.out.println("Given Thread= "+tname+"Is interrupted ");
        }
        counter c=new counter();
        for(int j=0;j<5;j++){
        c.increment();
        }
        System.out.println("The value of Counter c is= "+c.count);
    }
    
}

class mythread extends Thread{
    public mythread(String name){
        super(name);
    }
    
    @Override
    public void run(){
        int i=0;
        /*while(i<5){
            System.out.println("Printing paper no= " +i );
            i++;
        }*/
        counter d= new counter();
        for(int k=0;k<5;k++){
            d.increment();
        }
        System.out.println("The value of counter d is= "+d.count);
        System.out.println("My Name is :- " + Thread.currentThread().getName());
        
    }
}
class youthread extends Thread{
  public youthread(String name){
      super(name);
      
  }
   @Override
   public void run(){
       int i=0;
       while(i<5){
           System.out.println("Scanning Paper no= "+i);
           i++;
       }
       System.out.println("My Name is :- " + Thread.currentThread().getName());
   }   
}



public class Main
{
    public static void main(String[] args) 
    {
       /* mythread t1=new mythread();*/
        youthread t2=new youthread("hari krishna");
       thread1 thread3=new thread1("Student");
        Thread gun1=new Thread(thread3);
        
           t2.setName("secondtread");
         //t1.setName("firstthread");
     
    
         gun1.start();
         //gun1.join();
         //t1.start();
         //t1.join();
         t2.start();
        mythread p1=new mythread("Ajay-Atul");
        mythread p2=new mythread("Annu Malik");
        /*mythread p3=new mythread("Salim-sulaiman");
        mythread p4=new mythread("Vishal-shekhar");
        mythread p5=new mythread("AR Reheman");
        p1.setPriority(Thread.MAX_PRIORITY);
        p3.setPriority(Thread.MIN_PRIORITY);
        p2.setPriority(Thread.NORM_PRIORITY);*/
        p1.start();
        p2.start();/*
        p3.start();
        p4.start();
        p5.start();*/
        
        
       
        
        
    }
}
