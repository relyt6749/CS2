/*
Name: Tyler Cooper
HW#: 1
Title: 1.2.6
Outside Resource: http://stackoverflow.com/questions/10048899/string-to-char-array-java
*/
import java.util.Scanner;
public class Problem6 {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        
        int sSum = 0;
        int tSum = 0;

        String s = scanner.next();
        String t = scanner.next();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        
        for(int i = 0; i < s1.length; i++)
        {
            sSum += s1[i];
        }
        
        for(int i = 0; i < t1.length; i++)
        {
            tSum += t1[i];
        }
        
        if(s.length() == t.length() && sSum == tSum)
        {
            System.out.print(s + " is a circular rotation of " + t);
        }
        
        
        
    }
    
}