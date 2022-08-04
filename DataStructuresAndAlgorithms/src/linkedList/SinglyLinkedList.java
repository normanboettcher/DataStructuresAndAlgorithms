package linkedList;

public class SinglyLinkedList {
	public Node head;
	public Node tail;
	
	public int size; 
	
	public Node createSinglyLinkedList(int value) {
		head = new Node();
		Node node = new Node();
		node.reference = null;
		node.value = value;
		head = node;
		tail = node;
		size = 1;
		return head;
	}
	
	// Insert Method SinglyLinkedList
	public void insertInLinkedList(int nodeValue, int location) {
		///New node we would like to insert
		Node node = new Node();
		node.value = nodeValue;
		//check if a singlylinkedlist object is already given
		if(head == null) {
			createSinglyLinkedList(nodeValue);
			return;
		} else if (location == 0) {
			//if we want to insert the node as a new head, change with current head
			node.reference = head;
			head = node;
		} else if (location >= size) {
			//if the node is a new tail, change tail and new node.
			//also give reference of null to the new tail.
			node.reference = null;
			tail.reference = node;
			tail = node;
		} else {
			//If we want to insert in the middle, store the head as temporal node
			Node tmpNode = head;
			int index = 0;
			//loop over the index until we reach the given location
			while(index < location -1) {
				//in each iteration, update the temporal node with node after temporal node
				tmpNode = tmpNode.reference;
				index++;
			}
			//next Node is the reference of the last node from while loop
			Node nextNode = tmpNode.reference;
			tmpNode.reference = node; 
			node.reference = nextNode;
		}
		size += 1;
	}
	
	public void traverse() {
		if (head == null) {
			System.out.println("No Object found.");
		} else {
			Node tmpNode = head;
			for(int i = 0; i < size; i++) {
				System.out.print(tmpNode.value);
				if (i != size - 1) {
					System.out.print("->");
				}
				tmpNode = tmpNode.reference;
			}
		}
		System.out.println("\n");
	}
	
	boolean search(int nodeValue) {
		Node tmpNode;
		if(head != null) {
			tmpNode = head;
			for(int i = 0; i < size; i++) {
				if(tmpNode.value == nodeValue) {
					System.out.println("Found node " + nodeValue +
							" at location: " + (i + 1) + "\n");
					return true;
				}
				tmpNode = tmpNode.reference;
			}
		}
		System.out.println("Node " + nodeValue + " not found.");
		return false;
	}
	
	public void deletion(int location) {
		if(head != null) {
			if(location == 0) {
				head = head.reference;
				size --;
				if(size == 0) {
					tail = null;
				}
			} else if (location >= size) {
				Node tmpNode = head;
				for(int i = 0; i < size - 1; i++) {
					tmpNode = tmpNode.reference;
				}
				if(tmpNode == head) {
					tail = head = null;
					size--;
					return;
				}
				tmpNode.reference = null;
				tail = tmpNode;
				size--;
			} else {
				Node tmpNode = head;
				for(int i = 0; i < location - 1; i++) {
					tmpNode = tmpNode.reference;
				}
				tmpNode.reference = tmpNode.reference.reference;
				size--;
			}
		} else {
			System.out.println("Node not found.");
			return;
		}
	}
	
	public void deleteList() {
		head = null;
		tail = null;
		System.out.println("SinglyLinkedList deleted successfully");
	}
	
	public static void main(String[] args) {
		SinglyLinkedList sLL = new SinglyLinkedList();
		sLL.createSinglyLinkedList(5);
		System.out.println(sLL.head.value);
		
		sLL.insertInLinkedList(6, 1);
		sLL.insertInLinkedList(7, 3);
		sLL.insertInLinkedList(8, 2);
		sLL.insertInLinkedList(10, 4);
		sLL.insertInLinkedList(9, 5);
		System.out.println(sLL.head.value);
		sLL.traverse();
		sLL.insertInLinkedList(100, 4);
		sLL.traverse();
		sLL.search(100);
		sLL.search(50);
		sLL.search(9);
		
		sLL.deletion(3);
		sLL.traverse();
		sLL.deleteList();
		sLL.traverse(); 
	}

}
