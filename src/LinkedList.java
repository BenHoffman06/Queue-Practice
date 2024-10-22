public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public LinkedList(Node n) {
        this.head = n;
        this.tail = head;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void incrementTail() {
        tail = tail.next;
    }

    public void setTail(Node t) {
        tail = t;
    }

    public void setHead(Node n) {
        head = n;
    }

    public void append(int x) {
        // If list is empty
//        System.out.println("Running append. head: " + head + "\ntail: " + tail);
        if (head == null) {
            head = new Node(x);
            tail = head;
            return;
        }
        if (tail == null) {
//            System.out.println("Tail is null");
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            tail = currentNode;
        }
        tail.next = new Node(x);
        tail = tail.next;
    }

    public void appendList(LinkedList L) {
        Node currentNode = L.head;
        while (currentNode != null) {
            append(currentNode.x);
            currentNode = currentNode.next;
        }
    }

    public LinkedList(LinkedList l) {
        // Make head.player a deep copy of l.head.player
        if (l.head == null) {
            return;
        }
        this.head = new Node(l.head.x);

        // Set currentNode to l.head
        Node currentNode = l.head;

        // Loop: while currentNode.next != null
        while (currentNode != null) {
            // append currentNode.data
            // set currentNode = currentNode.next
            append(currentNode.x);
            currentNode = currentNode.next;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = this.head;
        while (currentNode != null) {
            sb.append(currentNode.x);
            sb.append(" -> ");
            currentNode = currentNode.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public int length() {
        Node currentNode = head;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }


    /**
     * returns LinkedList without everything after i'th index
     */
    public LinkedList cutFromIndex(int i) {
        LinkedList cutList = new LinkedList(this);

        int count = 0;
        Node current = cutList.getHead();

        while (count < i - 1) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Cannot cut from index " + i + " in LinkedList of length " + length());
            }
            current = current.next;
            count++;
        }
        current.next = null;
        tail = current;
        return cutList;
    }

}
