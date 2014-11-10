public class SuperArray{
    private Object[] superArr = null;
    private int lenArr = null;

    public SuperArray(){
	this(10);
    }
    public SuperArray(int len){
	superArr = new Object(len);
    }

    public String toString(){
	String arr = "[]";
	for(int i = 0; i<superArr.length; i++){
	    arr[i+1] = " " + superArr[i];
	}
	return arr;
    }

    public void resize(int Capacity){
	Object[] newArr = new Object(Capacity);
	for (int i = 0; i<superArr.length; i++){
	    newArr[i] = superArr[i];
	}
	superArr = newArr;
    }
    
    public void add(Object O){
	if(lenArr - 1 < superArr.length){
	    superArr[lenArr] = O;
	    lenArr++;
	}
	else{
	    resize(superArr.length + 1);
	    superArr[lenArr] = O;
	    lenArr++;
	}
    }

    public void add(int index, Object O){

    }

    

}
