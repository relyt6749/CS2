/*
Name: Tyler Cooper
HW#: 2
Title: HW2
Description: This program greets user and promps them to select an action: import data, Display all countries that border germany,
            Display a list of all countries that have pop over 100 million, list all countries that border Germany and have a pop
            of over 100 million, and exit program. The program will import the data from countries.txt. The implimentation will store
            in a linked list and array.
Outside Resource: https://www.tutorialspoint.com/javaexamples/file_append.htm
*/

import java.util.*;
import java.io.*;

public class HW2 extends Countries
{
   public static void greetUser()//Gives user the options the program is capable of with integer index for selection
   {
      System.out.println("Would you like to:\n" + 
                              "\t1: Import the data\n" + 
                              "\t2: Display a list of countries that border Germany\n" + 
                              "\t3: Display a list of countries that have a population greater than 100 million\n" + 
                              "\t4: Display a list of countries that border Germany AND have a population greater than 100 million\n" + 
                              "\t5: Quit the program");
   }
   
   public static void importData(Countries[] country) throws FileNotFoundException //import the data from counties.txt
   {
      //Countries[] country = new Countries[28];
      int i = 0;
      Scanner read = new Scanner (new File("countries.txt"));
      read.useDelimiter(",");
      
      //String name, latitude, longitude;
      //int countryArea, countryPopulation, countryYear;
      //double countryGDP
      
      try{
         while(read.hasNext())
         {
            //Countries country = new Countries();
            country[i].countryName = read.next();
            country[i].latitude = read.next();
            country[i].longitude = read.next();
            country[i].countryArea = read.nextInt();
            country[i].countryPopulation = read.nextInt();
            country[i].countryGDP = read.nextDouble();
            country[i].countryYear = read.nextInt();
            /*System.out.println(country.countryName + " " + country.latitude + " " + country.longitude + " " + 
                                 country.countryArea + " " + country.countryPopulation + " " + country.countryGDP + " " + 
                                 country.countryYear);*/
            i++;
         
         }
      read.close();
      }
      catch (NullPointerException e) {
         System.out.println("exception occoured"+ e);
      }
   }
   
   public static void borderGermany()//displays a list of countries that border Germany
   {
      
   }
   
   public static void popOver100()//displays a list of counties that have a population over 100 million
   {
   
   }
   
   public static void borderGermanyPopOver100()//displays a list of countries that border Germany and have a population over 100 million
   {
      
   }
   public static void main(String[] args) 
   {
      Scanner scanner = new Scanner(System.in);
      boolean repeat = true; //repeat loop
      String choice = ""; //user selection of which item they would like to use
      Countries[] country = new Countries[28];
      
      do
      {
         greetUser();
         //try{
            choice = scanner.nextLine();
         //}
         //catch(IOException e)
         //{
         //   System.out.println("An exception occured " + e);
         //}
         if(choice.equals("1"))
         {
            try{
               importData(country);
            }
            catch(FileNotFoundException e)
            {
               System.out.println(e);
            }
         }
         else if(choice.equals("2"))
         {
            
         }
         else if(choice.equals("3"))
         {
            
         }
         else if(choice.equals("4"))
         {
            
         }
         else if(choice.equals("5"))
         {
            System.out.println("Thank you for using this program");
            repeat = false;
         }
         else 
         {
            repeat = false;
            System.out.print("Invalid Selection. Exiting Program");
         }
      }while(repeat == true);
   }
}