import java.io.*; 
class Main 
{ 
    public static void main(String[] args) throws IOException 
    { 
        // BufferedReader Class for Fast buffer Input 
        BufferedReader br = new BufferedReader( 
                               new FileReader("input.txt")); 
        // while((line = br.readLine()) != null) ...
        // PrintWriter class prints formatted representations 
        // of objects to a text-output stream. 
        PrintWriter pw=new PrintWriter(new
                BufferedWriter(new FileWriter("output.txt"))); 
  
        // Your code goes Here 
        //pw.println(line) //appends a line
  
        pw.flush(); 
    } 
} 
