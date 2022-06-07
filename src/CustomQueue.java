public class CustomQueue{
    static Node head, tail;
    static int size;

    //default constructor without parameters
    CustomQueue() {
        head = new Node(null);
        tail = head;
    }


    //default constructor with parameters
    CustomQueue(Object data) {
        // this is an empty list, so the reference to the head node is set to a new node with data
        head = new Node(data);
        tail = head;
        size = 1;
    }

    public static boolean isEmpty() { // This checks if the queue is empty
        if (size <= 0)
            return true;
        return false;
    }

    public static void enqueue(Object data) {
        //first create a new node
        Node newNode = new Node(data);

        //if the list is empty, have the head and tail point to the newNode
        if (isEmpty()) {
            size = 0;
            head = newNode;
            tail = newNode;
            tail.next = null;
        } else if (size == 1) {
            tail.next = newNode;
            tail = newNode;
            head.next = tail;
            tail.next = null;
        } else {
            //add the new node to the end of the list
            tail.next = newNode;
            tail = newNode;
            tail.next = null;
        }
        size++;
    }

    public static Object peek() {
        if (isEmpty()) {
            System.out.println("This queue is empty.");
            return null;
        }
        return head.data;
    }

    public static Object peekLast() {
        if (isEmpty()) {
            System.out.println("This queue is empty.");
            return null;
        }
        return tail.data;
    }

    public static Object dequeue() {
        if (isEmpty()) {
            System.out.println("You cannot remove a node in an empty queue.");
            return null;
        }

        Node returnThis = head;
        if(size == 1){
            size--;
            head = null;
            tail = head;
            return returnThis.data;
        }
        size--;
        head = head.next; //shift it over to the head
        return returnThis.data;
    }

    public static int search(Object element) {

        if (isEmpty()) {
            System.out.println("You cannot search a node in an empty queue.");
            return -1;
        }

        Node p = new Node(element);
        Node runner = head;
        int index = 0;

        while (runner != null) {
            if (runner.data.equals(element)) {
                System.out.println("The element " + element + " is at index: " + index);
                return index;
            }

            index++;
            runner = runner.next;
        }
        System.out.println("The element " + element + " is not here.");
        return -1;
    }


    public void printQueue() { // this prints the entire queue

        Node current = head;

        if (isEmpty()) {
            System.out.println("This queue is empty.");
            return;
        }
        System.out.println("The nodes in the queue are:");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void clear() {
        head = null;
        tail = head;
        size = 0;
    }

    public static int size() {
        return size;
    }


    public static void main(String[] args){
        CustomQueue myQueue = new CustomQueue();
//        CustomQueue myQueue = new CustomQueue(123213);
        System.out.println("Dequeue 1: " + myQueue.dequeue());
        myQueue.printQueue();


        myQueue.enqueue(5);
        myQueue.printQueue();
        System.out.println("Dequeue 2: " + myQueue.dequeue());
        myQueue.printQueue();
        System.out.println(myQueue.peek());
        myQueue.enqueue(32.234);
        myQueue.enqueue("Hello!");
        myQueue.enqueue("UwU");
        myQueue.enqueue('X');
        myQueue.enqueue(true);


        System.out.println("Size of queue: " + myQueue.size());

        System.out.println("Dequeue 3: " + myQueue.dequeue());

        System.out.println("Size of queue: " + myQueue.size());
        System.out.println("Peeking head: " + myQueue.peek());

        myQueue.clear();
        myQueue.printQueue();
        System.out.println("Size of queue: " + myQueue.size());

    }
    
}