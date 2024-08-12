import java.util.NoSuchElementException;

public class ArryaQueue implements Queue{
    int capacity;
    int[] arr;
    int head;
    int tail;

    public ArryaQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        
        this.capacity = capacity;
        this.arr = new int[capacity];
    }
    
    public ArryaQueue() {
        this(10);
    }

    @Override
    public void enqueue(int element) {
        if (head == capacity && tail == 0) {
            throw new RuntimeException("큐가 꽉 참");
        }

        if (head == capacity) {
            head = 0;
        }

        arr[head++] = element;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (tail + 1 == capacity) {
            tail = 0;
        }

        return arr[tail++];
    }

    @Override
    public int peek() {
        return tail;
    }

    public int size() {
        if (head > tail) {
            return head - tail;
        }

        return capacity - tail + head;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[ ");


        if (head > tail) {
            for (int i = tail; i<head; i++) {
                builder.append(arr[i]).append(" ");
            }
        } else {
            for (int i=tail; i<capacity; i++) {
                builder.append(arr[i]).append(" ");
            }
            
            for (int i=0; i<head; i++) {
                builder.append(arr[i]).append(" ");
            }
        }

        builder.append("]");

        return builder.toString();
    }
    
    public static void main(String[] args) {
        int capacity = 10;
        
        ArryaQueue queue = new ArryaQueue(10);
        System.out.println("queue : " + queue);

        for (int i=0; i<10; i++) {
            queue.enqueue(i);
            System.out.printf("enqueue(%d) : %s%n", i, queue);
            System.out.printf("head : %d, tail : %d, capacity : %d, size : %d%n%n"
                            , queue.head, queue.tail, queue.capacity, queue.size());
        }
        
        for (int i=0;i<capacity/2; i++) {
            queue.dequeue();
            System.out.printf("dequeue() : %s%n", queue);
            System.out.printf("head : %d, tail : %d, capacity : %d, size : %d%n%n"
                            , queue.head, queue.tail, queue.capacity, queue.size());

        }

        for (int i=0; i<capacity/2; i++) {
            queue.enqueue(i);
            System.out.printf("enqueue(%d) : %s%n", i, queue);
            System.out.printf("head : %d, tail : %d, capacity : %d, size : %d%n%n"
                            , queue.head, queue.tail, queue.capacity, queue.size());
        }
    }
}