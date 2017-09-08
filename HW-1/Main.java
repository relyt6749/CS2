import java.io.*;

public class Main {
   public static void main(String[] args) throws Exception {
      try {
         BufferedWriter out = new BufferedWriter(new FileWriter("filename.txt"));
         out.write("aString1\n);
         out.close();
         out = new BufferedWriter(new FileWriter("filename.txt",true));
         out.write("aString2");
         out.close();
         BufferedReader in = new BufferedReader(new FileReader("filename.txt"));
         String str;
         
         while ((str = in.readLine()) != null) {
            System.out.println(str);
         }
         in.close();
      }
      //in.close();
      catch (IOException e) {
         System.out.println("exception occoured"+ e);
      }
   }
}