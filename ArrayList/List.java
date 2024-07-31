public interface List<T> extends Iterable<T>{
    void add(T item);
    T get(int index);
    void remove(int index);
    void clear();
    int size();
    boolean isEmpty();
}