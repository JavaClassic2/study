import java.util.NoSuchElementException;

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

public class SingleLinkedList {
    Node head;

    public static void main(String[] args) {
        System.out.println("========== toString Test ==========");
        toStringTest();
        System.out.println("========== get Test ==========");
        getTest();
        System.out.println("========== appendData Test ==========");
        appendDataTest();
        System.out.println("========== appendList Test ==========");
        appendListTest();
        System.out.println("========== insert Test ==========");
        insertTest();
        System.out.println("========== size Test ==========");
        sizeTest();
        System.out.println("========== sum Test ==========");
        sumTest();
        System.out.println("========== removeLast Test ==========");
        removeLastTest();
        System.out.println("========== copy Test ==========");
        copyTest();
        System.out.println("========== copyOfRange Test ==========");
        copyOfRangeTest();
        System.out.println("========== set Test ==========");
        setTest();
        System.out.println("========== swap Test ==========");
        swapTest();
        System.out.println("========== merge Test ==========");
        mergeTest();
        System.out.println("========== rotateLeft Test ==========");
        rotateLeftTest();
    }

    /**
     * 리스트의 요소들을 나열한 문자열 생성을 위한 메서드
     * @return 리스트 요소를 나열한 문자열
     */
    @Override
    public String toString() {
       if (head == null) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        
        builder.append("[");
        
        Node node = head;
        while (node != null) {
            builder.append(node.data);
            node = node.next;

            if (node != null) {
                builder.append(", ");
            }
        }

        builder.append("]");

        return builder.toString();
   }

    static void toStringTest() {
        SingleLinkedList list = new SingleLinkedList();
        System.out.println(list);

        list.head = new Node(1, new Node(2, new Node(3)));
        System.out.println(list);
    }

    /**
     * 리스트에서 i번째 요소를 반환하는 메서드
     * @param index 인덱스 번호
     * @return i번째 노드의 요소
     * @exception NullPointerException head가 null
     * @exception IndexOutOfBoundsException index가 음수이거나 index가 리스트의 사이즈보다 큼
     */
    public int get(int index) {
        if (head == null) {
            throw new NullPointerException();
        }

        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        // for (; p != null && i > 0; i--)
        Node node = head;
        for (int i=0; i<index; i++) {
            if (node == null) {
                throw new IndexOutOfBoundsException ();
            }

            node = node.next;
        }

        return node.data;
    }

    static void getTest() {
        SingleLinkedList list = new SingleLinkedList();
        list.head = new Node(1, new Node(2, new Node(3)));
        System.out.printf("list : %s%n", list);

        System.out.printf("list.get(1) : %d%n", list.get(1));
        
        try {
            System.out.printf("list.get(4) : ");
            int get4 = list.get(4);
            System.out.println(get4);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Exception : IndexOutOfBoundsException");
        }
    }

    /**
     * 리스트의 맨 뒤에 새로운 요소를 추가하는 메서드
     * @param x 추가할 요소
     */
    public void append(int x) {
        Node node = head;

        if (head == null) {
            head = new Node(x);
        }
        
        while (node != null) {
            if (node.next == null) {
                node.next = new Node(x);
                return;
            }
            
            node = node.next;
        }
    }

    static void appendDataTest() {
        SingleLinkedList list = new SingleLinkedList();
        System.out.printf("list : %s%n", list);
        
        list.append(1);
        System.out.printf("list.append(%d) : %s%n", 1, list);
        
        list.append(3);
        System.out.printf("list.append(%d) : %s%n", 3, list);
        
        list.append(2);
        System.out.printf("list.append(%d) : %s%n", 2, list);
        
        list.append(4);
        System.out.printf("list.append(%d) : %s%n", 4, list);
    }

