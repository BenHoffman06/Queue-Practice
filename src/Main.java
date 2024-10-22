import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();

        System.out.print("Is empty: " + q.isEmpty());

        // Setup
        q.add(1);
        q.Print();
        q.add(5);
        q.add(10);
        q.add(12);
        q.add(20);
        q.add(72);
        System.out.println("\nOriginal q: ");
        q.Print();

        // Test q.remove
        q.remove();
        System.out.println("\nq after q.remove: ");
        q.Print();

        // Test mirror(q)
        mirror(q);
        System.out.println("\nMirror output:");
        q.Print();
    }

    public static void mirror(Queue q) {
        // Add all elements in q to r (queue) and s (stack)
        Queue r = new Queue();
        Stack s = new Stack();
        int current;
        while (!q.isEmpty()) {
            current = q.peek();
            q.remove();
            r.add(current);
            s.push(current);
        }
        current = r.peek();

        // Copy over r data into q
        while (true) {
            try {
                current = r.peek();
            } catch (EmptyStackException e) {
                break;
            }
            q.add(current);
            r.remove();
        }
        // Then add all elements in stack to q
        current = s.peek();
        while (true) {
            try {
                s.peek();
//                System.out.println("s.peek: " + s.peek());
            } catch (EmptyStackException e) {
                break;
            }
            current = s.pop();
            q.add(current);
        }
//        r.Print();
        q = r;
    }
}

