import java.util.*;
import java.io.*;
public class Driver{
    public static  void openFile(String filename, ArrayList<String> wordList){
	File text = new File(filename);
	Scanner words = new Scanner(text);
	while(words.hasNextLine()){
	    wordList.add(words.nextLine());
	}
    }
    public static void main(String[]args){
	ArrayList<String> wordList = new ArrayList<String>();
	String filename = "";
	openFile(filename, wordList);
	
    }

}
