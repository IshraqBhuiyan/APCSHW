import java.util.Random;
import java.util.Scanner;

public class Game{
    
    public static void main(String[]args){
	Random rand = new Random();
	Scanner in = new Scanner(System.in);
	Adventurer player;
	
	System.out.println("Select a class to play. \n a) Warrior \n b) Wizard \n c) Rogue");
	String ClassSelect = in.nextLine();
	while(!(ClassSelect.equals("a") || ClassSelect.equals("b") || ClassSelect.equals("c"))){
	    System.out.println("Invalid choice");
	    ClassSelect = in.nextLine();
	}

	if(ClassSelect.equals("a")){
	    player = new Warrior();
	} else if(ClassSelect.equals("b")){
		player = new Wizard();
	} else{
	    player = new Rogue();
	}

	Adventurer opponent = new Adventurer();

	System.out.println("Oh noes, an opponent has appeared: " + opponent.getStats());
	System.out.println("This is you: " + player.getStats());
	
	while(player.getHP() > 0 || opponent.getHP() > 0){
	    System.out.println("What shall you do? \n A) Attack \n B) Special Attack \n C) Surrender");
	    String choice = in.nextLine();
	    if(choice.equals("A")){
		if(rand.nextBoolean()){
		    player.Attack(opponent);
		    if(opponent.getHP() > 0){
			opponent.Attack(player);
		    }
		}else {
		    opponent.Attack(player);
		    if(player.getHP() > 0){
			player.Attack(opponent);
		    }
		}
	    }else if(choice.equals("B")){
		if(rand.nextBoolean()){
		    player.SpecialAttack(opponent);
		    if(opponent.getHP() > 0){
			opponent.SpecialAttack(player);
		    }
		}else{
		    opponent.SpecialAttack(player);
		    if(player.getHP() > 0){
			player.SpecialAttack(opponent);
		    }
		}
	    }else if(choice.equals("C")){
		player.setHP(0);
	    }
	}
	if(player.getHP() <= 0){
	    System.out.println("You have been slain by " + opponent.getName());
	}else if(opponent.getHP() <= 0){
	    System.out.println("You have slain " + opponent.getName());
	}
    }
}
