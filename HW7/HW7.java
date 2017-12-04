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
//package HW7;

import java.io.*;
import java.util.*;
import java.lang.*;


public class HW7{

   static String f1 = "";//C:\Users\relyt\Desktop\CS2050\CS2 Blanche\HW4.txt
   static ArrayList<String> fileText = new ArrayList<>();
   static ArrayList<String> alphaOnly = new ArrayList<>();
   static ArrayList<String> uniques = new ArrayList<>();
   //static LinkedList[] myHash;
   static int SIZE = 0, primeLow = 0, primeHigh = 0;

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
      
      System.out.println("What would you like the hash key to be (positive int, preferably prime and larger than 2)\n" + 
                           "If it isn't prime I will find the closest prime.");
      SIZE = fileName.nextInt();
      
      while(SIZE <= 2)
      {
         System.out.println(SIZE + "Does not meet the requirements. Enter a larger number.");
         SIZE = fileName.nextInt();
      }
         
   }
   
   public static void findPrime()
   {
      Scanner pr = new Scanner(System.in);
      String choice = "";
      boolean isPrime = true;
      boolean isPrimeLow = true;
      boolean isPrimeHigh = true;
      
      for(int i = 2; i < SIZE; i++)
      {
         if(SIZE % i == 0)
         {
            isPrime = false;
            break;
         }
      }
      
      if(isPrime == false)
      {
         primeLow = SIZE-1;
         primeHigh = SIZE+1;
         
         while(isPrimeLow == true)
         {
            for(int j = 2; j < primeLow; j++)
            {
               if(primeLow % j == 0)
               {
                  isPrimeLow = false;
               }
            }
            
            if(isPrimeLow)
            {
               System.out.println("The closest prime below " + SIZE + " is " + primeLow);
               break;
            }
            
            if(!isPrimeLow)
            {
               primeLow--;
               isPrimeLow = true;
            }
         }
         
         while(isPrimeHigh == true)
         {
            for(int j = 2; j < primeHigh; j++)
            {
               if(primeHigh % j == 0)
               {
                  isPrimeHigh = false;
               }
            }
            
            if(isPrimeHigh)
            {
               System.out.println("The closest prime above " + SIZE + " is " + primeHigh);
               break;
            }
            
            if(!isPrimeHigh)
            {
               primeHigh++;
               isPrimeHigh = true;
            }
         }
      }
      
      while(choice.equals(""))
      {   
         System.out.println("Which prime would you like to use?\n" +
                              "\t1: " + primeLow + 
                              "\n\t2: " + primeHigh);
                              
         choice = pr.nextLine();
         
         switch(choice){
            case "1":
               
               SIZE = primeLow;
               break;
               
            case "2":
               
               SIZE = primeHigh;
               break;
               
            default:
            
               System.out.println("Invalid selection. Try again.");
               choice = "";
         }
      }
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
   
   public static void hashTheFile()
   {
      int strVal = 0;
      int index = 0;
      String[] uni = uniques.toArray(new String[0]);
      for(int i = 0; i < uni.length; i++)
      {
         for (int j = 0;j < uni[i].length(); j++)
         {
            strVal += (int)uni[i].charAt(j);   
         }
         
         System.out.println("strVal: " + strVal);
         index = strVal % SIZE;
         System.out.println("Index: " + index);
         //myHash[index].insertAtEnd(uni[i]);
      }
   }
   
   public static void main(String[] args) 
   {
      HW7 hw7 = new HW7();
      
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
               findPrime();
               //myHash = new LinkedList[SIZE];
               try
               {
                  readFile();
                  removeNonAlpha();
                  internalSort();
                  findUnique();
                  hashTheFile();
               }
               catch(FileNotFoundException e)
               {
                  System.out.println(e);
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