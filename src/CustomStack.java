public class CustomStack {

    static Node head, tail;
    static int size;

    //default constructor without parameters
    CustomStack(){
        head = new Node(null);
        tail = head;
    }


    //default constructor with parameters
    CustomStack(Object data){
        // this is an empty stack, so the reference to the head node is set to a new node with data
        head = new Node(data);
        tail = head;
        size = 1;
    }

    public static boolean isEmpty(){ // This checks if the stack is empty
        if (size <= 0)
            return true;
        return false;
    }

    public static void push(Object data){
        //first create a new node
        Node newNode = new Node(data);

        //if the stack is empty, have the head and tail point to the newNode
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
            //add the new node to the end of the stack
            tail.next = newNode;
            tail = newNode;
            tail.next = null;
        }
        size++;
    }

    public static Object peekFirst(){
        if (isEmpty()){
            System.out.println("This stack is empty.");
            return null;
        }
        return head.data;
    }

    public static Object peek(){
        if (isEmpty()){
            System.out.println("This stack is empty.");
            return null;
        }
        return tail.data;
    }

    public static Object pop(){
        if (isEmpty()){
            System.out.println("You cannot remove a node in an empty stack.");
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
        while(p.next != tail){ //iterate through the stack until you find the second to last node
            p = p.next;
        }
        tail = p; //now set tail to the second to last node
        tail.next = null; //make the node after the tail be null
        return returnThis.data;
    }

    public static int search (Object element){

        if (isEmpty()){
            System.out.println("You cannot search a node in an empty stack.");
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



    public void printStack(){ // this prints the entire linked list

        Node current = head;

        if (isEmpty()){
            System.out.println("This stack is empty.");
            return;
        }
        System.out.println("The nodes in the stack are:");
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

        CustomStack myStack = new CustomStack();
//        CustomStack myStack = new CustomStack(15);

        myStack.printStack();
        myStack.size();

        myStack.push(69);
        myStack.printStack();
        myStack.size();
        System.out.println("Popping the 69 off: " + myStack.pop());

        myStack.push(999);
        myStack.push('H');
        myStack.push("Hello");
        myStack.push(true);
        myStack.push(56.4);

        myStack.printStack();
        myStack.pop();
        myStack.size();
        myStack.clear();
        myStack.printStack();
        myStack.pop();
        myStack.size();

    }

}
