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

    public int size(){
	return lenArr;
    }
    
    public void add(Object O){
      	/*if(lenArr < superArr.length){
	    superArr[lenArr] = O;
	    lenArr++;
	}
	else{
	    resize(superArr.length * 2);
	    superArr[lenArr] = O;
	    lenArr++;
	}
	*/
	add(lenArr, O);
    }

    public void add(int index, Object O){
	while(lenArr> superArr.length || index > superArr.length -1){
	    resize((superArr.length+1) *2);
	}
        if(index < lenArr){
	    for(int i = lenArr; i > index; i--){
		superArr[i] = superArr[i - 1];
	    }
	}
	superArr[index] = O;
    }

    public Object set(int index, Object O){
	if(index > superArr.length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Object old = null;
	old = superArr[index];
	superArr[index] = O;
	return old;

    }

    public Object get(int index){
	if(index > superArr.length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	return superArr[index];
    }

    public void clear(){
	superArr = new Object(lenArr * 2);
	lenArr = 0;
    }

    public void remove(int index){
	if(index > superArr.length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	for(int i = index; i < lenArr - 1; i++){
	    superArr[i] = superArr[i+1];
	}
	lenArr--;
	if(lenArr < (superArr.length / 2)){
	    resize(superArr.length - 1);
	}
    }

}
