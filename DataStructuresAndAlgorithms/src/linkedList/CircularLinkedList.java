package linkedList;

public class CircularLinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	private Node createCSLL(int nodeValue) {
		head = new Node();
		Node node = new Node();
		node.value = nodeValue;
		node.reference = node;
		head = node;
		tail = node;
		size = 1;
		return head;
	}
	
	private void insert(int location, int nodeValue) {
		Node newNode = new Node();
		newNode.value = nodeValue;
		if(head == null) {
			System.out.println("No Object Found.");
			return;
		}
		
		if(location == 0) {
			newNode.reference = head;
			head = newNode;
			tail.reference = newNode;
		} else if(location >= size) {
			tail.reference = newNode;
			tail = newNode;
			tail.reference = head;
		} else {
			Node tmpNode = head;
			int index = 0;
			while(index < location - 1) {
				tmpNode = tmpNode.reference;
				index++;
			}
			newNode.reference = tmpNode.reference;
			tmpNode.reference = newNode;
		}
		size++;
	}
	
	private void traverse() {
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
	
	private boolean search(int nodeValue) {
		if(head == null) {
			System.out.println("Object not found");
		} else {
			Node tmp = head;
			for(int i = 0; i < size; i++) {
				if(tmp.value == nodeValue) {
					System.out.println("Found node at location : " + i);
					return true;
				}
				tmp = tmp.reference;
			}
		}
		System.out.println("Node " + nodeValue + " not found");
		return false;
	}
	
	
	public static void main(String[] args) {
		CircularLinkedList csll = new CircularLinkedList();
		csll.createCSLL(5);
		System.out.println(csll.head.value);
		System.out.println(csll.head.reference.value);
		csll.insert(0, 4);
		System.out.println(csll.head.value);
		csll.insert(7, 7);
		System.out.println(csll.tail.value);
		csll.traverse();
		csll.search(5);
		csll.search(100);
	}
}
