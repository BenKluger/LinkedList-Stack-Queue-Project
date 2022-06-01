public class CustomQueue extends CustomLinkedList{

    public static boolean contains(Object o){
        if(CustomQueue.search(o) != -1) //-1 means it doesn't exist there
            return true;
        return false;
    }

    public static boolean add(Object o){
       try {
           CustomQueue.addNode(o);
           return true; // this should always return true, because there are no space limits
       } catch(Exception e){
           System.out.println("Element add failed.");
           return false;
        }
    }

//    public static boolean offer(Object o){    } //Not needed

    public static Object remove() throws Exception { //remove() throws an exception if it is empty
        try {
            Object queueHead = head.data;

            if (size() == 1) {
                removeNode(); //this will just remove the one element
            } else if (size() > 1) {
                head = head.next; //set the head equal to element number 2, so the head is now gone
                size--;
            }


            return queueHead; //return the previous head
        } catch (Exception e){
            throw new Exception("This is an empty Queue!");
        }


    }

    public static Object poll(){ //poll returns null if it is empty
        if (isEmpty()){
            System.out.println("This is an empty queue.");
            return null;
        }


        Object queueHead = head.data;

        if(size() == 1){
            removeNode(); //this will just remove the one element
        }
        else if (size() > 1){
            head = head.next; //set the head equal to element number 2, so the head is now gone
            size--;
        }


        return queueHead; //return the previous head

    }

    public static Object element() throws Exception{ //throws an exception if it is empty
        try {
            return head.data;
        } catch (Exception e){
            throw new Exception("This stack is empty.");
        }
    }

    public static Object peek(){ // returns null if it is empty
        if (isEmpty()){
            System.out.println("This is an empty queue.");
            return null;
        }

        return head.data;
    }



    /////////////////////////////////////////////////////////////MAIN METHOD FOR TESTING////////////////////////
//    public static void main(String[] args) throws Exception {
//        CustomQueue myQueue = new CustomQueue();
//
////        System.out.println("This should throw an exception, cannot remove from an empty list: " + myQueue.remove()); //commenting out bc it throws an error
//        System.out.println("This should return null, because it is an empty list: " + myQueue.poll());
////        System.out.println("This should throw an exception, it is an empty list: " + myQueue.element()); //commenting out bc it throws an error
//        System.out.println("This should return null, because it is an empty list: " + myQueue.peek());
//
//        myQueue.add(5);
//        myQueue.add(32.234);
//        myQueue.add("Hello!");
//        myQueue.add("UwU");
//        myQueue.add('X');
//        myQueue.add(true);
//
//        myQueue.printList();
//        System.out.println("Size of queue: " + myQueue.size());
//
//        System.out.println("Peeking head: " + myQueue.peek());
//        System.out.println("Polling head: " + myQueue.poll());
//        System.out.println("Element head: " + myQueue.element());
//        System.out.println("Removing head: " + myQueue.remove());
//        System.out.println("Peeking head: " + myQueue.peek());
//
//        while (!myQueue.isEmpty()){
//            System.out.println("Polling queue: " + myQueue.poll());
//        }
//
//        myQueue.printList();
//        System.out.println("Size of queue: " + myQueue.size());
//
//    }
}
