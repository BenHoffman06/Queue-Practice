public class Node {

    public int x;
    public Node next;

    public Node(int x){
        this.x = x;
    }

    public void setint(int x) {
        this.x = x;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public String toString() {
        return String.valueOf(x);
    }
}
