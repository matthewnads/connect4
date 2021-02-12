/**
 * Node class used for Dictionary implementation 
 * @author Shanker Nadarajah
 *
 * @param <T>
 */
public class Node<T> {
	private Node<T> next; 
	private T data; 
	
	/**
	 * Constructor for new empty node
	 */
	public Node() {
		next = null;
		data = null; 
	}
	
	/**
	 * Constructor for node with value
	 * @param value
	 */
	public Node(T value) {
		next = null;
		data = value; 
	}
	
	/**
	 * returns next value for node 
	 * @return
	 */
	public Node<T> getNext() {
		return next; 
	}
	/**
	 * sets the next value for node
	 * @param node
	 */
	public void setNext(Node<T> node) {
		next = node;
	}
	
	/**
	 * returns value in node 
	 * @return
	 */
	
	public T getData() {
		return data; 
	}
	/**
	 * sets the data in node 
	 * @param value
	 */
	public void setData(T value) {
		data = value; 
	}
}
