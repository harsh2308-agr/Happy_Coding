
package practical2;

import java.util.Arrays;

class string{
    char[] arr;
    string(char[] a1){
        arr=a1;
    }
    void findlength(string a1)
    {
        System.out.println("The length of the string is= " +a1.arr.length);
    }
    void concatenate(string a1, string a2)
    {
        int length = a1.arr.length + a2.arr.length;

        char[] result = new char[length];
        int pos = 0;
        for (char element : a1.arr) {
            result[pos] = element;
            pos++;
        }

        for (char element : a2.arr) {
            result[pos] = element;
            pos++;
        }
         a1.arr=result;
        System.out.println(a1.arr);
       
        
    }
    
    void display(string a1)
    {
      for(int i=0;i<a1.arr.length;i++)
      {
          System.out.print(a1.arr[i]);
          
      }
      System.out.println("\n");
    }
   void reverse(string a1) 
    { 
        char[] b = new char[a1.arr.length]; 
        int j = a1.arr.length; 
        for (int i = 0; i < a1.arr.length; i++) { 
            b[j - 1] = a1.arr[i]; 
            j = j - 1; 
        } 
  
       
        System.out.println("Reversed string is: \n"); 
        for (int k = 0; k < a1.arr.length; k++) { 
            System.out.print(b[k]); 
        } 
    } 
   void equals(string a1, string a2)
   {
      
    
        if(a2.arr.length != a1.arr.length)
        {
           System.out.println("Strings are not equal");
        }
        
        else
        {
            for(int i=0; i < a1.arr.length ;i++)
            {
                if(a1.arr[i]==a2.arr[i] || a1.arr[i]==(a2.arr[i]-32) || a1.arr[i]==(a2.arr[i]+32))
                {
                    continue;
                }
                else
                {
                   
                     System.out.println("Strings are not equal");
                }
            }
            
             System.out.println("Strings are  equal");
        }
    
   }
   void replace(string a1, string a2,int index1,int index2)
   {
       char a=a2.arr[index2];
       a1.arr[index1]=a;
       System.out.println("String 1 after replacement ");
      a1.display(a1);
   }
   int compare(string a1, string a2)
   {
       int m, count=0;
       if(a1.arr.length>=a2.arr.length)
       {
           m=a1.arr.length;
       }
       else{
           m=a2.arr.length;
       }
       for(int i=0;i<m;i++)
       {
           if(a1.arr[i]>a2.arr[i])
           {count=1;
               return 1;
           }
           if(a2.arr[i]>a1.arr[i])
           {
               count=1;
               return -1;
           }
           else 
               count=0;
                       
       }
       if(count==0)
           return 0;
       return 0;
   }

   
   
}






public class Main {

   
    
    public static void main(String[] args) {
        
            char[] w = {'H', 'E', 'L', 'L', 'O'};
            string s1 =new string(w);
            char[] r = {'h', 'E', 'L', 'L', 'O'};
            string s2 =new string(r);
            System.out.println("The two strings are=");
            s1.display(s1);
            s2.display(s2);
            
            s1.findlength(s1);
            s2.findlength(s2);
            System.out.println("Strings after concatenation=");
            s1.concatenate(s1,s2);
            int  n=s1.compare(s1,s2);
            System.out.println("The result of comparison is="); 
            System.out.println(n);
            s1.reverse(s1);
            System.out.println("\n");
            s1.replace(s1, s2, 0, 0);
            System.out.println("The result of equals function is=");
            s1.equals(s1,s2);
            System.out.println(s1.arr);
            
       
        
        
       
    }
    
}
