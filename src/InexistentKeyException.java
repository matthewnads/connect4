/**
 * InexistentKeyException method for when there is no key found in hashtable 
 * Used in remove method in Dictionary class 
 * @author Shanker Nadarajah
 *
 */
public class InexistentKeyException extends RuntimeException{
	public InexistentKeyException (String msg) {
		super(msg);
	}
}
