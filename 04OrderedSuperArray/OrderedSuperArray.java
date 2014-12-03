public class OrderedSuperArray extends SuperArray{

    public OrderedSuperArray(){
	this(10);
    }

    public OrderedSuperArray(int len){
	super(len);
    }

    public boolean add(int index, Object O){
	add(Object O);
    }

    public boolean add(Object O){
	int place = 0;
	while(super.get(place).compareTo(O) < 0){
	    place++;
	}
	super.add(place,O);
    }

    public Object set(int index, Object O){
	set(Object O);
    }

    public Object set(Object O){

    }

}
