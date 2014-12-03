import java.util.*;
public class main{
    public static void main(String[] args){
	Random r = new Random();
	SuperArray test = new SuperArray();
	System.out.println(test);
	for(int i = 0; i<1000; i++){
	    test.add(r.nextInt(1000)+i);
	}
	System.out.println(test);
    }
}
