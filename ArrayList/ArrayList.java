import java.util.Iterator;

public class ArrayList implements List{
    private Object[] list;
    public int maxSize;

    public ArrayList() {
        this(50);
    }

    public ArrayList(int maxSize) {
        this.maxSize = maxSize;
        this.list = new Object[maxSize];
    }

    @Override
    public void add(Object item) {
        list[size()] = item;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size()) {
            return new IllegalArgumentException("out of bounds");
        }
        return this.list[index];
    }

    @Override
    public void remove(int index) {
        for (int i=index; i<size(); i++) {
            this.list[i] = this.list[i+1];
        }
        this.list[size()] = null;
    }

    @Override
    public void clear() {
        this.list = new Object[maxSize];
    }

    @Override
    public int size() {
        Iterator iterator = iterator();
        int size = 0;
        
        while(iterator.hasNext()) {
            iterator.next();
            size++;
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        return list[0] == null;
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator(this);
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }

        Iterator iterator = iterator();
        String s = "[ ";

        while (iterator.hasNext()) {
            s += iterator.next() +" ";
        }

        s += "]";
        
        return s;
    }
    
}
