import java.util.*;
public class main{
    public static void main(String[] args){
	//Random r = new Random();
	SuperArray test = new SuperArray();
	System.out.println(test);
	for(int i = 0; i<500000; i++){
	    test.add(""+i);
	}
	System.out.println("array of random Strings\n\n" + test + "\n\n");
	//test.insertionFailSort();
	//System.out.println("Testing insertionFailedSort()\n\n" + test+"\n\n");
	if(args.length >0){
	    if(args[0].equals("insertionSort")){
		test.insertionSort();
	    }else if(args[0].equals("selectionSort")){
		test.selectionSort();
	    }else if(args[0].equals("Arrays.sort")){

	    }else System.out.println("invalid request for sort");
	}
	test.insertionSort();
	System.out.println(test);
    }
}
