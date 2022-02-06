import java.util.*;

public class FixedCapacityStackOfStrings {

    private String[] s; // stack
    private int n = 0;  // the number of items in the stack
    
    public FixedCapacityStackOfStrings(int capacity)   {  
        s = new String[capacity];  
    }
    
    public boolean isEmpty() {  
        return n == 0;  
    } 
   
    // adding to the stack O(1)
    public void push(String item) {  

        if ( n == s.length ) {
            //stack is full
            throw new ArrayIndexOutOfBoundsException("Stack is full");  // creating an object of type ArrayIndexOutOfBoundsException
            // immediately returns (sending back) the object exception to the caller method
        }

       s[n] = item;
       n += 1;
    }  
   
    // removes from the stack O(1)
    public String pop() {

        if ( n == 0 ) {
            // stack is empty, pop is not allowed
            throw new NoSuchElementException("Stack is empty");
            // immediately returns (sending back) the object exception to the caller method
        }
        String item = s[n-1]; // save the item to return to user
        s[n-1] = null; // let garbage collector know that there 
                       //are no references to the item that was just popped
        n -= 1;
        return item;
    }

    public static void main(String[] args) {

        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(3);

        while ( !StdIn.isEmpty() ) {
            try {
                // this code might throw an exception
                stack.push(StdIn.readString());
            } catch (ArrayIndexOutOfBoundsException e1){
                // catch and handle here
                System.out.println(e1.getMessage());
            }
        }

        System.out.println("All items pushed on the stack, pop from stack");

        while ( !stack.isEmpty() ) {
            try {
                System.out.println(stack.pop());
            } catch (NoSuchElementException e2) {
                System.out.println(e2.getMessage());
            }
            
        }

        System.out.println("Stack empty");
    }
}
