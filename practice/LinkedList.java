// Define a Node class to represent a node in the linked list
class Node {
    int data;
    Node next;
    // Constructor to initialize a new node with given data
    public Node(int data) {
        this.data = data;
    }
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

// Define a LinkedList class with methods for common operations
public class LinkedList {

    /**
     * Converts an array into a linked list.
     *
     * @param arr The input array to be converted.
     * @return The head of the resulting linked list, or null if the input array is empty.
     */
    static Node convertToLL(int[] arr) {
        // Check if the input array is empty
        if (arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node mover = head; 
        // Iterate through the rest of the array and append elements to the linked list
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            mover.next = newNode;
            mover = newNode;
        }
        return head;
    }

    /**
     * Traverses a linked list and prints its elements.
     *
     * @param head The head of the linked list to be traversed.
     * @return The head of the linked list (unchanged).
     */
    static Node traverseLL(Node head) {
        Node traverse = head;
        // Iterate through the linked list and print each element
        while (traverse != null) {
            System.out.print(traverse.data + " ");
            traverse = traverse.next;
        }
        return head;
    }

    /**
     * Deletes the head of a linked list.
     *
     * @param head The head of the linked list.
     * @return The new head of the linked list after deletion, or null if the list was empty.
     */
    static Node deleteHead(Node head) {
        if (head == null) {
            return head;
        }
        // Update the head to the next node, effectively deleting the current head
        head = head.next;
        return head;
    }

    /**
     * Deletes the tail of a linked list.
     *
     * @param head The head of the linked list.
     * @return The head of the linked list after deletion, or null if the list had one or zero nodes.
     */
    static Node deleteTail(Node head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        // Find the second-to-last node
        while (temp.next.next != null) {
            temp = temp.next;
        }
        // Update the next pointer of the second-to-last node to null, effectively deleting the tail
        temp.next = null;
        return head;
    }

    /**
     * Deletes the kth node from a linked list.
     *
     * @param head The head of the linked list.
     * @param k The position of the node to be deleted (1-indexed).
     * @return The head of the linked list after deletion.
     */
    static Node deleteKth(Node head, int k) {
        if (head == null) {
            return head;
        }
        // Handle the case where k is 1 (delete the head)
        if (k == 1) {
            return head.next;
        }
        int cnt = 0;
        Node temp = head;
        Node prev = null;
        // Traverse the linked list until we reach the kth node
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    /**
     * Deletes the first occurrence of a given element from a linked list.
     *
     * @param head The head of the linked list.
     * @param ele The element to be deleted.
     * @return The head of the linked list after deletion.
     */
    static Node deleteEle(Node head, int ele) {
        if (head == null) {
            return null;
        }
        // Handle the case where the head contains the element to be deleted
        if (head.data == ele) {
            return head.next;
        }
        Node temp = head;
        Node prev = null;
        // Traverse the linked list until we find the element to be deleted
        while (temp != null) {
            if (temp.data == ele) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    
    static Node insertAtHead(Node head, int data) {
        return new Node(data, head);
    }

    static Node insertAtTail(Node head, int data) {
        if(head == null) {
            return new Node(data);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
        return head;
    }
    
    static Node insertAtKthElement(Node head, int k, Node newNode) {
        if (head == null) {
            if (k == 1) {
                return newNode;
            } else {
                return null;
            }
        }
        if (k == 1) {
            newNode.next = head;
            return newNode;
        }
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            if (cnt == k - 1) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    
    static Node insertEleBeforeValue(Node head, int ele, int value) {
        if (head == null) {
            return null;
        }
        if (head.data == value) {
            return new Node(ele, head);
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == value) {
                Node newNode = new Node(ele);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // Example usage:
        // Node head = traverseLL(convertToLL(arr));

        // traverseLL(deleteHead(convertToLL(arr)));

        // traverseLL(deleteTail(convertToLL(arr)));

        // traverseLL(deleteKth(convertToLL(arr), 3));

        // traverseLL(deleteEle(convertToLL(arr), 4));

        // Node head = insertAtHead(convertToLL(arr), 0);
        // traverseLL(head);

//        Node head = insertAtTail(convertToLL(arr), 6);
//        traverseLL(head);

//        Node head = insertAtKthElement(convertToLL(arr), 6, new Node(6));
//        traverseLL(head);
        
        Node head = insertEleBeforeValue(convertToLL(arr), 6, 6);
        traverseLL(head);
        
    }
}