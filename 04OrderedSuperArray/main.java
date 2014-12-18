import java.util.*;
public class main{
    public static void main(String[] args){
	//Random r = new Random();
	SuperArray test = new SuperArray();
	String[] test2 = new String[5000];
	//System.out.println(test);
	for(int i = 0; i<5000; i++){
	    test.add(""+i);
	    test2[i] = "" + i;
	}
	System.out.println("array of random Strings\n\n" + test + "\n\n");
	//test.insertionFailSort();
	//System.out.println("Testing insertionFailedSort()\n\n" + test+"\n\n");
	if(args.length >0){
	    if(args[0].equals("insertionSort")){
		test.insertionSort();
		System.out.println(test);
	    }else if(args[0].equals("selectionSort")){
		test.selectionSort();
		System.out.println(test);
	    }else if(args[0].equals("Arrays.sort")){
		Arrays.sort(test2);
		System.out.println(Arrays.toString(test2));
	    }else System.out.println("invalid request for sort");
	}
	//test.insertionSort();
	//System.out.println(test);
    }
}
