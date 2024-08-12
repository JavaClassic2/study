public class ArrayStack implements Stack{
    private int[] datas;
    private int capacity;
    private int incrementSize;
    private int index;

    public ArrayStack (int capacity, int incrementSize) {
        if (capacity < 0 || incrementSize < 0) {
            throw new IllegalArgumentException();
        }
    
        this.capacity = capacity;
        this.datas = new int[capacity];
        this.incrementSize = incrementSize;
        this.index = -1;

    }
    public ArrayStack(int capacity) {
        this(capacity, 10);
    }
    
    public ArrayStack() {
        this(10, 10);
    }

    @Override
    public void push(int element) {
        if (size() == capacity) {
            // this.capacity += incrementSize;
            int[] newArray = new int[capacity += incrementSize];
            System.arraycopy(datas, 0, newArray, 0, size());
            this.datas = newArray;
        }

        datas[++index] = element;
    }

    @Override
    public int pop() {
        if (size() < 0) {
            throw new ArrayIndexOutOfBoundsException("stack이 비었음");
        }

        return datas[index--];
    }

    @Override
    public int peek() {
        if (size() < 0) {
            throw new ArrayIndexOutOfBoundsException("stack이 비었음");
        }
        
        return datas[index];
    }

    @Override
    public int size() {
        return index + 1;
    }

    public static void main(String[] args) {
        Stack stack = new ArrayStack(3, 1);
    
        stack.push(1);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.push(2);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.push(3);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.push(4);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.push(5);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
    }
    
}
