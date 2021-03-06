import java.util.*;
import java.io.*;
public class WordGrid{
    private char[][]wordsearch;
    private Random rand;
    private ArrayList<String> wordList;
    private boolean fillRandom;

    public WordGrid(int rows,int cols, int seed, boolean fillRandomly){
	wordsearch = new char[rows][cols];
	rand = new Random();
	wordList = new ArrayList<String>();
	setSeed(seed);
	fillRandom = fillRandomly;
	clear();
    }

    public void clear(){
	for(int i = 0;i < wordsearch.length; i++){
	    for(int z = 0; z < wordsearch[i].length; z++){
		wordsearch[i][z] = '_';
	    }
	}
    }

    public void fill(){
	for(int i=0;i<wordsearch.length;i++){
	    for(int z=0;z<wordsearch[i].length;z++){
		if(wordsearch[i][z]=='_'){
		    wordsearch[i][z] = (char)(rand.nextInt(26)+'a');
		}
	    }
	}
    }

    public void loadWordsFromFile(String filename) throws FileNotFoundException{
	ArrayList<String> ListOfWords = new ArrayList<String>();
	File text = new File(filename);
	Scanner scans = new Scanner(text);
	while(scans.hasNextLine()){
	    ListOfWords.add(scans.nextLine());
	}
	addManyWordsToList(ListOfWords);
	if(fillRandom){
	    fill();
	}
    }

    public void setSeed(int seed){
	if(seed != 0){
	    rand.setSeed(seed);
	}
    }

    public String wordsInPuzzle(){
	String findWords = new String();
	for(int i=0; i<wordList.size();i++){
	    if(i%4 == 0){
		findWords += "\n";
	    }
	    findWords += wordList.get(i);
	    findWords += "       ";
	}
	return findWords;
    }
    
    public String toString(){
	String puzzle = "";
	for(int i = 0; i<wordsearch.length;i++){
	    for(int z = 0; z<wordsearch[i].length;z++){
		puzzle += wordsearch[i][z];
	    }
	    puzzle += "\n";
	}
	return puzzle;
    }


    public boolean addWord(String word, int row, int col, int dx, int dy){
	if((dx > 1 || dx < -1 || dy > 1 || dy < -1) || (dx==0 && dy==0)||
	   (dx==1 && word.length()>wordsearch[row].length - col) ||
	   (dx==-1 && word.length()>col+1) || (dy==1 && word.length()>wordsearch.length - row) ||
	   (dy==-1 && word.length()>row+1)){
	    return false;
	}
	for(int i=0;i<word.length();i++){
	    if((wordsearch[row + dy*i][col + dx*i] != '_') && (wordsearch[row + dy*i][col + dx*i] != word.charAt(i))){
		return false;
	    }
	}
	for(int i=0;i<word.length();i++){
	    wordsearch[row + dy*i][col + dx*i] = word.charAt(i);
	}
	return true;
    }

    public void addManyWordsToList(ArrayList<String> words){
	for(int i=0;i<words.size();i++){
	    int z=0;
	    while(z<5){
		if(addWord(words.get(i),rand.nextInt(wordsearch.length), rand.nextInt(wordsearch[0].length), rand.nextInt(3) + -1, rand.nextInt(3) + -1)){
		    wordList.add(words.get(i));
		    break;
		}
		z++;
	    }
	}
    }
    

}


