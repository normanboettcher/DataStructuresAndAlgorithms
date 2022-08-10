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
        //head = new DoublyNode();
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

    private void traverse() {
        if(head != null) {
            DoublyNode tmpNode = head;
            for(int i = 0; i < size; i++) {
                System.out.print(tmpNode.value);
                if(i != size - 1) {
                    System.out.print(" -> ");
                }
                DoublyNode tmpRef = (DoublyNode) tmpNode.reference;
                tmpNode = tmpRef;
            }
            System.out.println("");
        } else {
            LOG.warning("Object does not exists");
        }
    }

    private void reverseTraverse() {
        if(head != null) {
            DoublyNode tmpNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tmpNode.value);
                if(i != size - 1) {
                    System.out.print(" <- ");
                }
                tmpNode = tmpNode.prev;
            }
        } else {
            LOG.warning("Object doesnt exists");
        }
        System.out.println("");
    }

    private void search(int value) {
        if(head == null) {
            LOG.warning("No Object");
        } else {
            DoublyNode tmpNpode = head;
            if(head.value == value) {
                System.out.println("Found node " + tmpNpode + " with value " + value);
                return;
            }
            DoublyNode node = (DoublyNode) tmpNpode.reference;
            for (int i = 0; i < size; i++) {
                if(i == size - 1) {
                    LOG.warning("No node found with value "+ value);
                    return;
                }
                if(node.value == value) {
                    System.out.println("Found node " + node + " with value " + value);
                    return;
                }

                node = (DoublyNode) node.reference;
            }
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.createDLL(1);
        LOG.info("Created Doubly Linked List with current head : " + String.valueOf(dll.head.value));
        dll.add(2, 0);
        dll.add(3,1);
        dll.add(3,7);
        LOG.info("New head of Doubly Linked List: " + dll.head.value);
        dll.traverse();
        dll.reverseTraverse();

        dll.search(2);
        dll.search(1);
        dll.search(100);
        dll.search(3);
    }
}
