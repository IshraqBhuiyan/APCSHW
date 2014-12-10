public class OrderedSuperArray extends SuperArray{
    
    public OrderedSuperArray(){
	this(10);
    }

    public OrderedSuperArray(int len){
	super(len);
    }

    public void add(int index, String O){
	this.add(O);
    }

    public void add(String O){
	int place = 0;
	while(super.get(place).compareTo(O) < 0){
	    place++;
	}
	super.add(place,O);
    }

    public String set(int index, String O){
	add(O);
	return remove(index);
    }

    public int find(String target){
	int split = 2;
	int index = size()/split;
	while(target.compareTo(get(index))>0){
	    split = split*2;
	    index += size()/split;
	}
	for(;index>0 && get(index).compareTo(target) >= 0; index--);
	return index;
	
    }
	

}
