/**
 * Evaluate class implements all auxiliary methods needed by algorithm to play the board game
 * @author Shanker Nadarajah
 * 
 *
 */
public class Evaluate {
	//gameBoard is a double array of characters representing the board
	//tilesNeeded is number of adjacent or diagonal pieces (X's and O's) to win 
	//maxLevels is essentially the difficulty of the game (computer will look x levels ahead)
	private char[][] gameBoard; 
	private int tilesNeeded; 
	
	/**
	 * Evaluate class initalizes the board with empty spots,
	 * and initializes the instance variables
	 * @param boardRows
	 * @param boardColumns
	 * @param tilesNeeded
	 * @param maxLevels
	 */
	public Evaluate (int boardRows, int boardColumns, int tilesNeeded, int maxLevels) {
		//initializing the game board with 'g' to represent an empty gameboard of set dimensions 
		gameBoard = new char[boardRows][boardColumns]; 
		for (int i=0; i<gameBoard.length;i++) {
			for (int j=0; j<gameBoard[i].length ;j++) {
				gameBoard[i][j]='g';
			}
		}
		this.tilesNeeded = tilesNeeded; 
	}
	/**
	 * Initializes dictionary for the hashtable implementation 
	 * @return
	 */
	public Dictionary createDictionary() {
		return new Dictionary(9973); 
	}
	
	/**
	 * repeatedConfig returns the gameboard if it is present in the dictionary
	 * @param dict
	 * @return string representing the board or null if not present
	 */
	public Data repeatedConfig(Dictionary dict) {
		//first we convert the game board into a string 
		String board = ""; 
		for (int i=0; i<gameBoard.length;i++) {
			for (int j=0; j<gameBoard[i].length ;j++) {
				board += gameBoard[i][j]; 
			}
		}
		//then we use the get method to return the Data object if it is present (or null if not)
		return dict.get(board); 
	}
	
	/**
	 * insertConfig method stores the game board into the dictionary
	 * @param dict
	 * @param score
	 * @param level
	 */
	public void insertConfig(Dictionary dict, int score, int level) {
		//first we turn the board into a string representation
		String board = ""; 
		for (int i=0; i<gameBoard.length;i++) {
			for (int j=0; j<gameBoard[i].length ;j++) {
				board += gameBoard[i][j]; 
			}
		}
		//then we turn it into a data object and store it 
		Data data = new Data(board, score, level); 
		dict.put(data); 
	}
	
	
	/**
	 * storePlay method changes a character in the gameboard array 
	 * This changes a tile based on input 
	 * @param row
	 * @param col
	 * @param symbol
	 */
	public void storePlay(int row, int col, char symbol) {
		gameBoard[row][col] = symbol; 
	}
	
	/**
	 * squareIsEmpty method returns true if the tile is empty, or false if its occupied 
	 * @param row
	 * @param col
	 * @return boolean 
	 */
	public boolean squareIsEmpty (int row, int col) {
		if (gameBoard[row][col] == 'g')
			return true;
		else 
			return false;
	}
	
	/**
	 * tileOfComputer method checks if computer is occupying a tile 
	 * @param row
	 * @param col
	 * @return true if computer is occupying, false if not
	 */
	public boolean tileOfComputer (int row, int col) {
		if (gameBoard[row][col] == 'o')
			return true;
		else 
			return false; 
	}
	/**
	 * tileOfHuman method checks if human player is occupying a tile or not 
	 * @param row
	 * @param col
	 * @return true if occupied, false if not 
	 */
	public boolean tileOfHuman(int row, int col) {
		if (gameBoard[row][col] == 'o') 
			return true;
		else 
			return false; 
	}
	
	/**
	 * This method checks to see if a given player (signified by symbol) is in a winning position
	 * Checks by finding adjacent or diagonal matching pieces, need tilesNeeded amount in a row to win 
	 * @param symbol
	 * @return true if win, false if no win 
	 */
	public boolean wins (char symbol) {
		//Check rows first 
		for(int i=0; i<gameBoard.length;i++){
			
			for (int j=0;j<=gameBoard[i].length-tilesNeeded;j++) {
				if(symbol==gameBoard[i][j]) {
					int counter = 1; //counter is the number of like tiles (need tilesNeeded amount to win)
					for(int x=1;x<tilesNeeded;x++) {
						if(gameBoard[i][j+x]==symbol)
							counter++;
					}
					if (counter>=tilesNeeded)
						return true; 
				}
			}
		}
		
		//Check columns, if rows to not reveal a win 
		for(int i=0; i<=gameBoard.length-tilesNeeded;i++) {
			for(int j=0; j<gameBoard[i].length;j++) {
				if(symbol == gameBoard[i][j]) {
					int counter=1;
					for(int x=1; x<tilesNeeded;x++) {
						if(gameBoard[i+x][j]==symbol)
							counter++;
					}
					if (counter>=tilesNeeded)
						return true; 
				}
			}
		}
		
		//Check diagonals last if there is no win in columns or row 
		for(int i=0;i<=gameBoard.length-tilesNeeded;i++) {
			for(int j=0; j<gameBoard[i].length;j++) {
				//Find matching character 
				if(gameBoard[i][j]==symbol) {
					
					//check right diagonal
					if(gameBoard.length-j>=tilesNeeded) {
						int counter =1; 
						for(int x=1;x<tilesNeeded;x++) {
							if(gameBoard[i+x][j+x]==symbol)
								counter++;
						}
						if (counter>=tilesNeeded)
							return true;
					}
					//check left diagonal
					if (j>=tilesNeeded-1) {
						int counter =1;
						for (int x=1; x<tilesNeeded; x++) {
							if(gameBoard[i+x][j-x]==symbol)
								counter++;
						}
						if(counter>=tilesNeeded)
							return true; 
					}
				}
			}
		}
		//return false if all 3 cases do not return true
		return false; 
	}
	/**
	 * isDraw method checks to see if there are any empty spaces in the board
	 * If no empty spaces, we have a draw
	 * @return returns true if there are no empty spaces, false if there are. 
	 */
	public boolean isDraw() {
		for (int i=0; i<gameBoard.length;i++) {
			for (int j=0; j<gameBoard[i].length ;j++) {
				if (gameBoard[i][j]=='g')
					return false;
			}
		}
		return true; 
	}
	/**
	 * Assigns a score (integers 0-3) based off of outcome of board
	 * 3 if computer wins, 2 if draw, 1 if no outcome, 0 if human wins
	 * @return
	 */
	public int evalBoard() {
		//Check computer wins
		if(wins('o'))
			return 3;
		else if(wins('b'))
			return 0;
		else if (isDraw())
			return 2; 
		else
			return 1;
	}
}
