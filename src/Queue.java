import java.util.EmptyStackException;

public class Queue {
    LinkedList linkedList = new LinkedList();

    public Queue() {
        linkedList = new LinkedList();
    }

    public Queue(int x) {
        linkedList = new LinkedList(new Node(x));
    }

    public void add(int x) {
        Node head = linkedList.getHead();
        Node tail = linkedList.getTail();
        if (head == null || tail == null) {
            linkedList.setHead(new Node(x));
            linkedList.setTail(linkedList.getHead());
//            System.out.println("It was null, set head to " + x);
            return;
        }
        linkedList.getTail().next = new Node(x);
        linkedList.incrementTail();
//        System.out.println("Added " + x);
    }

    public void remove() {
        Node head = linkedList.getHead();
        linkedList.setHead(head.next);
    }

    public int peek() {
        if (linkedList.getHead() == null) {
//            System.out.println("Cannot peek at top of stack when stack size is 0");
            throw new EmptyStackException();
        }
        return (linkedList.getHead().x);
    }

    public boolean isEmpty() {
        return (linkedList.getHead() == null);
    }

    public void Print() {
        Node current = linkedList.getHead();
        if (current == null) {
            System.out.println("null");
            return;
        }
        while (current != null) {
            System.out.println(current.x);
            current = current.next;
        }
    }


}
