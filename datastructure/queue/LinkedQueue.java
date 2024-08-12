import java.util.NoSuchElementException;

public class LinkedQueue implements Queue{
    class Node {
        Node prev;
        Node next;
        int data;
        
        public Node(int data) {
            this.data = data;
        }

        public Node (int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
    Node in;
    Node out;
    int size;

    @Override
    public void enqueue(int element) {
        size++;

        if (in == null) {
            in = new Node(element);
            out = in;
            return;
        }

        in = in.prev = new Node(element, in);
    }

    private boolean isEmpty() {
        return out == null;
    }

    private int size() {
        return size;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int data = out.data;
        out = out.prev;
        size--;

        return data;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return out.data;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        Node node = out;
        while (node != in) {
            builder.append(node.data).append(", ");
            node = node.prev;
        }

        builder.append(node.data).append("]");

        return builder.toString();
    }
    
    public static void main(String[] args) {
        int capacity = 10;
        
        LinkedQueue queue = new LinkedQueue();
        System.out.println("queue : " + queue);

        for (int i=0; i<10; i++) {
            queue.enqueue(i);
            System.out.printf("enqueue(%d) : %s%n", i, queue);
        }
        
        for (int i=0;i<capacity/2; i++) {
            queue.dequeue();
            System.out.printf("dequeue() : %s%n", queue);

        }

        for (int i=0; i<capacity/2; i++) {
            queue.enqueue(i);
            System.out.printf("enqueue(%d) : %s%n", i, queue);
        }
    }
}
