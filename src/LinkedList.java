///*TO REMOVE
// * THIS IS NOT USED ANYMORE 
// * Class was made during early stages of project and replaced with just Node class 
// */
//public class LinkedList<T> {
//	private Node<T> front; 
//	private int count; 
//	
//	public LinkedList() {
//		front = null; 
//		count = 0; 
//	}
//	
//	
//	public void insert(Node<T> newNode, Node<T> predecessor) {
//		if(predecessor == null) {
//			newNode.setNext(front);
//			front = newNode; 
//		} else {
//			Node<T> succ = predecessor.getNext();
//			newNode.setNext(succ);
//			predecessor.setNext(newNode);
//		}
//		count++;
//	}
//	
//	public boolean remove(Node<T> nodeToDelete) {
//		Node<T> current, predecessor; 
//		current = front; 
//		predecessor = null; 
//		while((current!=null)&& (current!=nodeToDelete)) {
//			predecessor = current;
//			current= current.getNext(); 
//		}
//		if (current==null) return false; 
//		else {
//			if (predecessor !=null)
//				predecessor.setNext(current.getNext());
//			else 
//				front=front.getNext();
//			count--;
//			return true;
//		}
//		
//	}
//	
//	
//}