    /**
     * 리스트에 다른 리스트의 요소들을 추가하는 메소드
     * @param list 추가될 리스트
     */
    public void append(SingleLinkedList list) {
        if (head == null) {
            head = list.head;
            return;
        } else if (list == null) {
            return;
        }
        
        Node node = head;
        Node alist = list.head;
        
        while (node.next != null) {
            node = node.next;
        }

        if (alist.next == null) {
            node.next = new Node(alist.data);
            return;
        }

        while (alist.next != null) {
            node.next = new Node(alist.data, alist.next);
            node = node.next;
            alist = alist.next;
        }
    }

    static void appendListTest() {
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();

        list1.head = new Node(1, new Node(2, new Node(3)));
        list2.head = new Node(6, new Node(5, new Node(4)));

        System.out.printf("list1 : %s%n", list1);
        System.out.printf("list2 : %s%n", list2);

        System.out.printf("%s.append(%s)%n", list1, list2);
        list1.append(list2);

        System.out.printf("list1 : %s%n", list1);
        System.out.printf("list2 : %s%n", list2);
    }

    /**
     * 리스트의 i번째에 새로운 요소를 삽입하는 메서드
     * @param i i번째에 데이터 삽입
     * @param x 삽입할 데이터
     * @excpetion IndexOutOfBoundsException 주어진 위치에 요소 삽입 불가능
     */
    public void insert(int index, int x) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (head == null) {
            if (index == 0) {
                head = new Node(x);
            } else {
                throw new IndexOutOfBoundsException();
            }

            return;
        }
        
        Node node = head;

        for (int i=0; i<index-1; i++) {
            if (node == null) {
                throw new IndexOutOfBoundsException("해당 위치에 요소를 삽입할 수 없습니다. : " + i);
            }

            node = node.next;
        }

        node.next = new Node(x, node.next);
        
