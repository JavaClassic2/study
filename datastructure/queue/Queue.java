public interface Queue {
    void enqueue(int element);
    int dequeue();
    int peek();
}