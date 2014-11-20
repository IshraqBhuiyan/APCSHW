import java.util.*;
public class WordGrid{
    private char[][]data;
    
    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	clear();
    }

    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for(int i = 0;i < data.length; i++){
	    for(int z = 0; z < data[i].length; z++){
		data[i][z] = ' ';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String puzzle = "";
	for(int i = 0; i<data.length;i++){
	    for(int z = 0; z<data[i].length;i++){
		puzzle += data[i][z];
	    }
	    puzzle += "\n";
	}
	return puzzle;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word,int row, int col){
	if(word.length() > data[row].length - col){
	    return false;
	}
	for(int i = col; i < word.length() + col; i++){
	    if(data[row][i] != ' ' && data[row][i] != word.charAt(i - col)){
		return false;
	    }
	}
	for(int i = col; i< word.length() + col; i++){
	    data[row][i] = word.charAt(i - col);
	}
	return true;
    }

    public boolean addWordVertical(String word, int row, int col){
	if(word.length() > data.length - row){
	    return false;
	}
	for(int i = row; i < word.length(); i++){
	    if(data[i][col] != ' ' && data[i][col] != word.charAt(i - row)){
		return false;
	    }
	}
	for(int i = row; i < word.length(); i++){
	    data[i][col] = word.charAt(i - row);
	}
	return true;
    }

    public boolean addWordDiagnol(String word, int row, int col){
    }
    //vertical + diagonal should be implemented as well.

}


