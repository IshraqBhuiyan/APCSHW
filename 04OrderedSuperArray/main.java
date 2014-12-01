public class main{
    public static void main(String[] args){
	SuperArray test = new SuperArray();
	System.out.println(test);
	for(int i = 0; i<1000; i++){
	    test.add(i);
	}
	System.out.println(test);
    }
}
