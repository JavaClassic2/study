package list;
import java.util.NoSuchElementException;
import java.util.Stack;

class Node {
    Node next;
    int data;

    public Node(int data, Node next) {
        this.next = next;
        this.data = data;
    }

    public Node(int data) {
        this.data = data;
    }
}

public class SimpleLinkedList implements SimpleList{
    class ListIterator implements SimpleListIterator {
        private Stack<Node> prevNode;
        private Node current;

        public ListIterator() {
            prevNode = new Stack<>();
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public int next() {
            prevNode.push(current);
            current = current.next;

            return prevNode.peek().data;
        }

        @Override
        public boolean hasPrevious() {
            return prevNode != null;
        }

        @Override
        public int previous() {
            int data = current.data;
            current = prevNode.pop();

            return data;
        }

        @Override
        public void remove() {
            Node prev = prevNode.pop();
            prev.next = current.next;
            current = prev;
        }

    }

    private Node head;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node node = head;
        while (node.next != null) {
            node = node.next;
        }

        node.next = new Node(data);
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("삭제할 요소가 없습니다.");
        }

        int data = head.data;
        head = head.next;

        return data;
    }

    @Override
    public int removeAt(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("입력한 index가 음수입니다.");
        }
        
        if (index > size()) {
            throw new NoSuchElementException("해당 위치에 삭제할 데이터가 없습니다.");
        }

        Node node = head;

        for (int i=0; i<index-1; i++) {
            node = node.next;
        }

        int data = node.next.data;
        node.next = node.next.next;

        return data;
    }

    @Override
    public boolean remove(int data) {
        if (isEmpty()) {
            return false;
        }

        if (head.data == data) {
            head = null;
        }

        Node node = head;

        while (node.next != null) {
            if (node.next.data == data) {
                node.next = node.next.next;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contains(int data) {
        Node node = head;

        while (node != null) {
            if (node.data == data) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        int size = 0;
        Node node = head;

        while (node != null) {
            size++;
            node = node.next;
        }

        return size;
    }

    @Override
    public SimpleListIterator iterator() {
        return new ListIterator();
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        
        Node node = head;

        if (node != null) {
            builder.append(node.data);
        }

        while (node != null) {
            builder.append(", ")
                    .append(node.data);
        }

        builder.append("]");

        return builder.toString();
    }
}
