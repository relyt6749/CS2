/*
Name: Tyler Cooper
HW#: 1
Title: UserLogin
Description: This program greets user and tell them the requirements of a valid login. It then asks the user to input a login of their choice.
             If the login meats all the requirements that are specified it returns a valid message. If the login is invalid then it prints that
             the login is invalid and shows reasons why.
Outside Resource: https://www.tutorialspoint.com/javaexamples/file_append.htm
*/
import java.util.Scanner;
import java.io.*;

public class UserLogin 
{

   public static void greetUser()//Greets user and gives login requirements
   {
      System.out.println("Hello user, this program is designed to test the validity of your login");
      System.out.println("Your login information must be at least 5 characters and contain at least:");
      System.out.println("\tOne Uppercase and One Lowercase letter");
      System.out.println("\tOne Digit 0-9");
      System.out.println("\tOne of these special characters:!@#$");
      System.out.println("Please enter login information");
      System.out.print("Login: ");
   }
   
   public static String readUser(String LoginFromUser)//reads string from user
   {
      Scanner scanner = new Scanner(System.in);
      //System.out.println("Login: ");
      String login = LoginFromUser;
      return login;
   }
   
   public static boolean checkCase(String CapLow)//checks string for upper and lower case
   {
      boolean hasUpper = !CapLow.equals(CapLow.toLowerCase());//checks if string is identical to full lower case version of itself
      boolean hasLower = !CapLow.equals(CapLow.toUpperCase());//checks if string is identical to full upper case version of itself
      
      //if(!hasUpper)
         //System.out.println("\t -- no uppercase letter");
         
      //if(!hasLower)
         //System.out.println("\t -- no lowercase letter");
         
      if(!hasUpper || !hasLower)
         return false;
      else
         return true;
   }
   
   public static boolean checkLength(String has5)//checks string lenght
   {
      boolean len = has5.length() >= 5;
      
      //if(!len)
         //System.out.println("\t -- too short (minimum of 5 characters)");
      
      if(!len)
         return false;
      else
         return true;
   }
   
   public static boolean checkDigit(String Digit)//checks for digit 0-9
   {
      char[] DiSp = Digit.toCharArray();
      boolean hasNum = false;
      
      for(int i = 0; i < Digit.length(); i++)//digits
      {
         if(DiSp[i] == '0' || DiSp[i] == '1' || DiSp[i] == '2' || DiSp[i] == '3' 
            || DiSp[i] == '4' || DiSp[i] == '5' || DiSp[i] == '6' || DiSp[i] == '7' 
            || DiSp[i] == '8' || DiSp[i] == '9')
            hasNum = true;
      }
      
      //if(!hasNum)
         //System.out.println("\t -- no digit (0-9)");
      
      return hasNum;
   }
   
   public static boolean checkSpecial(String Special)//checks for special characters !@#$
   {
      char[] DiSp = Special.toCharArray();
      boolean hasSpecial = false;
      
      for(int i = 0; i < Special.length(); i++)//special characters
      {
         if(DiSp[i] == '!' || DiSp[i] == '@' || DiSp[i] == '#' || DiSp[i] == '$')
            hasSpecial = true;
            
/*         if(DiSp[i] == '%' || DiSp[i] == '^' || DiSp[i] == '&' || DiSp[i] == '*'
             || DiSp[i] == '(' || DiSp[i] == ')' || DiSp[i] == '-' || DiSp[i] == '_' || DiSp[i] == '=' || DiSp[i] == '+')
            hasSpecial = false; */
      }
      
      //if(!hasSpecial)
         //System.out.println("\t -- no/invalid special character");
      
      return hasSpecial;
   }
   
   public static boolean checkBadSpecial(String badSpecial)//checks for invalid special characters %^&*()_-+=
   {
      char[] DiSp = badSpecial.toCharArray();
      boolean badSp = false;
      
      for(int i = 0; i < badSpecial.length(); i++)//invalid special characters
      {            
         if(DiSp[i] == '%' || DiSp[i] == '^' || DiSp[i] == '&' || DiSp[i] == '*'
             || DiSp[i] == '(' || DiSp[i] == ')' || DiSp[i] == '-' || DiSp[i] == '_' || DiSp[i] == '=' || DiSp[i] == '+')
            badSp = true;
      }
      
      //if(!badSpecial)
         //System.out.println("\t -- no/invalid special character");
      
      return badSp;
   }
   
