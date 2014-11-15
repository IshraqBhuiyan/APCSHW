import java.util.Random;

public class Wizard extends Adventurer{
    private int Mana;
    private Random rand = new Random();

    public Wizard(){
	this("Tim");
    }
    
    public Wizard(String name){
	this(name, 20);
    }
    
    public Wizard(String name, int mana){
	super(name, 20, 0, 0, 10);
	this.setMana(mana);
    }

    //wizard methods


    public void SpecialAttack(Adventurer other){
	int damage = rand.nextInt(5) + this.getINT() / 2;
	if(super.hit(other, 5)){
	    other.setHP(other.getHP() - damage);
	    this.setMana(this.getMana() - 2);
	    System.out.println(this.getName() + " hit " + other.getName() + " and did " + damage + " damage");
	}else{
	    System.out.println(this.getName() + " missed " + other.getName());
	}
	System.out.println(this.getStats());
	System.out.println(other.getStats());
    }

    //get methods

    public int getMana(){
       return Mana;
    }

    
    //set methods

    public void setMana(int Mana){
	this.Mana = Mana;
    }


    
}
