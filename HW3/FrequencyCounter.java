public class FrequencyCounter
{
 public static void main(String[] args)
 {
  //declare Symbol table
  ST symbolTable 
     = new ST();
  //read input from user until user enters 
  //string 'exit'
  while(!StdIn.isEmpty())
  {
   String word = StdIn.readString();
   if (word.equals("exit"))
    break;
   //if the symbol does not contain the 
   //word add it to table with count 1
   if (!symbolTable.contains(word))
    symbolTable.put(word, 1);
   else
    //if it present in table update 
    //count by 1
    symbolTable.put(word, 
symbolTable.get(word) + 1);
  }
  //find the key with highest frequency count
  String max = "";
  symbolTable.put("", 0);
  for (String word : symbolTable.keys())
  {
   if (symbolTable.get(word) > 
symbolTable.get(max))
    max = word;
  }
  //declare queue to find word
  Queue queue = new Queue();
  for (String word : symbolTable.keys())
  {
   if (symbolTable.get(max) == 
symbolTable.get(word))
    queue.enqueue(word);
  }
  System.out.println("-----Result---------");
  //print the result
  while(!queue.isEmpty())
   StdOut.println(queue.dequeue());
 }
}
