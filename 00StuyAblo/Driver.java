public class Driver{
    public static void main(String[]args){
	Adventurer p1 = new Adventurer();
	Adventurer p2 = new Adventurer("Lancelot");

	Warrior p3 = new Warrior();
	
	System.out.println(p1.getname());
	System.out.println(p2.getname());
	System.out.println(p3.getname());
	System.out.println(p3.getHP());
    }
}