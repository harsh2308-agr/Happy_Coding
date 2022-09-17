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
public class bit_stuffing {
    
    
   public String stuffing(String data){
        int count = 0;
        data = strToBinary(data);
        System.out.println(data);
        String s = "";
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch == '1') {
                count++;
                if (count < 5)
                    s += ch;
                else {
                    s = s + ch + '0';
                    count = 0;
                }
            } else {
                s += ch;
                count = 0;
            }
        }
        System.out.println("Bit Stuffed data\n"+s);
        return destuffing(s);
    }

    public String destuffing(String data){
        int count=0;
        String s = "";
        for(int i =0; i<data.length(); i++){
            char c = data.charAt(i);
            if(c == '1'){
                count++;
                s+=c;

                if(count==5){
                    i++;
                    count=0;
                }
            }
            else{
                s+=c;
                count=0;
            }
        }
        return s;
    }

    public String strToBinary(String s) {
        int n = s.length();
        String binary="";
        for (int i = 0; i < n; i++) {
            int val = Integer.valueOf(s.charAt(i));
            String bin = "";
            while (val > 0) {
                if (val % 2 == 1) {
                    bin += '1';
                } else
                    bin += '0';
                val /= 2;
            }
            bin = reverse(bin);
            binary+=bin;
        }
        return binary;
    }

    public String reverse(String input)
    {
        char[] a = input.toCharArray();
        int l, r = 0;
        r = a.length - 1;

        for (l = 0; l < r; l++, r--)
        {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        return String.valueOf(a);
    }
    
    
}
