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

    public String remove(int index){
	if(index > size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	String old = get(index);
	for(int i = index; i < lenArr - 1; i++){
	    superArr[i] = superArr[i+1];
	}
	lenArr--;
	if(lenArr < (superArr.length / 2)){
	    resize(superArr.length - 1);
	}
	return old;
    }

    public int find(String target){
	for(int i=0;i<size();i++){
	    if(get(i).equals(target)){
		return i;
	    }
	}
	return -1;
    }

    public void insertionFailSort(){
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
/*
    public void push(int start, int end){
	if(!(start<end)){
	    for(int i=end;i>start;i--){
		set(i, get(i-1));
	    }
	}
    }
*/
    public void insertionSort(){
        for(int i=1; i<size(); i++){
	    String j = get(i);
	    int z = i-1;
	    while(z>0 && get(z).compareTo(j) > 0){
		set(z+1, get(z));
		z--;
	    }
	    set(z+1, j);

	}
    }

    public void selectionSort(){
	for(int i=0;i<size();i++){
	    int least = i;
	    for(int z=i;z<size();z++){
		if(get(least).compareTo(get(z)) > 0) least = z;
	    }
	    String leastw = get(least);
	    set(least, get(i));
	    set(i, leastw);
	}
    }
	
    public void badInsertionSort(){
	OrderedSuperArray c = new OrderedSuperArray();
	while( this.size() > 0){
	    c.add(this.remove(0));
	}
	while(c.size() > 0){
	    this.add(c.remove(0));
	}
    }
}
