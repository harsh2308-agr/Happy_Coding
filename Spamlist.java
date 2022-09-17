

import java.io.*;
import java.io.PrintStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int isSubstring(
        String s1, String s2)
    {
        int M = s1.length();
        int N = s2.length();
 
        
        for (int i = 0; i <= N - M; i++) {
            int j;
 
        
            for (j = 0; j < M; j++)
                if (s2.charAt(i + j)
                    != s1.charAt(j))
                    break;
 
            if (j == M)
                return 100;
        }
 
        return -1;
    }
    public static void main(String[] args) throws IoException {
        
        System.out.println("Welcome");
        
        try{
            PrintStream ps = new PrintStream("C:\\Users\\agraw\\OneDrive\\Desktop\\spamlist.txt");
            File file=new File("C:\\Users\\agraw\\OneDrive\\Desktop\\password.txt");   
            
            Scanner fis = new Scanner(file);
      
            
            int i=0;
            String[] arr= new String[2];
            while(fis.hasNext())
            {
                
                arr[i]=fis.nextLine();
                i++;
            } 
           String first=arr[0];
           String Second=arr[1];
            fis.close();
            Scanner myObj = new Scanner(System.in); 
            Scanner sc=new Scanner(System.in);// Create a Scanner object
            
    System.out.println("Enter The Username");

    String uname = myObj.nextLine();  //
            System.out.println("Enter The Password: ");
            String pw =sc.nextLine();
            
           if((uname.equals(first)) && (pw.equals(Second)) )
           {
               System.out.println("Access Granted");
                String spam,choice="";
                while(!"EXIT".equals(choice))
                {
                    Scanner ob = new Scanner(System.in);
                    System.out.println("Enter the email domain to spam / type EXIT to exit ?");
                    choice=ob.nextLine();
                    File fp=new File("C:\\Users\\agraw\\OneDrive\\Desktop\\username.txt"); 
                    Scanner fp1 = new Scanner(fp);
                     
                    while(fp1.hasNext())
                    {
                         String abc=fp1.nextLine();
                         int res = isSubstring(choice, abc);
                          
                         if(res==100)
                         {   System.out.println("Would you like to add "+abc+" to the spamlist ? type yes");
                             String n=ob.nextLine();
                            //FileOutputStream fout=null;
                            //fout=new FileOutputStream("C:\\Users\\agraw\\OneDrive\\Desktop\\spamlist.txt");
                             if(n.equals("yes")){
                                 //fout.println(abc);
                             
                              ps.println(abc);
                              //ps.println();
                              //ps.close();
                          
                             }
                         }
                    }
                    
                }
              }
            else
            {
                System.out.println("Access Denied");
            }
            
        }catch(IOException e){
           System.out.println("Error Opening the File");
            //e.printStackTrace();
        }
      }
}
