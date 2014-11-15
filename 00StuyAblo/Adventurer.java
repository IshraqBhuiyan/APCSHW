import java.util.Random;

public abstract class Adventurer{
    private String name;
    private int HP, STR, DEX, INT;
    private boolean life; //tells you if player is alive or not

    private Random rand = new Random();

    public Adventurer(){
	this("Lester");
    }
    
    public Adventurer(String name){
	this(name, 30, 10, 10, 10);
    }

    public Adventurer(String name, int HP, int STR, int DEX, int INT){
	this.setName(name);
	this.setHP(HP);
	this.setSTR(STR);
	this.setDEX(DEX);
	this.setINT(INT);
	life = true;
    }

    //toString method

    public String toString(){
	return this.getName() + " " + this.getHP();
    }

    //Adventurer Class Actions

    public boolean hit(Adventurer other){
	Random r = new Random();
	double chance = 0.15 + .75*((double)getDEX() / other.getDEX() * 10)/(getDEX()+other.getDEX());
	//System.out.println(chance);
	return r.nextDouble()<chance;  

    }

    public boolean hitMagic(Adventurer other){
	Random r = new Random();
	double chance = 0.15 + .75*((double)getINT() / other.getINT() * 10)/(getINT()+other.getINT());
	//System.out.println(chance);
	return r.nextDouble()<chance;
    }

    public abstract void Attack(Adventurer other);

    public abstract void SpecialAttack(Adventurer other);

    public abstract void defaultStats();

    //Get Methods
    public String getName(){
	return name;
    }

    public int getHP(){
	return HP;
    }


    public int getSTR(){
	return STR;
    }

    public int getDEX(){
	return DEX;
    }

    public int getINT(){
	return INT;
    }

    public String getStats(){
	return this.getName() + 
	    "\tHP " + this.getHP() +
	    "\tSTR " + this.getSTR() +
	    "\tDEX " + this.getDEX() +
	    "\tINT " +this.getINT() ; 
    }

    //Set Methods

    public void setHP(int health){
	this.HP = health;
    }

    public void setSTR(int strength){
	this.STR = strength;
    }

    public void setDEX(int dexterity){
	this.DEX = dexterity;
    }

    public void setINT(int intelligence){
	this.INT = intelligence;
    }

    public void setName(String s){
	this.name = s;
    }
    
    //these 3 functions determine whether a player is alive or not
    public void setLife(boolean b){
	this.life = b;
    }

    public boolean getLife(){
	return life;
    }

    public boolean Alive(){
	if(!getLife()){
	    return false;
	}
	if(getHP()<= 0){
	    System.out.println(this + " has died!");
	    setLife(false);
	}
	return getLife();
    }

}
