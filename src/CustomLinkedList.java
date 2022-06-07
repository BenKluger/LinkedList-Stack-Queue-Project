public class CustomLinkedList {

    static Node head, tail;
    static int size;

    //default constructor without parameters
    CustomLinkedList(){
        head = new Node(null);
        tail = head;
    }


    //default constructor with parameters
    CustomLinkedList(Object data){
        // this is an empty list, so the reference to the head node is set to a new node with data
        head = new Node(data);
        tail = head;
        size = 1;
    }

    public static boolean isEmpty(){ // This checks if the linked list is empty
        if (size <= 0)
            return true;
        return false;
    }

    public static void push(Object data){
        //first create a new node
        Node newNode = new Node(data);

        //if the list is empty, have the head and tail point to the newNode
        if (isEmpty()) {
            size = 0;
            head = newNode;
            tail = newNode;
            tail.next = null;
        }
        else if (size == 1){
            tail.next = newNode;
            tail = newNode;
            head.next = tail;
            tail.next = null;
        }
        else{
            //add the new node to the end of the list
            tail.next = newNode;
            tail = newNode;
            tail.next = null;
        }
        size++;
    }

    public static Object peekFirst(){
        if (isEmpty()){
            System.out.println("This list is empty.");
            return null;
        }
        return head.data;
    }

    public static Object peekLast(){
        if (isEmpty()){
            System.out.println("This list is empty.");
            return null;
        }
        return tail.data;
    }

    public static Object pop(){
        if (isEmpty()){
            System.out.println("You cannot remove a node in an empty list.");
            return null;
        }
        size--;
        Node returnThis = tail;
        if(head == tail){
            head = null;
            tail = head;
            return returnThis.data;
        }
        Node p = head;
        while(p.next != tail){ //iterate through the list until you find the second to last node
            p = p.next;
        }
        tail = p; //now set tail to the second to last node
        tail.next = null; //make the node after the tail be null
        return returnThis.data;
    }

    public static int search (Object element){

        if (isEmpty()){
            System.out.println("You cannot search a node in an empty list.");
            return -1;
        }

        Node p = new Node(element);
        Node runner = head;
        int index = 0;

        while(runner != null){
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



    public void printList(){ // this prints the entire linked list

        Node current = head;

        if (isEmpty()){
            System.out.println("This list is empty.");
            return;
        }
        System.out.println("The nodes in the list are:");
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void clear(){
        head = null;
        tail = head;
        size = 0;
    }

    public static int size(){
        return size;
    }


    public static void main(String[] args) {
        CustomLinkedList myList = new CustomLinkedList(); // Empty constructor
//        CustomLinkedList myList = new CustomLinkedList(5); //constructor with data

        System.out.println("Is my list empty? " + myList.isEmpty());

        System.out.println("Size of list: " + myList.size());
        myList.printList();
        myList.pop();


        System.out.println(myList.peekFirst());
        System.out.println(myList.peekLast());

        myList.push("Hello");
        System.out.println("Deleting one off the end: " + myList.pop());
        myList.printList();
        myList.push('F');
        myList.push(32);
        myList.push(42.000001);
        myList.push(false);
        myList.printList();
        System.out.println("Is my list empty? " + myList.isEmpty());
        System.out.println("Deleting one off the end: " + myList.pop());
        myList.printList();

        myList.search(32);


        System.out.println(myList.peekFirst());
        System.out.println(myList.peekLast());

        System.out.println("Size of list: " + myList.size());
        myList.printList();

        while(!myList.isEmpty()) {
            System.out.println("Removing a node...");
            myList.pop();
            System.out.println(myList.peekLast());
        }

        System.out.println("Size of list: " + myList.size());
        System.out.println("Print out list: ");
        myList.printList();
        myList.search(32);


        ////Testing clear
        myList.push("Hello");
        myList.push('F');
        myList.push(32);
        myList.push(42.000001);
        myList.push(false);
        myList.printList();

        myList.clear();
        myList.printList();

        myList.push(42.000001);
        myList.push(false);
        myList.printList();
    }

}
