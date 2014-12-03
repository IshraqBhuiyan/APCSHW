import java.util.*;
import java.io.*;
public class Driver{
    /*public static  void openFile(String filename, ArrayList<String> wordList){
	File text = new File(filename);
	Scanner words = new Scanner(text);
	while(words.hasNextLine()){
	    wordList.add(words.nextLine());
	}
	}*/
    public static void main(String[]args){
	ArrayList<String> wordList = new ArrayList<String>();
	String filename = "words.txt";
	//openFile(filename, wordList);
	WordGrid test = new WordGrid(10, 10);
	Random rng = new Random();
	test.addWordHorizontal("bacon", 0, 0);
	System.out.println(test);
	
    }

}
