import java.util.Random;
import java.util.Arrays;
public class Sorts{
    public static void main(String[]args){
	Random r = new Random();
	int[]c = new int[50000];
	for(int i=0;i<50000;i++){
	    c[i] = r.nextInt(100000);
	}
	System.out.println("unsorted list: \n" + Arrays.toString(c));
	bubble(c);
	System.out.println("sorted list: \n" + Arrays.toString(c));
    }
    public static void bubble(int[]c){
	int length = c.length;
	while(length > 0){
	    for(int i=0;i<length-1;i++){
		if(c[i]>c[i+1]){
		    int temp = c[i];
		    c[i] = c[i+1];
		    c[i+1] = temp;
		}
	    }
	    length--;
	}
	
    }
    
    public static void insertion(int[]c){
    }

    public static void selection(int[]c){
    }


}
