import java.util.Random;

public class Wizard extends Adventurer{
    private int Mana;

    public Wizard(){
	this("Tim");
    }
    
    public Wizard(String name){
	this(name, 20);
    }
    
    public Wizard(String name, int mana){
	super(name, 25, 8, 10, 25);
	this.setMana(mana);
    }

    //wizard methods

    public void Attack(Adventurer other){
	Random r = new Random();
	System.out.println(this + " attacks " + other);
	if(hit(other)){
	    int damage = r.nextInt(4) + 1;
	    other.setHP(other.getHP() - damage);
	    System.out.println(" and deals " + damage + " damage!");
	}else{
	    System.out.println(" but missed!");
	}
	setMana(getMana()+1);
    }
    
    public void SpecialAttack(Adventurer other){
	Random r = new Random();
	if(getMana() >= 10){
	    System.out.println(this + " hurls a ball of fire at " + other);
	    if(hitMagic(other)){
		int damage = 2 + r.nextInt(getINT())+r.nextInt(getINT());
		other.setHP(other.getHP()-damage);
		System.out.println(" and ignites him for " + damage+" damage!");
	    }else{
		System.out.println(" but instead hits an innocent bystander!");
	    }
	    setMana(getMana()-2);
	}else{
	    System.out.println(this + " doesn't have enough Mana");
	}
    }

    //get methods

    public int getMana(){
       return Mana;
    }

    public String getStats(){
	return super.getStats() + " Mana  " + getMana();
    }

    
    //set methods

    public void setMana(int Mana){
	this.Mana = Mana;
    }
    
    public void defaultStats(){
	this.setHP(25);
	this.setMana(20);
	this.setLife(true);
    }

    
}
