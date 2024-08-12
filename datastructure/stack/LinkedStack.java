import java.util.NoSuchElementException;

public class LinkedStack implements Stack{
    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;

    @Override
    public void push(int element) {
        head = new Node(element, head);
    }

    @Override
    public int pop() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        int data = head.data;
        head = head.next;
        
        return data;
    }

    @Override
    public int peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        
        return head.data;
    }

    @Override
    public int size() {
        int size = 0;
        Node node = head;
        
        while (node != null){
            node = node.next;
            size++;
        }

        return size;
    }
    
    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();
    
        stack.push(1);
        System.out.println("top : " + stack.peek());
        stack.push(2);
        System.out.println("top : " + stack.peek());
        stack.push(3);
        System.out.println("top : " + stack.peek());
        stack.push(4);
        System.out.println("top : " + stack.peek());
        stack.push(5);
        System.out.println("top : " + stack.peek());
        stack.pop();
        System.out.println("top : " + stack.peek());
        stack.pop();
        System.out.println("top : " + stack.peek());
        stack.pop();
        System.out.println("top : " + stack.peek());
        stack.pop();
        System.out.println("top : " + stack.peek());
        stack.pop();
    }
}
