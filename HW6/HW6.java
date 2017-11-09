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
import java.time.*;
import java.time.temporal.ChronoUnit;

public class HW6{

   static ArrayList<String> array = new ArrayList<>();
   static int BIG = 0;
   static int SIZE = 0;
   static int arrayType = 0;
   static String f1 = "";//C:\Users\relyt\Desktop\CS2050\CS2 Blanche\HW6.txt
   
   static String[] stringArr;
   static Integer[] intArr;
   static Float[] floatArr;
   

   public static void greetUser()//Greet the user and present them with the options
   {
      System.out.println("\nThis program sorts a randomly generated array of type int, float, and string\n" + 
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
      
      System.out.println("what is the SIZE?");
      SIZE = params.nextInt();
      
      if(arrayType == 1 || arrayType == 2)
      {
         System.out.println("What is BIG?");
         BIG = params.nextInt();
      }
      
      
      
   }
   
   public static void getFilePath()
   {
      Scanner filePath = new Scanner(System.in);
      
      System.out.println("Where would you like the output file to be stored?");
      f1 = filePath.nextLine();
   }
   
   
   //trying to figure out generic methods
   public static < T > void printArray(T[] elements)//not working for int or float. Works with string
   {
      for(T element : elements)
      {
         System.out.print(element + " ");
      }
   }
   
   /*
   public static void printArray(int[] A)
   {
      System.out.println("");
      for(int i = 0; i < intArr.length; i++)
      {
         System.out.print(intArr[i] + " ");
      }
   }
   
   public static void printArray(float[] A)
   {
      System.out.println("");
      for(int i = 0; i < floatArr.length; i++)
      {
         System.out.print(floatArr[i] + " ");
      }
   }
   
   public static void printArray(String[] A)
   {
      System.out.println("");
      for(int i = 0; i < stringArr.length; i++)
      {
         System.out.print(stringArr[i] + " ");
      }
   }
   */
   
   public static void generateRandInt()//generates random int array
   {
      Random rand = new Random();
      
      for(int i = 0; i < intArr.length; i++)
      {
         intArr[i] = rand.nextInt(BIG + 1);
         
         //System.out.print(intArr[i] + " "); //for testing 
      }
      
   }
   
   public static void generateRandReal()//generates random float array
   {
      Random rand = new Random();
      
      for(int i = 0; i < floatArr.length; i++)
      {
         floatArr[i] = rand.nextFloat() * BIG + (float).1;
         
         //System.out.print(floatArr[i] + " "); //for testing 
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
   
   public static < T > void internalSort(T[] elements)
   {
      Arrays.sort(elements);
   }
   /*
   public static void internalSort(int[] A)
   {
      Arrays.sort(A);
   }
   
   public static void internalSort(float[] A)
   {
      Arrays.sort(A);
   }
   
   public static void internalSort(String[] A)
   {
      Arrays.sort(A);
   }
   */
   
   public static < T > void outputToFile(T[] elements)
   {
      try{
         FileWriter fw = new FileWriter(f1);
         
         fw.write("Wall Clock for SIZE: " + SIZE + " and BIG: " + BIG);
         LocalTime startTime = LocalTime.now();
         //MergeSort(elements);
         LocalTime stopTime = LocalTime.now();
         long time = ChronoUnit.SECONDS.between(startTime, stopTime);
         fw.write("\tmerge Sort: " + time + " seconds.");  
         LocalTime startTimeI = LocalTime.now();
         internalSort(elements);
         LocalTime stopTimeI = LocalTime.now();
         long timeI = ChronoUnit.SECONDS.between(startTimeI, stopTimeI);
         fw.write("\tInternal Sort: " + time + " seconds.");
         
         fw.write("CPU Time for SIZE: " + SIZE + " and BIG: " + BIG);
         long startTimeCPU = System.nanoTime();
         //MergeSort(elements);
         long stopTimeCPU = System.nanoTime();
         long durationCPU = (stopTimeCPU - startTimeCPU);
         fw.write("\tMerge Sort: " + durationCPU + " nanoseconds.");   
         long startTimeICPU = System.nanoTime();
         internalSort(elements);
         long stopTimeICPU = System.nanoTime();
         long durationICPU = (stopTimeICPU - startTimeICPU);
         fw.write("\tInternal Sort: " + durationICPU + " nanoseconds.");
      }
      
      catch (IOException e){
         System.out.println(e);
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
               
               getParams();
               getFilePath();
               
               switch(arrayType){
                  case 1:
                     
                     intArr = new Integer[SIZE];
                     generateRandInt();
                     outputToFile(intArr);
                     //internalSort(intArr);
                     //printArray(intArr);
                     
                     break;
                  
                  case 2:
                     
                     floatArr = new Float[SIZE];
                     generateRandReal();
                     outputToFile(floatArr);
                     //internalSort(floatArr);
                     //printArray(floatArr);
                     
                     break;
                  
                  case 3:
                     
                     stringArr = new String[SIZE];
                     
                     for(int i = 0; i < stringArr.length; i++)
                     {
                        stringArr[i] = generateRandString();
                        //System.out.print(stringArr[i] + " "); //for testing
                     }
                     
                     outputToFile(stringArr);
                     //internalSort(stringArr);
                     //printArray(stringArr);
                     
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
