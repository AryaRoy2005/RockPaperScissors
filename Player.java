package rockPaperScissors;
import java.util.Scanner;

public class Player {
	
	String name; 
	Scanner s = new Scanner(System.in); 
	
	public Player() {
		System.out.print("Enter name of player: ");
		name = s.next(); 
	}
	
	public void editName(String newName) {
		name = newName; 
	}

	public String getName() {
		return name; 
	}

}
