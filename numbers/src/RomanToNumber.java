package com.kar.practice.exercise.numbers.src;

import java.util.Scanner;

public class RomanToNumber {
    public static int value(char r)
    {
        if (r == 'I')
            return 1;
        else if (r == 'V')
            return 5;
        else if (r == 'X')
            return 10;
        else if (r == 'L')
            return 50;
        else if(r == 'C')
            return 100;
        else if(r == 'D')
            return 500;
        else if(r == 'M')
            return 1000;
        return -1;
    }
    public static int romanToDecimal(String str)
    {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            int s1 = value(str.charAt(i));
            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));
                if (s1 >= s2) {
                    res += s1;
                }
                else {
                    res += s2 - s1;
                    i++;
                }
            }
            else {
                res = res + s1;
            }
        }

        return res;
    }
    public static void main(String[] args)
    {
        RomanToNumber ob = new RomanToNumber();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter : ");
        String str = sc.nextLine();
        System.out.println("Integer form of Roman Numeral"+ " is " + romanToDecimal(str));
    }
}
