/**
 * 
 * @author Shanker Nadarajah
 * DuplicatedKeyException class to throw exception when we have two entries with the same keys in hashtable 
 *
 */
public class DuplicatedKeyException extends RuntimeException{
	public DuplicatedKeyException (String msg) {
		super(msg); 
	}
}
