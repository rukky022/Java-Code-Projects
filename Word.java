import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Word {
  
  //instance variable
  private String word;
  
  //constructor
  public Word () {
  }
  
  //accessor method
  public String getWord() {
    return word;
  }
  
  //mutator method
  public void setWord(String w)  {
    word = w;
  }
  
  //toString method
  public String toString() {
    return word;
  }
  
  //method to determine if character is punctuation
  public static boolean isPunc (String t, int x) {
    if (t.charAt(x) == ',' || t.charAt(x) == '.' || t.charAt(x) == '!' || t.charAt(x) == ')' || t.charAt(x) == '"')
      return true;
    else
      return false;
  }
  
  //method to read each word in the file into an ArrayList
  public static ArrayList<Word> readWordsInFile (File name) throws FileNotFoundException{
    
    //creating variables
    Scanner forFile = new Scanner(new File(""+name+""));
    ArrayList<Word> array = new ArrayList<Word>();
    int j, x;
    String text = forFile.nextLine();
    
    //placing all text in file in one String
    while (forFile.hasNextLine()){
      text = text + " " + forFile.nextLine();
    }
    
    
    //running through each word and adding it to the arrayList
    for(int i = 0; i < text.length(); i++) {
      if (i == 0 || text.charAt(i) == ' ') {
        i++;
        if ( i - 1 == 0){
          i--;
        }
        j = i;
        while(i < text.length() && isPunc(text, i) == false && text.charAt(i) != ' '){
          i++;
        }
        x = i;
        Word newW = new Word();
        newW.setWord(text.substring(j, x).toLowerCase());
        array.add(newW);
        i--;
      }
    } 
    
    //return statement
    return array;
  }
  
  //method to find the number of inputted word
  public static String numOfWord (File input, String wd) throws FileNotFoundException {
    
    //creating variables
    ArrayList<Word> arr = readWordsInFile(input);
    int count = 0;
    Word x = new Word();
    x.setWord(wd.toLowerCase());
    
    //checking for inputed string
    for(Word n: arr) {
      if(n.toString().equals(x.toString())){
        count++;
      }
    }
    
    //return statements
    if (count == 1)
      return "\nThe word \"" + wd + "\" occurred " + count + " time in the file " + input + ".";
    
    return "\nThe word \"" + wd + "\" occurred " + count + " times in the file " + input + ".";
  }
  
  //main method
  public static void main (String[] args) throws FileNotFoundException{
    
    //First Scanner
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Please enter the name of a txt file that doesn't have spaces (example: sampleForAssign.txt): ");
    String fileName = keyboard.nextLine();
    
    //Creating File Object of document
    File test = new File(""+fileName+"");
    
    //Second Scanner
    Scanner keyboard2 = new Scanner(System.in);
    System.out.print("What word would you like to find the number of occurences of?");
    String word = keyboard2.nextLine();
    
    //Method call of numOfWord
    System.out.println(numOfWord(test, word));
  }
  
}