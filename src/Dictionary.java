/**
 * Dictionary class for hashtable implementation 
 * @author Shanker Nadarajah 
 *
 */
public class Dictionary implements DictionaryADT {
	private int size;
	private int dataItems; 
	private Node<Data>[] hashTable; 
	
	//between 5000-10000, largest prime number is 9973
	/**
	 * Constructor for Dictionary class, initialzes hash table and sets number of items to 0
	 * @param size
	 */
	public Dictionary(int size) {
		this.size = size; 
		hashTable = new Node[size];
		dataItems = 0; 
		
	}	
	
	/**
	 * hashFunction function to turn string key of Data object into int index 
	 * polynomial hash function 
	 * @param key
	 * @param x
	 * @param size
	 * @return value, to be used as index for hash table array 
	 */
	public int hashFunction (String key, int size) {
		int k = key.length() - 1; 
		int x = 33; 
		int value = (int) key.charAt(k);
		for (int i = k-1 ; i>=0 ; i--) {
			value = (value*x + (int)key.charAt(i)) % size; 
		}
		return value; 
	}

	/**put method to add entry into hashTable 
	 * using node for separate chaining
	 * @param record
	 * @return 1 if collisions, 0 if no collisions
	 */
	
	public int put(Data record) throws DuplicatedKeyException{
		String key = record.getKey(); String target; 
		boolean collision = false; 
		int hashValue = hashFunction(key, size); 
		Node<Data> current = hashTable[hashValue]; 
		Data data; 
		//if there's a potential collision the while loop will run 
		//if there's no node already present, we skip the loop
		while(current!=null) {
			data = current.getData();
			target = data.getKey(); 
			if (target==key)
				throw new DuplicatedKeyException("Duplicated key");
			current = current.getNext(); 
			collision = true; 		
		}
		//Below will add the new node to the beginning of the linked list, and changes 
		//the array reference to the new node
		current = hashTable[hashValue]; 
		Node<Data> newNode = new Node(record); 
		newNode.setNext(current);
		hashTable[hashValue] = newNode; 
		dataItems ++; 
		
		if (collision)
			return 1;
		else 
			return 0;
	}

	/**
	 * Remove method to remove an entry in the hash table given a key 
	 * @param input 
	 */
	public void remove(String 	) throws InexistentKeyException {
		int pos = hashFunction(input, size); 
		Node<Data> current = hashTable[pos];
		Node<Data> prev = null; 
		
		//Looking for either a null value or matching key 
		while((current!=null) && !(current.getData().getKey().equals(input))) {
			prev = current; 
			current = current.getNext();
		}
		//Now current will be the node we want to remove,
		//so we get previous to point to the node next to it
		if (current == null)
			throw new InexistentKeyException("Key does not exist"); 
		else {
			if (prev !=null)
				prev.setNext(current.getNext());
			else
				hashTable[pos] = null; 
		}
		dataItems --; 
	}

	/**
	 * get method to return a Data object from the hashtable given a key
	 * @param input string 
	 * @return Data object or null if the object is not in the hashtable
	 */
	public Data get(String input) {
		int pos = hashFunction(input, size); 
		Node<Data> current = hashTable[pos]; 
		//Looking for either a null value or a matching key 
		while ((current!= null) && !(current.getData().getKey().equals(input)))
			current = current.getNext();
		if(current!=null)
			return current.getData(); 
		else 
			return null; 
	}

	/**
	 * numDataItems method to return the number of data items in the hashtable
	 * @return integer number 
	 */
	public int numDataItems() {
		return dataItems;
	}

}
