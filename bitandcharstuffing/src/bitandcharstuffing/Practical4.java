/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitandcharstuffing;

import java.util.Scanner;

/**
 *
 * @author agraw
 */
public class Practical4 {
       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "", flag="";
        char f;
        System.out.println("Bit Stuffing");
        System.out.print("Enter the String: ");
        str = sc.nextLine();

        bit_stuffing bs = new bit_stuffing();
        char_stuffing cs = new char_stuffing();

        String destuufed=bs.stuffing(str);
        System.out.println("Destuffed data :");
        System.out.println(destuufed);

        str="";
        System.out.println("Character Stuffing");
        System.out.print("Enter the String: ");
        str = sc.nextLine();
        System.out.print("Enter the flag:   ");
        flag = sc.nextLine();
        f = flag.charAt(0);
        cs.stuffing(str, f);

    }
}
