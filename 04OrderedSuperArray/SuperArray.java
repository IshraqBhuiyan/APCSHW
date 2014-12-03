public class SuperArray{
    private String[] superArr;
    private int lenArr;

    public SuperArray(){
	this(10);
    }
    public SuperArray(int len){
	superArr = new String[len];
    }

    public String toString(){
	String str = "[";
	for(int i = 0; i<size(); i++){
           str += " " + superArr[i];
	}
	str+= "]";
	return str;
    }

    public void resize(int Capacity){
	String[] newArr = new String[Capacity];
	for (int i = 0; i<superArr.length; i++){
	    newArr[i] = superArr[i];
	}
	superArr = newArr;
    }

    public int size(){
	return lenArr;
    }

    public void add(String O){
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

    public void add(int index, String O){
	while(lenArr> superArr.length || index > superArr.length -1){
	    resize((superArr.length+1) *2);
	}
        if(index < lenArr){
	    for(int i = lenArr; i > index; i--){
		superArr[i] = superArr[i - 1];
	    }
	}
	superArr[index] = O;
	lenArr++;
    }

    public String set(int index, String O){
	if(index > superArr.length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	String old = null;
	old = superArr[index];
	superArr[index] = O;
	return old;

    }

    public String get(int index){
	if(index > superArr.length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	return superArr[index];
    }

    public void clear(){
	superArr = new String[lenArr * 2];
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

    public void insertionSort(){
	for(int i = 1; i<size(); i++){
	    if(get(i).compareTo(get(i-1)) < 0){
		int z = 0;
		while(get(z).compareTo(get(i)) < 0){
		    z++;
		}
		add(z, get(i));
		remove(i+1);
	    }
	}
    }

}
