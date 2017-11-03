/*
Name: Tyler Cooper
HW#: 7
Title: HW7
Description:   This program greets the user and asks them if they would like to run the program. If the user selects that they would like
               to run the program it sorts and gets all the unique words out of a text file and hashes them out acccording to the users hash. If
               the user selects an invalid entry or selects exit program then it determines the propper program exit message and exits the 
               running loop in main.

Outside Resource(s): https://stackoverflow.com/questions/8557192/linked-list-implementation-java
                     https://stackoverflow.com/questions/27654229/how-to-properly-define-an-array-of-linked-list-in-java
                     
*/

import java.io.*;
import java.util.*;
import java.lang.*;


public class HW7{

   static String f1 = "";//C:\Users\relyt\Desktop\CS2050\CS2 Blanche\HW4.txt
   static ArrayList<String> fileText = new ArrayList<>();
   static ArrayList<String> alphaOnly = new ArrayList<>();
   static ArrayList<String> uniques = new ArrayList<>();
   //static String[] myHash;
   static int SIZE = 0;

   public static void greetUser()//Greet the user and present them with the options
   {
      System.out.println("\nThis program sorts all the unique words in a text file into a hash table\n" + 
                           "Would you like to:\n" + 
                           "\t1:Run this program\n" + 
                           "\t2:Exit this program");
   }
   
   public static void getFilePath()//Gets file path from user and hash key
   {
      Scanner fileName = new Scanner(System.in); 
      
      System.out.println("Where is the file you would like to sort and hash located?");
      f1 = fileName.nextLine();
      
      System.out.println("What would you like the hash key to be (int)");
      SIZE = fileName.nextInt();
         
   }
   
   
   
   public static void readFile() throws FileNotFoundException //read file to fileText arraylist
   {
      try{
      
         Scanner text = new Scanner(new File(f1));
         
         while (text.hasNext()) {
            fileText.add(text.next());
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println(e);
      }
   }
   
   public static void removeNonAlpha()
   {
      String[] noSpecial = fileText.toArray(new String[0]);
      
      for(int i = 0; i<fileText.size(); i++) {
         noSpecial[i] = noSpecial[i].replaceAll("[^A-Za-z']", "");
      }
      
      for(int t = 0; t<noSpecial.length; t++)
      {
         noSpecial[t] = noSpecial[t].toLowerCase();
      }
      
      for(int j = 0; j<noSpecial.length; j++)
      {
         alphaOnly.add(noSpecial[j]);
      }
      
   }
   
   public static void internalSort()
   {
      Collections.sort(alphaOnly);
   }
   
   public static void findUnique()
   {
      String[] uni = alphaOnly.toArray(new String[0]);
      
      for(int j = 0; j<uni.length-1; j++)
      {
         if(!uni[j].equals(uni[j+1]))
         {
            uniques.add(uni[j]);
         }
         
      }
   }
   
   public static void main(String[] args) 
   {
      Scanner scanner = new Scanner(System.in);
      String choice = "";
      boolean repeat = true;
   
      while(repeat == true)
      {
         
         greetUser();
         choice = scanner.nextLine();
         
         switch(choice){
            case "1":
               
               getFilePath();
               //myHash = new String[SIZE];
               try
               {
                  readFile();
               }
               catch(FileNotFoundException e)
               {
                  System.out.println(e);
               }
               removeNonAlpha();
               internalSort();
               findUnique();
                              
               break;
               
            case "2":
               
               System.out.println("Thank you for using this program");
               repeat = false;
               break;
               
            default:
               
               repeat = false;
               System.out.print("Invalid Selection. Exiting Program");
               
         }
      }
   }   
}