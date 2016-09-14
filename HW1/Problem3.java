/*
Name: Tyler Cooper
HW#: 1
Title: 1.1.3
Outside Resource:
*/
import java.util.Scanner;
public class Problem3 {
    public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    
    if (a == b && b == c)
      System.out.print("equal");
    else
      System.out.print("not equal");
    
    }
}