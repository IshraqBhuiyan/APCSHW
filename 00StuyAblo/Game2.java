import java.util.Random;
import java.util.Scanner;

public class Game2{
    // Scanner in = new Scanner(System.in);

    public static Adventurer[] makeParty(){
	Scanner in = new Scanner(System.in);
	int size=0;
	while(size < 1 || size > 4){
	    System.out.println("How big will your part be? (1 to 4 members)");
	    size = in.nextInt();
	}
	Adventurer[]party = new Adventurer[size];
	for(int i=0; i<size; i++){
	    party[i]= makeCharacter();
	}
	return party;
    }

    public static Adventurer makeCharacter(){
	Scanner in = new Scanner(System.in);
	Adventurer player=null;
	String name = "";
	while(name.equals("")){
	    System.out.println("Enter the name of the character");
	    name = in.nextLine();
	}
	String choice="";
	while(!(choice.equals("A") || choice.equals("B") || choice.equals("C"))){
	    System.out.println("Choose:\nA:Warrior\nB:Wizard\nC:Rogue");
	    choice = in.nextLine();
	}
	if(choice.equals("A")){
	    player = new Warrior(name);
	}else if(choice.equals("B")){
	    player = new Wizard(name);
	}else if(choice.equals("C")){
	    player = new Rogue(name);
	}
	return player;
    }

    public static Adventurer makeboss(){
	Random r = new Random();
	int choice = r.nextInt(3);
	Adventurer boss= null;
	if(choice == 0){
	    boss = new Warrior("Enraged Lief");
	    boss.setHP(100);
	    //	    boss.setRage(36);
	    boss.setSTR(30);
	}else if(choice == 1){
	    boss = new Wizard("Angry Merlin");
	    boss.setHP(75);
	    // boss.setMana(40);
	    boss.setINT(30);
	}else if(choice == 2){
	    boss = new Rogue("Ferocious Samurai");
	    boss.setHP(90);
	    // boss.setStamina(45);
	    boss.setSTR(28);
	}
	return boss;
    }

    public static boolean deadParty(Adventurer[] party){
	boolean life = true;
	for(int i=0;i<party.length;i++){
	    if(party[i].Alive()){
		life = false;
	    }
	}
	return life;
    }

    public static void combat(Adventurer[] party, Adventurer boss){
	System.out.println("Oh myyyy! A boss has appeared" + boss.getStats());
	while(!deadParty(party) && boss.Alive()){
	    Random r = new Random();
	    System.out.println("The members of your party that are still alive are:");
	    int alive = 0;
	    for(int i=0; i<party.length;i++){
		if(party[i].Alive()){
		    System.out.println(party[i]);
		    alive++;
  		}
	    }
	    Adventurer[] living = new Adventurer[alive];
	    int counter = 0;
	    for(int i=0;i<party.length;i++){
		if(party[i].Alive()){
		    living[counter]=party[i];
		    counter++;
		}
	    }
	    for(int i=0; i<living.length;i++){
		if(boss.Alive()){
		    if(r.nextInt(3)<1){
			if(r.nextInt(4) == 0){
			    boss.SpecialAttack(living[i]);
			}else{
			    boss.Attack(living[i]);
			}
			if(living[i].Alive()){
			    Scanner in = new Scanner(System.in);
			    String choice = "";
			    while(!choice.equals("A") && !choice.equals("B") && !choice.equals("C")){
				System.out.println("Choose what " + living[i] + "shall do: \nA:Attack\nBSpecialAttack\nC:Surrender");
				choice = in.nextLine();
			    }
			    if(choice.equals("A")){
				living[i].Attack(boss);
			    }else if(choice.equals("B")){
				living[i].SpecialAttack(boss);
			    }else if(choice.equals("C")){
				living[i].setHP(0);
			    }
			}

		    }else{
			Scanner in = new Scanner(System.in);
			String choice ="";
			while(!choice.equals("A") && !choice.equals("B") && !choice.equals("C")){
			    System.out.println("Choose what " + living[i] + "shall do: \nA:Attack\nBSpecialAttack\nC:Surrender");
			    choice = in.nextLine();
			}
			if(choice.equals("A")){
			    living[i].Attack(boss);
			}else if(choice.equals("B")){
			    living[i].SpecialAttack(boss);
			}else if(choice.equals("C")){
			    living[i].setHP(0);
			}
			if(boss.Alive()){
			    if(r.nextInt(4) == 0){
				boss.SpecialAttack(living[i]);
			    }else{
				boss.Attack(living[i]);
			    }
			}
		    }
		    if(living[i].Alive()){
		    }
		    if(!boss.Alive()){
		    }
		    System.out.println( living[i].getStats());
		    System.out.println(boss.getStats());
		}
	    }
	}
	if(deadParty(party)){
	    System.out.println("You have lost!");
	}else if(!boss.Alive()){
	    System.out.println("You won the battle!");
	}
    }

    public static void fightAgain(Adventurer[] party){
	Scanner in = new Scanner(System.in);
	String choice = "";
	while(!choice.equals("Yes")&&!choice.equals("No")){
	    System.out.println("Would you like to fight another boss? Yes, No?");
	    choice = in.nextLine();
	}
	if(choice.equals("Yes")){
	    for(int i=0; i<party.length; i++){
		party[i].defaultStats();
	    }
	    Adventurer boss = makeboss();
	    combat(party, boss);
	    fightAgain(party);
	}else{
	    System.out.println("Bye. Press enter to leave");
	    in.nextLine();
	}
    }
    
    public static void main(String[]args){
	Adventurer[] party = makeParty();
	Adventurer boss = makeboss();
	combat(party, boss);
	fightAgain(party);
    }
}
