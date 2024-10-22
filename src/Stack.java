import java.util .*;


public class Stack {
    Node head;
    //create a constructor for the stack
    public Stack() {
        this.head = null;
    }
    public Stack(int n) {
        this.head = new Node(n);
    }
    //create a push method
    public void push(int n) {
        Node newNode = new Node(n);
        newNode.next = head;
        head = newNode;

    }
    //create a pop method
    public int pop() {
        int value = peek();
        head = head.next;
        return value;
    }
    // create a peek method
    public int peek() {
        if (head == null) {
            throw new EmptyStackException();
        }
        return head.x;
    }
    //create isEmpty to return true if the stack is empty or false otherwise
    public boolean isEmpty() {
        return head == null;
    }
    //create Print method to print the content of the stack without destroying it
    public void print() {
        // but we can only use pop(), peek(), and push()
        int value;
        Stack reversed = new Stack();
        while (!isEmpty()) {
            // Store it, print it push it to another stack, then pop
            value = pop();
            System.out.print(value + ", ");
            reversed.push(value);
        }
        // Loop again to reverse back the stack
        while (!reversed.isEmpty()) {
            value = reversed.pop();
            this.push(value);
        }
        System.out.println();
    }
}
