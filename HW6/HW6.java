/*
Name: Tyler Cooper
HW#: 6
Title: HW6
Description: This program greets user and promps them to select an action: Run the program or exit the program. If the user
             decides to run the program it propts the user for two intergers. The first is SIZE wich denotes the length of the
             array. The second is BIG which denotes the maximum number in the random numbers (0 - BIG). Then the program 
             generates an array of length size and it is filled with random numbers. Next it sorts and times the two different
             sorts to be used and prints the results. 

Outside Resource(s): https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
                     https://stackoverflow.com/questions/13727030/mergesort-in-java
                     https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
                     
*/

import java.io.*;
import java.util.*;
import java.lang.*;


public class HW6{

   static ArrayList<String> array = new ArrayList<>();
   static int BIG = 0;
   static int SIZE = 0;
   static int arrayType = 0;
   
   static String[] stringArr;
   static int[] intArr;
   static float[] floatArr;
   

   public static void greetUser()//Greet the user and present them with the options
   {
      System.out.println("This program sorts a randomly generated array of type int, float, and string\n" + 
                           "Would you like to:\n" + 
                           "\t1:Run this program\n" + 
                           "\t2:Exit this program");
   }
   
   public static void getParams()//Specifies the type of array, BIG, and SIZE from user
   {
      Scanner params = new Scanner(System.in);
      
      System.out.println("What type of array is it?\n" + 
                           "\t1: Integers\n" + 
                           "\t2: Real numbers\n" + 
                           "\t3: Strings of 6 characters");
      arrayType = params.nextInt();
      
      System.out.println("How long is the array?");
      SIZE = params.nextInt();
      
      if(arrayType == 1 || arrayType == 2)
      {
         System.out.println("What is the range of the numbers in the array (0-??)?");
         BIG = params.nextInt();
      }
      
      
   }
   
   /*
   //Messing around with generic methods
   public static <E> void printArray(E[] elements)
   {
      for(E element: elements)
      {
         System.out.println(element);
      }
   }
   */
   
   public static void generateRandInt()//generates random int array
   {
      Random rand = new Random();
      
      for(int i = 0; i < intArr.length; i++)
      {
         intArr[i] = rand.nextInt(BIG + 1);
         
         System.out.println(intArr[i]); //for testing 
      }
      
   }
   
   public static void generateRandReal()//generates random float array
   {
      Random rand = new Random();
      
      for(int i = 0; i < floatArr.length; i++)
      {
         floatArr[i] = rand.nextFloat() * BIG + (float).1;
         
         System.out.println(floatArr[i]); //for testing 
      }
      
   }
   
   public static String generateRandString()//generates random string
   {
      String chars = "ABCDEFGHIJKLMNOPQRSTUVWYXZabcdefghijklmnopqrstuvxyz";
      StringBuilder salt = new StringBuilder();
      Random rnd = new Random();
         
      while (salt.length() < 6) // length of the random string.
      { 
            
         int index = (int)(rnd.nextFloat() * chars.length());
         salt.append(chars.charAt(index));
            
      }
      return salt.toString(); 
      
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
                  case 1:
                     
                     intArr = new int[SIZE];
                     generateRandInt();
                     
                     break;
                  
                  case 2:
                     
                     floatArr = new float[SIZE];
                     generateRandReal();
                     
                     break;
                  
                  case 3:
                     
                     stringArr = new String[SIZE];
                     
                     for(int i = 0; i < stringArr.length; i++)
                     {
                        stringArr[i] = generateRandString();
                        System.out.println(stringArr[i]); //for testing
                     }
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