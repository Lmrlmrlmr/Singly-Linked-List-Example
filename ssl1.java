package ssl1;

public class ssl1 {
	static class Node{
		int elem;
		Node next;
	}
	
	Node head;
	Node tail;
	int size;

	/**
	 *  add() adds an integer to the end of the list. 
	 * @param e the intended number to be added.
	 * @return whether or no the number was added to the list. 
	 */
	public boolean add(int e){
		Node newNode = new Node();
		newNode.elem = e;
		newNode.next = null;
		
		if(head == null){
			head = newNode;
			size++;
			return true;
		}
		
		Node n = head;
		
		if(n.elem == e){
			return false;
		}
		
		while(n.next !=null){
			n = n.next;
			if(n.elem == e){
				return false;
			}
		}
		
		n.next = newNode;
		size++;
		
		return true;
	}
	
	/**
	 * Removes the elemen if a match is found. 
	 * @param e the integer that is being searched for. 
	 * @return
	 */
	public boolean remove(int e){
		if(head==null){return false;}
		
		Node curr = head;
		
		if(curr.elem == e){
			head = head.next;
			size--;
			return true;
		}
		
		Node previous = curr;
		curr = curr.next;
		
		while(curr != null){
			if(curr.elem == e){
				previous.next = curr.next;
				size--;
				return true;
			}
			previous = curr;
			curr = curr.next;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return the size of the singly linked list. 
	 */
	public int size(){
		return size;
	}
	
	public boolean equals(Object obj){
		if(obj == null) return false;
		if(!(obj instanceof ssl1)){return false;}
		
		ssl1 list = (ssl1)obj;
		
		if(this.size != list.size) return false;
		Node curr1 = this.head;
		Node curr2 = list.head;
		
		for(int i = 0; i < this.size; i++){
			if(curr1.elem != curr2.elem){ return false;}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		
		return true;
		
	}
}
