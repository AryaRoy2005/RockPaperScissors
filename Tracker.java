package rockPaperScissors;
import java.util.Scanner; 

import java.util.ArrayList;

public class Tracker {
	
	Scanner s = new Scanner(System.in); 
	private ArrayList<MatchScore> scoreHistory; 
	private int n; 
	
	public Tracker() {
		System.out.print("No. of matches to be played (Best of how many?): ");
		n = s.nextInt(); 
		scoreHistory = new ArrayList<MatchScore>(); 
	}

	public int totalMatches() {
		return n;
	}

	public void updateScores(int result, char userSymbol, char computerSymbol) {
		MatchScore curr = new MatchScore(result, userSymbol, computerSymbol);
		scoreHistory.add(curr); 
	}

	public void results(String name) {
		System.out.println("\n\nGame History: ");
		
		for(int i = 0; i<n; i++) {
			System.out.print(name+": "+scoreHistory.get(i).userInput+";  Computer: "+scoreHistory.get(i).computerInput+";   ");
			if(scoreHistory.get(i).result==1) {
				System.out.println(name+" WON");
			}else {
				System.out.println("Computer WON");
			}
		}
		
	}

}
