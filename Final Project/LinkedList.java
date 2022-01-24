/* 
 * Execution: LinkedList
 * 
 * create a linked list class that implements the list interface
 * for a generic type 
 */

public class LinkedList<T> implements List<T> {
    
    public class Node {
        public T value;
        public Node next; 
        
        /* 
         * Constructor: creates a single node that contains a generic type value
         * and points to another node
         */
        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
            
        }
        
        /* 
         * Constructor: creates a single node that contains a generic type value 
         */
        public Node(T value) {
            this.value = value;
            next = null;
        }
        
    }

    
    public int numItems;
    public Node head;
    /*
     * constructor: creates linked list with one node
     */
    public LinkedList(Node n) {
        head = n; 
        numItems = 0;
    }
    /*
     * constructor: creates empty linked list
     */
    public LinkedList() {
        head = null;
        numItems = 0;
    }
    
    
    
    /* input: a generic type 
     * output: boolean (always true)
     * 
     * description: adds a node at the end of the list
     */
    public boolean add(T x) {
        
        Node added = new Node(x);
        
        if (head == null) {
            head = added;
            numItems++; 
            return true;
        }
        
        else {
            Node current = head;
            while (current != null) {
                
                if (current.next == null) {
                    current.next = added;
                    break;
                } 
                current = current.next;
            }
            
            numItems++;
            return true;
        }
        
    }
    
    /*input: index position and genereic type
     * output: boolean 
     * 
     * description: add a new node with type x at a specific index
     */
    public boolean add(int index, T x) { 
        if (head == null && index == 0) {
            head = new Node(x); 
            numItems++;
            return true;  
        }
        
        if (index > numItems || index < 0) {
            throw new IllegalArgumentException("Idx is impossible value");
        }
        
        if (index == 0) {
            Node added = new Node(x, head); 
            head = added; 
            numItems++; 
            return true; 
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            
            if (current.next == null) {
                current.next = new Node(x);
            } else {
                current = current.next;
            }
            
        }
        
        current = new Node(x, current);
        numItems++;
        return true;
    }
    /* input: none 
     * output: int
     * description: tells you how many items are in the linked list
     */
    public int size() {
        return numItems;
    }
    
    /* input: int
     * output: <T>
     * description: return the element at the specified index
     */
    public T get(int index) {
        
        if (index >= numItems || index < 0) {
            throw new IllegalArgumentException("Idx is impossible value");
        }
        
        if (head == null) {
            throw new RuntimeException("list is empty");
        }
        
        Node current = head;
        
        for (int i = 0; i < index; i++) {
            current = current.next;
            
        }
        
        if (current.value == null) {
            return null;
        }
        
        else {
            return current.value; 
        }
    }
    
    /* input: int, <T>
     * output: <T>
     * description: replace the object at the specified index, returning
     * the replaced object
     */
    public T set(int index, T x) {
        if (index >= numItems || index < 0) {
            throw new IllegalArgumentException("Idx is impossible value");
        }
        if (head == null) {
            throw new RuntimeException("No elements to return");
        }
        
        
        Node current = head; 
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        current.value = x; 
        return current.value; 
    }
    
    /* input: int
     * output: <T>
     * description: remove the object at the specified index and return it 
     */
    public T remove(int index) {
        if (head == null) {
            throw new RuntimeException("No elements to return");
        }
        
        if (index > numItems || index < 0) {
            throw new IllegalArgumentException("Idx is impossible value");
        }
        
        if (index == 0) {
            T object = head.value; 
            head = head.next; 
            numItems--;
            return object; 
        }
        
        Node current = head; 
        Node previous = head; 
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }
        
        T object = current.value;
        previous.next = current.next;
        numItems--;
        return object; 
    }
    
    /* input: none
     * output: boolean
     * description: checks if list is empty
     */
    public boolean isEmpty() {
        if (numItems == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /* input: <T>
     * output: boolean
     * description: check whether the list contains the given element
     */
    public boolean contains(T element) {
        boolean elementExists = false;
        while (head != null) {
            if (head.value == element) {
                elementExists = true;
                break; 
            }
            head = head.next;
        }
        return elementExists;
    }
    
    /* input: <T>
     * output: int 
     * description: return the first index of the specified element
     */
    public int indexOf(T element) {
        int thisIndex = 0;
        for (Node current = head; current != null; current = current.next) {
            if (current.value == element) {
                return thisIndex;
            }
            thisIndex++;
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        
        /*LinkedList<String> test = new LinkedList<String>();
        
        test.add(0, "a");
        //test.add(0, "b");
        System.out.println(test.get(test.numItems));
        
        for (int i = 0; i < test.numItems; i++) {
            System.out.print(test.head.value);
            test.head = test.head.next;
        }
        */
    }
    
}