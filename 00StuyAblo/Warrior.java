import java.util.Random;

public class Warrior extends Adventurer{
    private int  rage;
    private String warcry;

    public Warrior(){
	this("Lief");
    }

    public Warrior(String name){
	this(name,"Valhalllaaaaa!!", 18);
    }

    public Warrior(String name, String warcry, int rage){
	super(name, 40, 18, 10, 10);
	setWarcry(warcry);
        setRage(rage);
    }

    //warrior methods

    public void Attack(Adventurer other){
	Random r = new Random();
	if(hit(other)){
	    int damage = r.nextInt(getSTR()/2)+1;
	    other.setHP(other.getHP()-damage);
	    setRage(getRage() + 1);
	    System.out.println(this + "attacked and hit" + other + "for " + damage + "damage!");
	}else{
	    System.out.println(this + "attacked " + other + "but sadly missed!");
	}
    }

    public void SpecialAttack(Adventurer other){
	Random r = new Random();
	if(getRage() >=10){
	    if(hit(other)){
		int damage = r.nextInt(getSTR())+4;
		System.out.println(this + " unleashes his fury upon " + other + " for " + damage + " damage!");
	    }else{
		System.out.println(this + " unleashes his rage upon  " + other + " but has terrible aim and hits a rock instead!");
	    }
	    setRage(getRage()-2);
	}else{
	    System.out.println("Oh noes, not enough rage!");
	}
    }

    //get methods

    public int getRage(){
	return rage;
    }

    public String getStats(){
	return super.getStats() + "\tRage " + this.getRage();
    }


    //set methods

    public void setRage(int i){
	i = rage;
    }
    
    public void setWarcry(String warcry){
	this.warcry = warcry;

    }

    public void defaultStats(){
	this.setHP(40);
	this.setRage(18);
	this.setLife(true);
    }
}
