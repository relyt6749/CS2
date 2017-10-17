/*
Name: Tyler Cooper
HW#: 5
Title: HW5
Description: This program greets user and promps them to select an action: Run the program or exit the program. If the user
             decides to run the program it propts the user for 2 file paths: the first contains the text to be processed and 
             the second is the location to save an output file. Then the program will remove all non Alpha characters excluding
             the ', sort the list, count all the times each word occurs and print it to the provided output file path. It will
             also have an output in the program telling the user the file selected for sorting and the number of unique words
             in the file.

Outside Resource(s): https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
                     http://www.topjavatutorial.com/java-8/java-8-sort-arraylist-using-list-sort-method/
*/

import java.io.*;
import java.util.*;


public class HW5{

   static String f1 = "";//C:\Users\relyt\Desktop\CS2050\CS2 Blanche\HW4.txt
   static String f2 = "";//C:\Users\relyt\Desktop\CS2050\CS2 Blanche\HW5.txt
   static ArrayList<String> fileText = new ArrayList<>();
   static ArrayList<String> alphaOnly = new ArrayList<>();
   static int unique = 0;
   

   public static void greetUser()//Greet the user and present them with the options
   {
      System.out.println("This program sorts a text file and counts all the unique characters\n" + 
                           "Would you like to:\n" + 
                           "\t1:Run this program\n" + 
                           "\t2:Exit this program");
   }
   
   public static void getFilePath()//Get the file path from the user
   {
      Scanner fileNames = new Scanner(System.in); 
      
      System.out.println("Where is the file located?");
      f1 = fileNames.nextLine();
      
      System.out.println("Where would you like to save the output?");
      f2 = fileNames.nextLine();
      
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
      
      /*for(int i = 0; i<uni.length; i++)
      {
         System.out.print(uni[i]+" ");
      }*/
      
      for(int j = 0; j<uni.length-1; j++)
      {
         if(!uni[j].equals(uni[j+1]))
         {
            unique++;
         }
         
      }
   }
   
   public static void outputToFile()
   {
      String[] out = alphaOnly.toArray(new String[0]);
      
      try { 
         FileWriter fw = new FileWriter(f2);
         int count = 0;
         
         for (int i=0; i < out.length-1; i++) 
         {
            if(out[i].equals(out[i+1]))
            {
               count++;
            }
            else if(count == 0 && !out[i].equals(out[i+1]))
            {
               fw.write(out[i] + "\t" + count+1 + "\n");
               count = 0;
            }
            else
            {
               fw.write(out[i-1] + "\t" + count + "\n");
               count = 0;
            }
         }
      }
      catch(IOException e)
      {
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
               
               getFilePath();
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
               outputToFile();
               
               System.out.println("Filename:\t" + f1);
               System.out.println("Number of Unique Words:\t" + unique);
               
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