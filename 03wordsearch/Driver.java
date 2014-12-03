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
	// parsing args
	WordGrid w = new WordGrid( );
	//if random see --> Set Random seed
	w.loadWordsFromFile("words.txt", );
	System.out.println("Find these words:\n" + w.wordsInPuzzle());
	System.out.println(w);
    }

}
