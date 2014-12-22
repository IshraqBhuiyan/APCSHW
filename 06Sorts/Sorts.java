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
	long diff;
	if(args.length > 0 && args[0].equals("bubble")){
	    long start = System.currentTimeMillis();
	    bubble(c);
	    long end = System.currentTimeMillis();
	    diff = end - start;
	}
	else if(args.length > 0 && args[0].equals("insertion")){
	    long start = System.currentTimeMillis();
	    insertion(c);
	    long end = System.currentTimeMillis();
	    diff = end - start;
	}
	else{
	    long start = System.currentTimeMillis();
	    selection(c);
	    long end = System.currentTimeMillis();
	    diff = end - start;
	}
	//bubble(c);
	//insertion(c);
	
	//selection(c);
	System.out.println("sorted list: \n" + Arrays.toString(c) + "\n" + "Time taken for sort: \n" + diff + " milliseconds\n");
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
	for(int i=1;i<c.length;i++){
	    int temp = c[i];
	    int z = i-1;
	    while(z>=0 && c[z] > temp){
		c[z+1] = c[z];
		z--;
	    }
	    c[z+1] = temp;
	}
    }

    public static void selection(int[]c){
	for(int i=0;i<c.length;i++){
	    int least = i;
	    for(int z=i;z<c.length;z++){
		if(c[z]<c[least]) least = z;
	    }
	    int temp = c[i];
	    c[i] = c[least];
	    c[least] = temp;
	}
		
    }


}