        return;
    }

    static void insertTest() {
        SingleLinkedList list = new SingleLinkedList();
        System.out.printf("list : %s%n", list);
        
        System.out.printf("list.insert(%d, %d) : %n", 0, 1);
        list.insert(0, 1);
        System.out.printf("list : %s%n", list);
        
        System.out.printf("list.insert(%d, %d) : %n", 1, 3);
        list.insert(1, 3);
        System.out.printf("list : %s%n", list);
        
        System.out.printf("list.insert(%d, %d) : %n", 1, 2);
        list.insert(1, 2);
        System.out.printf("list : %s%n", list);
        
        System.out.printf("list.insert(%d, %d) : %n", 3, 4);
        list.insert(3, 4);
        System.out.printf("list : %s%n", list);
        
        try {
            System.out.printf("list.insert(%d, %d) : ", 10, 10);
            list.insert(10, 10);
            System.out.printf("list : ", list);
        } catch(IndexOutOfBoundsException ignore) {
            System.out.println("Exception : IndexOutOfBoundsException");
        }
    }

    /**
     * 리스트의 길이를 구하기 위한 메서드
     * @return 리스트의 요소 수
     */
    public int size() {
        int size = 0;

        Node node = head;
        while (node != null) {
            node = node.next;
            size++;
        }

        return size;
    }

    static void sizeTest() {
        SingleLinkedList list = new SingleLinkedList();
        System.out.printf("size(%s) = %d%n", list, list.size());

        list.append(1);
        System.out.printf("size(%s) = %d%n", list, list.size());

        list.append(2);
        System.out.printf("size(%s) = %d%n", list, list.size());
        
        list.append(3);
        System.out.printf("size(%s) = %d%n", list, list.size());
    }

    /**
     * 정수 리스트의 값을 더해 반환하는 메서드
     * @return 리스트 요소의 합
     * @exception NullPointerException 입력한 리스트가 null인 경우
     */
    public int sum() {
        if (head == null) {
            throw new NullPointerException("입력한 list가 null입니다.");
        }

        int sum = 0;

        Node node = head;
        while (node != null) {
            sum += node.data;
            node = node.next;
        }

        return sum;
    }

    static void sumTest(){
        SingleLinkedList list = new SingleLinkedList();
        list.head = new Node(1, new Node(2, new Node(3)));

        System.out.printf("sum %s : %d%n", list, list.sum());
        list.append(2);
        System.out.printf("sum %s : %d%n", list, list.sum());
        
        list.append(3);
        System.out.printf("sum %s : %d%n", list, list.sum());
        

        try {
            list = new SingleLinkedList();
            System.out.printf("sum %s : ", list);
            int sum = list.sum();
            System.out.println(sum);
        } catch(NullPointerException ignore){
            System.out.println("Error : NullPointerException");
        }
    }

    /**
     * 리스트의 마지막 노드를 삭제하는 메서드
     */
    public void removeLast() {
        Node node = head;

        if (node == null || node.next == null) {
            head = null;
            return;
        }

        while (node.next != null) {
            if (node.next.next == null) {
                node.next = null;
                return;
            }

            node = node.next;
        }
    }

    static void removeLastTest() {
        SingleLinkedList list = new SingleLinkedList();
        list.head = new Node(1, new Node(2, new Node(3)));
        System.out.printf("list : %s%n", list);
        
        list.removeLast();
        System.out.printf("removeLast : %s%n", list);
     
        list.removeLast();
        System.out.printf("removeLast : %s%n", list);
     
        list.removeLast();
        System.out.printf("removeLast : %s%n", list);
    }

    /**
     * 리스트를 복제해 새로운 리스트를 생성하는 메서드
     * @return 동일한 요소로 복제된 새로운 리스트
     */
    public SingleLinkedList copy() {
        SingleLinkedList list = new SingleLinkedList();
        Node node = head;

        while (node != null) {
            list.append(node.data);
            node = node.next;
        }

        return list;
    }

    static void copyTest() {
        SingleLinkedList list1 = new SingleLinkedList();
        list1.head = new Node(1, new Node(2, new Node(3)));
        System.out.printf("list1 : %s%n", list1);
        
        SingleLinkedList list2 = new SingleLinkedList();
        System.out.printf("list2 : %s%n", list2);
        
        list2 = list1.copy();
        System.out.printf("list2 = list1.copy : %s%n", list2);
        
        list1.append(4);
        System.out.printf("list1.append(%d)%n", 4);
        System.out.printf("list1 : %s%n", list1);
        System.out.printf("list2 : %s%n", list2);
    }

    /**
     * 리스트의 지정 범위만 복제하는 메서드
     * @param p 시작 인덱스
     * @param q 끝 인덱스
     * @return 리스트에서 p번째부터 q번째 앞까지의 노드들을 복사한 새로운 리스트
     * @exception IndexOutOfBoundsException 입력한 인덱스가 음수이거나 리스트의 길이를 초과
     */
    public SingleLinkedList copyOfRange(int p, int q) {
        SingleLinkedList result = new SingleLinkedList();
        Node node = head;

        if (node == null) {
            return result;
        }

        if (p<0 && size() < q) {
            throw new IndexOutOfBoundsException();
        }

        try {
            for (int i=p; i<q; i++) {
                result.append(get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }

        return result;
    }

    static void copyOfRangeTest() {
        SingleLinkedList list1 = new SingleLinkedList();
        list1.head = new Node(1, new Node(2, new Node(3, new Node(4))));
        System.out.printf("list1 : %s%n", list1);

        
        SingleLinkedList list2 = list1.copyOfRange(1, 3);
        System.out.printf("list2 = list1.copyOfRange(%d, %d) : %s%n",1, 3, list2);
    }

    /**
     * 입력한 인덱스에 해당하는 노드를 찾는 메서드
     * @return index 번째에 존재하는 노드
     * @exception NoSuchElementException 해당 위치에 노드가 존재하지 않음
     */
    public Node getNode(int index) {
        Node node = head;

        for (int i=0; i<index; i++) {
            if (node == null) {
                throw new NoSuchElementException();
            }
            node = node.next;
        }

        return node;
    }

    /**
     * 리스트에서 i번째 요소를 x로 변경하는  메서드
     * @param i 위치
     * @param x 변경 값
     * @exception NoSuchElementException - 지정한 위치에 요소가 없음
     */
    public void set(int i, int x) {
        try {
            Node node = getNode(i);
            node.data = x;
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }

    static void setTest() {
        SingleLinkedList list = new SingleLinkedList();
        list.head = new Node(1, new Node(2, new Node(3)));
        System.out.printf("list : %s%n", list);
        
        
        System.out.printf("list.set(%d, %d)%n", 1, 4);
        list.set(1, 4);
        System.out.printf("list : %s%n", list);
        
        try {
            System.out.printf("list.set(%d, %d) : %n", 3, 0);
            list.set(3, 0);
            System.out.printf("list : %s%n", list);
        } catch(NoSuchElementException ignore) {
            System.out.println("Error : NoSuchElementException");
        }
    }

    /**
     * 리스트에서 주어진 i번째 요소와 j번째 요소를 교환하는 메서드
     * @param i 인덱스 번호
     * @param j 인덱스 번호
     * @exception IndexOutOfBoundsException 입력한 인덱스 번호가 음수이거나, 리스트의 크기를 초과함
     */
    public void swap(int i, int j) {
        if (i<0 && j<0 && size() < i && size() < j) {
            throw new IndexOutOfBoundsException();
        }

        Node first = getNode(i);
        Node second = getNode(j);

        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    static void swapTest() {
        SingleLinkedList list = new SingleLinkedList();
        list.head = new Node(1, new Node(2, new Node(3)));
        System.out.printf("list : %s%n", list);
        
        
        System.out.printf("list.swap(%d, %d)%n", 0, 2);
        list.swap(0, 2);
        System.out.printf("list : %s%n", list);
        
        try {
            System.out.printf("list.swap(%d, %d)%n", 1, 4);
            list.swap(1, 4);
            System.out.printf("list : %s%n", list);
        } catch(NoSuchElementException ignore) {
            System.out.println("Error : NoSuchElementException");
        }
    }

    /**
     * 2개의 리스트를 받아 정렬된 새로운 리스트를 생성하는 메서드
     * @param list 오름차순으로 정렬된 리스트
     * @return list1과 list2의 모든 원소를 오름차순으로 포함한 새로운 리스트
     */
    public SingleLinkedList merge(SingleLinkedList list) {
        if (head == null) {
            return list;
        }

        if (list.head == null) {
            return this;
        }

        SingleLinkedList result = new SingleLinkedList();
        Node node1 = this.head;
        Node node2 = list.head;

        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                result.append(node1.data);
                node1 = node1.next;
            } else {
                result.append(node2.data);
                node2 = node2.next;
            }
        }

        while (node1 !=null) {
            result.append(node1.data);
            node1 = node1.next;
        }

        while (node2 != null) {
            result.append(node2.data);
            node2 = node2.next;
        }

        return result;
    }

    static void mergeTest() {
        SingleLinkedList list1 = new SingleLinkedList();
        list1.head = new Node(1, new Node(3, new Node(5)));
        System.out.printf("list1 : %s%n", list1);

        SingleLinkedList list2 = new SingleLinkedList();
        list2.head = new Node(2, new Node(3, new Node(4)));
        System.out.printf("list2 : %s%n", list2);

        SingleLinkedList list3 = list1.merge(list2);
        System.out.printf("list1.merge(list2) : %s%n", list3);
    }

    /**
     * 리스트의 요소를 왼쪽으로 이동하는 메서드
     * 리스트의 첫 번째 원소는 마지막으로 이동됨
     */
    public void rotateLeft() {
        if (head == null) {
            return;
        }
        
        int first = get(0);

        Node node = head;
        while(node.next != null) {
            node.data = node.next.data;
            node = node.next;
        }

        node.data = first;
        
        return;
    }

    static void rotateLeftTest() {
        SingleLinkedList list = new SingleLinkedList();
        list.head = new Node(1, new Node(3, new Node(5)));
        System.out.printf("list : %s%n", list);
        
        list.rotateLeft();
        System.out.printf("list.rotateLeft : %s%n", list);
        
        list.rotateLeft();
        System.out.printf("list.rotateLeft : %s%n", list);
    }
}