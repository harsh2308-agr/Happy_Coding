/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitandcharstuffing;

/**
 *
 * @author agraw
 */
public class char_stuffing {
    public String stuffing(String s, char flag){
        String str="";
        str+=flag;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==flag){
                str+=flag;
                str+=s.charAt(i);
            }
            else{
                str+=s.charAt(i);
            }
        }
        str+=flag;
        System.out.println("Char stuffing:  "+str);
        return destuffing(str, flag);
    }

    public String destuffing(String s, char flag){
        String str="";
        for(int i =1; i<s.length()-1; i++){
            if(s.charAt(i)==flag){
                i++;
                if(i+1<s.length())
                    str+=s.charAt(i);
            }
            else{
                str+=s.charAt(i);
            }
        }
        System.out.println("Char destuffing:  "+str);
        return str;
    }
}
