package rockPaperScissors;

public class MatchScore {
	
	public char userInput; 
	public char computerInput; 
	public int result; 
	
	public MatchScore(int A, char userSymbol, char computerSymbol){
		computerInput = computerSymbol;
		userInput = userSymbol; 
		result = A; 
	}

}
