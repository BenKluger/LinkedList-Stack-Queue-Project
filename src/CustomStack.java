////import jdk.internal.icu.text.UnicodeSet;
//
//public class CustomStack{
//
//    CustomStack(){
//        CustomLinkedList myStack = new CustomLinkedList();
//    }
//
//    public static void push(Object data){
//        myStack.addNode(data);
//
//    }
//
//    public static Object pop(){
//        try {
//            Object topElement = tail.data; //grabs the top
//            removeNode(); //deletes the top
//            return topElement; //returns the previous top
//        } catch (Exception e){
//            System.out.println("The stack is empty. You cannot pop.");
//            return null;
//        }
//    }
//
//    public static Object peek(){
//        try{
//        return tail.data; //grabs the top
//        } catch (Exception e){
//            System.out.println("The stack is empty. You cannot peek.");
//            return null;
//        }
//    }
//
//
//
//
//
//
//
//
//    public static void main(String[] args) {
//        CustomStack myStack = new CustomStack();
//        myStack.push(5);
//        myStack.push(10.234);
//        myStack.push("Hi!!!");
//        myStack.push('.');
//        myStack.push(42);
//        myStack.push(false);
//
//        System.out.println(myStack.size());
//        myStack.printList();
//
//        System.out.println("peek " + myStack.peek());
//        System.out.println("pop " + myStack.pop());
//        System.out.println("peek " + myStack.peek());
//        System.out.println("Searching for index... should be == 1 " + myStack.search(10.234));
////        System.out.println(myStack.head.data);
////        System.out.println(myStack.tail.data);
//
//        while (!myStack.isEmpty()){
//            System.out.println("Popping element... " + myStack.pop());
//        }
//        System.out.println(myStack.size());
//        myStack.printList();
//    }
//}
