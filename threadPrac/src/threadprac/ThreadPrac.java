/*.................OOP Lab Practical 8 Demonstrate MultiThreading Capablities of Java..............*/
package threadprac;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.*;        
class file{
    
    ArrayList st=new ArrayList();
    boolean flag=false;
    synchronized void read(Scanner obj) throws FileNotFoundException {
        if(flag)
          try{
              wait();
          }
        catch(InterruptedException e){
              System.out.println(e);
          }   
        flag=true;
        
        while(obj.hasNext()){
            st.add(obj.next());
        }
        System.out.println(st);
        obj.close();
        notify();
    }
    synchronized void write() throws IOException,InterruptedException{
        File f =new File("C:\\Users\\agraw\\OneDrive\\Desktop\\oop lab\\prac74.txt");
        if(!f.exists()){
            try{
                f.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        PrintStream ps=new PrintStream(f);
        if(!flag){
            try{wait();}
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        flag=false;
        Iterator it= st.iterator();
        while(it.hasNext()){
            ps.println(it.next());
        }
        notify();
    }
}
class write_file extends Thread{
    file obj;
    write_file(file f){
        this.obj=f;
    }
    @Override
    public void run(){
        try{
            for(int i=0;i<3;i++){
                obj.write();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
class read_file extends Thread{
    file obj;
    Scanner s;
    read_file(file f,Scanner sc){
        this.obj=f;
        this.s=sc;
    }
    @Override
    public void run(){
        try{
            obj.read(s);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
class ThreadPrac {

  
    public static void main(String[] args) 
    {
        Scanner sc1=null;
        try{
            sc1=new Scanner(new File("C:\\Users\\agraw\\OneDrive\\Desktop\\oop lab\\prac71.txt"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
       Scanner sc2=null;
        try{
            sc2=new Scanner(new File("C:\\Users\\agraw\\OneDrive\\Desktop\\oop lab\\prac72.txt"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        Scanner sc3=null;
        try{
            sc3=new Scanner(new File("C:\\Users\\agraw\\OneDrive\\Desktop\\oop lab\\prac73.txt"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("The Contents of the ArrayList After Performing all the three Read Operations  ");
        file f=new file();
        read_file r1=new read_file(f,sc1);
        read_file r2=new read_file(f,sc2);
        read_file r3=new read_file(f,sc3);
        write_file w=new write_file(f);
        r1.start();
        r2.start();
        r3.start();
        w.start();
        
    
    }    
    
}
