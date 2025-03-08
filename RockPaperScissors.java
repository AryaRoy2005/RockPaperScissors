package rockPaperScissors;
import java.util.Scanner; 

public class RockPaperScissors {
	
	Scanner s = new Scanner(System.in); 
	private Player A; 
	private Tracker scoreCard; 
	private int matchCount = 0; 
	private char userInput; 
	private char computerInput; 
	private int userScore=0; 
	private int computerScore=0; 
	
	public void play() {
		
		welcomePlayer(); 
		
		A = new Player(); 
		
		scoreCard = new Tracker(); 
		
		printInstructions(); 
		
		while(matchCount<scoreCard.totalMatches()) {
			playMatch(); 
			matchCount++; 
		}
		
		printResult(); 
		
	}
	
	private void printResult() {
		System.out.println("\n\nFINAL TALLY");
		System.out.println(A.name+": "+userScore);
		System.out.println("Computer: "+computerScore);
		
		System.out.println("\n");
		
		if(userScore>computerScore) {
			System.out.println("You WON!!! CONGRATULATIONS!!!");
		}else if(userScore==computerScore) {
			System.out.println("TIE");
		}else {
			System.out.println("You LOST. Better luck next time :)");
		}
		
		scoreCard.results(A.name) ;
	}
	
	public void takeInputs() {
		System.out.print("\nEnter your choice: ");
		userInput = s.next().charAt(0); 
		while(userInput!='R'&&userInput!='S'&&userInput!='P') {
			System.out.println("Sorry, please choose between Rock(R), Paper(P), Scissors(S)");
			userInput = s.next().charAt(0); 
		}
		
		int temp = (int)(Math.random()*(3-1+1)+1); 
		if(temp==1) {
			computerInput = 'R'; 
		}else if(temp==2) {
			computerInput = 'P'; 
		}else{
			computerInput = 'S'; 
		}
	}

	private void playMatch() {
		
		int result; 
		takeInputs();
		while(userInput==computerInput) {
			System.out.println("Did you think that was a good move? Well, so did the computer. Choose again");
			takeInputs(); 
		}
		
		System.out.print(A.getName()+": ");
		printSymbol(userInput); 
		System.out.print("Computer: ");
		printSymbol(computerInput); 
		
		if(userWon()) {
			System.out.println("Congrats, you won that one!");
			result = 1; 
		}else {
			result = 0; 
			System.out.println("Sorry, you lost this one");
		}
		
		scoreCard.updateScores(result, userInput, computerInput); 
		
		if(result==1) {
			userScore++; 
		}else {
			computerScore++; 
		}
	}

	private void printSymbol(char Ch) {
		if(Ch=='R') {
			System.out.println("Rock");
		}else if(Ch=='P') {
			System.out.println("Paper");
		}else {
			System.out.println("Scissors");
		}
	}

	private boolean userWon() {
		char A = userInput; 
		char B = computerInput; 
		if(A=='R'&&B=='S') {
			return true; 
		}else if(A=='S'&&B=='P') {
			return true; 
		}else if(A=='P'&&B=='R') {
			return true; 
		}
		return false;
	}

	private void welcomePlayer() {
		System.out.println("Hello, and WELCOME to Rock Paper Scissors!!!\n\nIn this game, you'll be competing against the computer in a game of rock paper scissors.\nDon't worry, its completely fair(wink wink!)\n\n");

	}
	
	private void printInstructions(){
		System.out.println("\nWhen it's your turn, enter your choice using the menu below.\nR = Rock\nP = Paper\nS = Scissors\n\nAt the end of all the matches, the final tally will decide who won. \nGOOD LUCK!!!\n\n");
	}
}
