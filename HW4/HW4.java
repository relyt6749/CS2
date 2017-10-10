/*
Name: Tyler Cooper
HW#: 4
Title: HW4
Description: This program greets user and promps them to select an action: import data and exit program. 
            The program will import the data from a text file specified by the user. The program will read 
            in the file, store it in an array, remove special characters and duplicate the file. The program
            will bubble sort the first file and system sort the second file. The program will also time how 
            long each sort takes in real time and CPU time.
Outside Resource(s): https://github.com/rrosebrook/HW4/blob/master/HW4.java
                     http://www.oracle.com/technetwork/articles/java/jf14-date-time-2125367.html
                     https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
                     https://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html
                     http://memorynotfound.com/calculating-elapsed-time-java/
                     https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#nanoTime--
                     https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
                     http://www.topjavatutorial.com/java-8/java-8-sort-arraylist-using-list-sort-method/
*/

import java.io.*;
import java.util.*;
import java.time.*;
//rrosebrook
import java.time.temporal.ChronoUnit;

public class HW4{

   //rrosebrook
   static String f1 = "";//C:\Users\relyt\Desktop\CS2050\CS2 Blanche\HW4.txt
   static String f2 = "";//C:\Users\relyt\Desktop\CS2050\CS2 Blanche\HW4_C1.txt
   //static String f3 = "";//C:\Users\relyt\Desktop\CS2050\CS2 Blanche\HW4_C2.txt
   static ArrayList<String> fileText = new ArrayList<>();
   static ArrayList<String> noSpecialText = new ArrayList<>();
   static ArrayList<String> noSpecialText2 = new ArrayList<>();

   public static void greetUser()//Greet the user and present them with the options
   {
      System.out.println("This program tests the run time of two diffetent sorts on two text files\n" + 
                           "Would you like to:\n" + 
                           "\t1:Run this program\n" + 
                           "\t2:Exit this program");
   }
   
   public static void getFilePath()//Get the file paths from the user
   {
      Scanner fileNames = new Scanner(System.in); 
      
      System.out.println("Where is the file located?");
      f1 = fileNames.nextLine();
      
      System.out.println("Path to save file #1: ");
      f2 = fileNames.nextLine();
      
      //System.out.println("Path to save file #2: ");
      //f3 = fileNames.nextLine();
      
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
   
   public static void removeAndWrite()
   {
      String[] noSpecial = fileText.toArray(new String[0]);
      
      for(int i=0; i<fileText.size(); i++) {
         noSpecial[i] = noSpecial[i].replaceAll("[^a-zA-Z]", "");
      }
      
      try { 
         FileWriter fw = new FileWriter(f2);
            
         for (int i=0; i < fileText.size(); i++) {
            fw.write(noSpecial[i] + " ");
         }
      }
      catch(IOException e)
      {
         System.out.println(e);
      }
      
   }
   
   public static void getNewFiles()
   {
      try{
      
         Scanner text = new Scanner(new File(f2));
         
         while (text.hasNext()) {
            noSpecialText.add(text.next());
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println(e);
      }
      
      try{
      
         Scanner text2 = new Scanner(new File(f2));
         
         while (text2.hasNext()) {
            noSpecialText2.add(text2.next());
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println(e);
      }
   }
   
   public static void bubbleSort()
   {
      for(int j = 0; j<noSpecialText.size(); j++) 
      {
         for(int i = j + 1; i<noSpecialText.size(); i++) 
         {
            if((noSpecialText.get(i)).compareToIgnoreCase(noSpecialText.get(j))<0)
            {
               String t = noSpecialText.get(j);
               noSpecialText.set(j, noSpecialText.get(i));
               noSpecialText.set(i, t);
            }
         }
      }
   }
   
   public static void internalSort()
   {
      Collections.sort(noSpecialText2);
   }
   
   //rrosebrook
   public static void wallClock()
   {
      System.out.println("Wall Clock");
      LocalTime startTime = LocalTime.now();
      bubbleSort();
      LocalTime stopTime = LocalTime.now();
      long time = ChronoUnit.SECONDS.between(startTime, stopTime);
      System.out.println("\tBubble Sort: " + time + " seconds.");
        
      LocalTime startTimeI = LocalTime.now();
      internalSort();
      LocalTime stopTimeI = LocalTime.now();
      long timeI = ChronoUnit.SECONDS.between(startTimeI, stopTimeI);
      System.out.println("\tInternal Sort: " + time + " seconds.");
   }
   
   //rrosebrook
   public static void cpuTime()
   {
      System.out.println("CPU Time");
      long startTime = System.nanoTime();
      bubbleSort();
      long stopTime = System.nanoTime();
      long duration = (stopTime - startTime);
      System.out.println("    Bubble Sort: " + duration + " nanoseconds.");   
      long startTimeI = System.nanoTime();
      internalSort();
      long stopTimeI = System.nanoTime();
      long durationI = (stopTimeI - startTimeI);
      System.out.println("    Internal Sort: " + durationI + " nanoseconds.");
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
               try
               {
                  readFile();
               }
               catch(FileNotFoundException e)
               {
                  System.out.println(e);
               }
               
               removeAndWrite();
               getNewFiles();
               
               System.out.println("Filename:\t" + f1);
               System.out.println("Number of Words:\t" + noSpecialText.size());
               
               wallClock();
               cpuTime();
               //bubbleSort();
               //internalSort();
               
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