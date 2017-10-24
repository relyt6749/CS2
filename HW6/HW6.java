/*
Name: Tyler Cooper
HW#: 6
Title: HW6
Description: This program greets user and promps them to select an action: Run the program or exit the program. If the user
             decides to run the program it propts the user for two intergers. The first is SIZE wich denotes the length of the
             array. The second is BIG which denotes the maximum number in the random numbers (0 - BIG). Then the program 
             generates an array of length size and it is filled with random numbers. Next it sorts and times the two different
             sorts to be used and prints the results. 

Outside Resource(s): 
*/

import java.io.*;
import java.util.*;


public class HW6{

   static ArrayList<String> array = new ArrayList<>();
   static int BIG = 0;
   static int SIZE = 0;
   static String arrayType = "";
   
   static String[] stringArr;
   static int[] intArr;
   static float[] floatArr;
   

   public static void greetUser()//Greet the user and present them with the options
   {
      System.out.println("This program sorts a text file and counts all the unique characters\n" + 
                           "Would you like to:\n" + 
                           "\t1:Run this program\n" + 
                           "\t2:Exit this program");
   }
   
   public static void getParams()//Gets BIG and SIZE from user
   {
      Scanner params = new Scanner(System.in);
      
      System.out.println("How long is the array?");
      SIZE = params.nextInt();
      
      System.out.println("What is the range of the numbers in the array (0-??)?");
      BIG = params.nextInt();
      
      System.out.println("What type of array is it?\n" + 
                           "\t1: Integers\n" + 
                           "\t2: Real numbers\n" + 
                           "\t3: Strings of 6 characters");
      arrayType = params.nextLine();
      
   }
   
   public static void generateRandInt()
   {
      intArr = new int[SIZE];
      
   }
   
   public static void generateRandReal()
   {
      floatArr = new float[SIZE];
      
   }
   
   public static void generateRandString()
   {
      stringArr = new String[SIZE];
      
   }
   
   public static void internalSort()
   {
      //Collections.sort(alphaOnly);
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
               
               getParams();
               
               switch(arrayType){
                  case "1":
                     
                     generateRandInt();
                     
                     break;
                  
                  case "2":
                     
                     generateRandReal();
                     
                     break;
                  
                  case "3":
                     
                     generateRandString();
                     
                     break;
                  
                  default:
                  
                     System.out.println("Invalid Selection");
                  
                  
               }
                              
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