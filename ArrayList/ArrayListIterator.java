import java.util.Iterator;

public class ArrayListIterator implements Iterator{
    private ArrayList list;
    private int index;

    public ArrayListIterator(ArrayList list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.get(index+1) != null;
    }

    @Override
    public Object next() {
        return list.get(index++);
    }
    
}
