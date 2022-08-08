package linkedList;

import java.util.logging.Logger;

/**
 * @author norman
 */
public class DoublyLinkedList {
    private static final Logger LOG = Logger.getLogger(DoublyLinkedList.class.getSimpleName());

    DoublyNode head;
    DoublyNode tail;
    int size;

    /**
     *
     * @param nodeValue
     * @return
     */
    private DoublyNode createDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        newNode.reference = null;
        newNode.prev = null;
        head= newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    /**
     *
     * @param location
     */
    private void add(int nodeValue,int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if(head==null) {
            createDLL(nodeValue);
            return;
        } else if(location == 0) {
            newNode.reference = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        } else if(location >= size) {
            newNode.reference = null;
            tail.reference = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while(index < location - 1) {
                tempNode = (DoublyNode) tempNode.reference;
                index++;
            }
            newNode.prev = tempNode;
            newNode.reference = tempNode.reference;
            tempNode.reference = newNode;
            DoublyNode newNodeRef = (DoublyNode) newNode.reference;
            newNodeRef.prev = newNode;
        }
        size++;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.createDLL(1);
        LOG.info("Created Doubly Linked List with current head : " + String.valueOf(dll.head.value));
        dll.add(2, 0);
        dll.add(3,1);
        dll.add(3,7);
        LOG.info("New head of Doubly Linked List: " + dll.head.reference.value);
    }
}
