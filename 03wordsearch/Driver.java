import java.util.*;
import java.io.*;
public class Driver{
    public static void main(String[]args){
	// parsing args
	if(args.length == 0){
	    WordGrid w = new WordGrid(20, 20, 0, true);
	}else if(args.length == 1){
	    int rows = Integer.parseInt(args[0]);
	    WordGrid w = new WordGrid(rows, 20, 0, true);
	}else if(args.length == 2){
	    int rows = Integer.parseInt(args[0]);
	    int cols = Integer.parseInt(args[1]);
	    WordGrid w = new WordGrid(rows, cols, 0, true);
	}else if(args.length == 3){
	    int rows = Integer.parseInt(args[0]);
	    int cols = Integer.parseInt(args[1]);
	    int seed = Integer.parseInt(args[2]);
	    WordGrid w = new WordGrid(rows, cols, seed, true);
	}else {
	    int rows = Integer.parseInt(args[0]);
	    int cols = Integer.parseInt(args[1]);
	    int seed = Integer.parseInt(args[2]);
	    boolean filling = true;
	    if(Integer.parseInt(args[3]) == 1){
		filling = false;
	    }
	    WordGrid w = new WordGrid(rows, cols, seed, filling);
	}
	w.loadWordsFromFile("words.txt", );
	System.out.println("Find these words:\n" + w.wordsInPuzzle());
	System.out.println(w);
    }

}
