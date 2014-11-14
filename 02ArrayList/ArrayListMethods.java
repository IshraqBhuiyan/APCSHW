import java.util.*;

public class ArrayListMethods{
    public static void collapseDuplicates(ArrayList<Integer> L){
	for(int i=0; i<L.size(); i++){
	    while(L.get(i+1) == L.get(i)){
		L.remove(i+1);
	    }
	}
    }

    public static void randomize(ArrayList<Integer> L){
	for(int i=0;i<L.size(); i++){
	    Random r = new Random();
	    L.add(L.remove(L.get(r.nextInt(L.size()))));
	}
    }

    public static void main(String[] args){
	ArrayList<Integer> L1 = new ArrayList<Integer>();
	for(int i=0;i < 20; i++){
	    L1.add(i);
	    L1.add(i);
	}
	collapseDuplicates(L1);
	randomize(L1);
	System.out.println(L1);
    }
}
