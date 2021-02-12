/**
 * Data class for data objects used to store keys, score and levels for each board configuration 
 * @author Shanker Nadarajah
 *  
 */
public class Data {
	private String key; 
	private int score; 
	private int level; 
	
	/**
	 * constructor for the class, initializes the instance variables 
	 * @param key
	 * @param score
	 * @param level
	 */
	public Data(String key, int score, int level) {
		this.key = key; 
		this.score = score; 
		this.level = level; 
	}
	/**
	 * returns key in data object
	 * @return
	 */
	public String getKey() {
		return key;
	}
	/**
	 * returns score in data object
	 * @return
	 */
	public int getScore() {
		return score;
	}
	/**
	 * returns level in data object
	 * @return
	 */
	public int getLevel() {
		return level; 
	}

}
