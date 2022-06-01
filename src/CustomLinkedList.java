public class CustomLinkedList {


    // initially the Node's head and tail are null
    static Node head = null, tail = null;
    static int size = 0;

    CustomLinkedList(){
        head = new Node();
        head = null;
    }


    CustomLinkedList(Object data){
        // this is an empty list, so the reference to the head node is set to a new node with data
        head = new Node(data);
        size = 1;
    }





    public static boolean isEmpty(){
        if (head == null) //if the tail is null then the stack has to be empty
            return true;
        return false;
    }

    public static void addNode(Object data){
        //first create a new node
        Node newNode = new Node(data);

        //if the list is empty, have the head and tail point to the newNode
        if (isEmpty()) {
            size = 0;
            head = newNode;
            tail = newNode;
            //the previous of the head will be null, as will the next for the tail
//            head.previous = null;
            tail.next = null;
        } else{
            //add the new node to the end of the list
            tail.next = newNode;
//            newNode.previous = tail;
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

    public static void removeNode(){
        if (isEmpty()){
            System.out.println("You cannot remove a node in an empty list.");
            return;
        }
        size--;
        if(head == tail){
            head = null;
            tail = head;
            return;
        }
//        tail = tail.previous; //make the second to last the last element
        Node p = head;
        while(p.next != tail){ //iterate through the list until you find the second to last node
            p = p.next;
        }
        tail = p; //now set tail to the second to last node
        tail.next = null; //make the node after the tail be null
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


    //a way to print all of the nodes
    public void printList(){

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

    public static int size(){
        return size;
    }


    public static void main(String[] args) {
//        CustomLinkedList myList = new CustomLinkedList();
        CustomLinkedList myList = new CustomLinkedList(5);

        System.out.println("Is my list empty? " + myList.isEmpty());

        System.out.println("Size of list: " + myList.size());
        myList.removeNode();

        myList.printList();
        System.out.println(myList.peekFirst());
        System.out.println(myList.peekLast());

        myList.addNode("Hello");
        myList.addNode('F');
        myList.addNode(32);
        myList.addNode(42.000001);
        myList.addNode(false);
        myList.printList();

        myList.search(32);


        System.out.println(myList.peekFirst());
        System.out.println(myList.peekLast());

        System.out.println("Size of list: " + myList.size());
        System.out.println("Print out list: ");
        myList.printList();

        while(!myList.isEmpty()) {
            System.out.println("Removing a node...");
            myList.removeNode();
            System.out.println(myList.peekLast());
        }

        System.out.println("Size of list: " + myList.size());
        System.out.println("Print out list: ");
        myList.printList();
        myList.search(32);
    }

}