   public static boolean checkValidity(boolean CapLow, boolean len, boolean digit, boolean special, boolean badSpecial)//checks for all parameters to be met
   {
       if(!CapLow || !len || !digit || !special || badSpecial)
      {
         /*System.out.println("\t(INVALID)");
         if(!CapLow)
            System.out.println("\t -- no upper/lower case letter");
         if(!len)
            System.out.println("\t -- too short (minimum of 5 characters");
         if(!digit)
            System.out.println("\t -- no digit (0-9)");
         if(!special)
            System.out.println("\t -- no special character (!@#$)");
         if(badSpecial)
            System.out.println("\t -- invalid special character");*/
            
         return false;
      }
      else
         {
            //System.out.println("\t(VALID)"); 
            return true;
         } 
   }
   
   public static void printUser(String login, boolean CapLow, boolean len, boolean digit, boolean special, boolean badSpecial, boolean val)//LoginValidity
   {
      if(!val)
      {
         System.out.println("\t" + login + "\t(INVALID)");
         if(!CapLow)
            System.out.println("\t\t -- no upper/lower case letter");
         if(!len)
            System.out.println("\t\t -- too short (minimum of 5 characters");
         if(!digit)
            System.out.println("\t\t -- no digit (0-9)");
         if(!special)
            System.out.println("\t\t -- no special character (!@#$)");
         if(badSpecial)
            System.out.println("\t\t -- invalid special character");

      }
      else
         {
            System.out.println("\t" + login + "\t(VALID)"); 
         }
   }
   
   public static void addToReport(String login, boolean CapLow, boolean len, boolean digit, boolean special, boolean badSpecial, boolean val)
   {
      String report;
      
      if(!val)
      {
         report =login + "\t(INVALID)";
         if(!CapLow)
            report = report + "\n\t-- no upper/lower case letter";
         if(!len)
            report = report + "\n\t-- too short (minimum of 5 characters)";
         if(!digit)
            report = report + "\n\t-- no digit (0-9)";
         if(!special)
            report = report + "\n\t-- no special character (!@#$)";
         if(badSpecial)
            report = report + "\n\t-- invalid special character";

      }
      else
         {
            report =login + "\t(VALID)"; 
         }
         
      //System.out.println(report);
      try {
         BufferedWriter out = new BufferedWriter(new FileWriter("login.txt"));
         out.write("User Login Report\n");
         out.close();
      }
      catch (IOException e) {
         System.out.println("exception occoured"+ e);
      }
         
      printReport(report);
   }
   
   public static void printReport(String newLogin)//not fully working. only prints last login and appropriate erro
   {
      try {
         
         BufferedReader in = new BufferedReader(new FileReader("login.txt"));
         String str;
         
         while ((str = in.readLine()) != null) {
            //System.out.println(str);
         }
         in.close();
         
         BufferedWriter out = new BufferedWriter(new FileWriter("login.txt"),1);
         out.write(str + newLogin);
         out.close();
      }

      catch (IOException e) {
         System.out.println("exception occoured"+ e);
      }
   }


   
   public static void main(String[] args) 
   {
   
      Scanner scanner = new Scanner(System.in);
      
      boolean cont;
      boolean upperLower;
      boolean len;
      boolean special;
      boolean badSpecial;
      boolean digit;
      boolean val;
      
      do
      {
         
         UserLogin myLog = new UserLogin();
         
         UserLogin.greetUser();
      
         //System.out.println("Login: ");
         //String login = "Happy#@!888";
         //String login = "go_t";
         //String login = "asdfg";
         //String login = "ASDFG";
         //String login = "ASD123";
         //String login = "asd123";
         //String login = "Asd123";
         //String login = "Asd123!@";
         //String login = "Asd123@#$%^&";
         String login = scanner.nextLine();
      
         myLog.readUser(login);
         upperLower = myLog.checkCase(login);
         len = myLog.checkLength(login);
         digit = myLog.checkDigit(login);
         special = myLog.checkSpecial(login);
         badSpecial = myLog.checkBadSpecial(login);
         val = myLog.checkValidity(upperLower, len, digit, special, badSpecial);
         myLog.printUser(login, upperLower, len, digit, special, badSpecial, val);
         myLog.addToReport(login, upperLower, len, digit, special, badSpecial, val);
         
         System.out.println("Would you like to try another login? Y/N");
         String YN = scanner.nextLine();
         if(YN.equals("Y") || YN.equals("y"))
            cont = true;
         else if(YN.equals("N") || YN.equals("n"))
         {
            cont = false;
            System.out.print("Thank you for checking the validity of your login(s). Exiting program");
         }
         else
         {
            cont = false;
            System.out.print("Invalid Selection. Exiting Program");
         }
      }   
      while(cont == true);
      
   }        
}