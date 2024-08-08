import java.util.NoSuchElementException;

public class LinkedDataStructures {
    static class Node {
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

    public static void main(String[] args) {
        // toStringTest();
        // getTest();
        // appendDataTest();
        // appendListTest();
        // insertTest();
        // sizeTest();
        // sumTest();
        // removeLastTest();
        // copyTest();
        // copyOfRangeTest();
        // setTest();
        // swapTest();
        // mergedTest();
        rotateLeftTest();
    }

    /**
     * 리스트의 요소들을 나열한 문자열 생성을 위한 toString() 메서드 작성
     * @param list 출력할 리스트
     * @return 리스트 요소를 나열한 문자열
     */
    static String toString(Node list) {
        if (list == null) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        
        builder.append("[");
        
        while (list != null) {
            builder.append(list.data);
            list = list.next;

            if (list != null) {
                builder.append(", ");
            }
        }

        builder.append("]");

        return builder.toString();
    }

    static void toStringTest() {
        Node list = null;
        System.out.println(toString(list));

        list = new Node(1, new Node(2, new Node(3)));
        System.out.println(toString(list));
    }

    /**
     * 리스트에서 i번째 요소를 반환하는 get() 메서드 작성
     * @param list 찾고자하는 리스트
     * @param index 인덱스 번호
     * @return i번째 노드의 요소
     * @exception NoSuchElementException 해당 요소가 없음
     */
    static int get(Node list, int index) {
        if (list == null) {
            throw new NullPointerException("입력하신 list가 null입니다.");
        }

        for (int i=0; i<index; i++) {
            if (list == null) {
                throw new NoSuchElementException ("index 범위를 초과하였습니다.");
            }

            list = list.next;
        }

        return list.data;
    }

    static void getTest() {
        Node list = new Node(1, new Node(2, new Node(3)));

        System.out.println(get(list, 1));
        
        try {
            System.out.println(get(list, 4));
        } catch(NoSuchElementException e) {
            System.out.println("Exception : NoSuchElementException");
        }
    }

    /**
     * 리스트의 맨 뒤에 새로운 요소를 추가하는 append() 메서드 작성
     * @param list 추가될 리스트
     * @param x 추가할 요소
     * @return 요소가 추가된 리스트
     */
    static Node append(Node list, int x) {
        Node start = list;

        if (list == null) {
            list = new Node(x);
            return list;
        }
        
        while (list != null) {
            if (list.next == null) {
                list.next = new Node(x);
                return start;
                
            }
            list = list.next;
        }

        return start;
    }

    static void appendDataTest() {
        Node list = null;
        System.out.println(toString(list));

        list = append(list, 1);
        System.out.println(toString(list));

        list = append(list, 3);
        System.out.println(toString(list));

        list = append(list, 2);
        System.out.println(toString(list));

        list = append(list, 4);
        System.out.println(toString(list));
    }

    /**
     * 리스트에 다른 리스트의 요소들을 추가하는 append() 메소드 작성
     * @param list1 앞에 추가될
     * @param list2 뒤에 추가할 리스트
     * @return list2의 요소가 추가된 list1
     */
    static Node append(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        
        Node start = list1;
        
        while (list1.next != null) {
            list1 = list1.next;
        }

        if (list2.next == null) {
            list1.next = new Node(list2.data);
            return start;
        }

        while (list2.next != null) {
            list1.next = new Node(list2.data, list2.next);
            list1 = list1.next;
            list2 = list2.next;
        }

        return start;
    }

    static void appendListTest() {
        Node list1 = new Node(1, new Node(2, new Node(3)));
        Node list2 = new Node(6, new Node(5, new Node(4)));

        System.out.println(toString(list1));
        System.out.println(toString(list2));

        list1 = append(list1, list2);
        System.out.println(toString(list1));
        System.out.println(toString(list2));
    }

    /**
     * 리스트의 i번째에 새로운 요소를 삽입하는 insert() 메서드 작성
     * @param list 삽입될 리스트
     * @param i i번째에 데이터 삽입
     * @param x 삽입할 데이터
     * @return 요소가 추가된 리스트
     * @excpetion IndexOutOfBoundsException 주어진 위치에 요소 삽입이 불가능한 경우
     */
    static Node insert(Node list, int index, int x) {
        if (list == null) {
            list = new Node(x);

            return list;
        }
        
        Node start = list;

        for (int i=0; i<index-1; i++) {
            if (list == null) {
                throw new IndexOutOfBoundsException("해당 위치에 요소를 삽입할 수 없습니다. : " + i);
            }

            list = list.next;
        }

        if (list.next == null) {
            list.next = new Node(x);
        } else {
            list.next = new Node(x, list.next);
        }
        
        return start;
    }

    static void insertTest() {
        Node list = null;
        System.out.println(toString(list));

        list = insert(list, 0, 1);
        System.out.println(toString(list));

        list = insert(list, 1, 3);
        System.out.println(toString(list));

        list = insert(list, 1, 2);
        System.out.println(toString(list));

        list = insert(list, 3, 4);
        System.out.println(toString(list));

        try {
            list = insert(list, 10, 10);
            System.out.println(toString(list));
        } catch(IndexOutOfBoundsException ignore) {
            System.out.println("Exception : IndexOutOfBoundsException");
        }
    }

    /**
     * 리스트의 길이를 구하기 위한 size() 메서드 작성
     * @param list 길이를 구할 리스트
     * @return 리스트의 요소 수
     */
    static int size(Node list) {
        int size = 0;

        while (list != null) {
            list = list.next;
            size++;
        }

        return size;
    }

    static void sizeTest() {
        Node list = null;
        System.out.printf("size(%s) = %d%n", toString(list), size(list));
        list = append(list, 1);
        System.out.printf("size(%s) = %d%n", toString(list), size(list));
        list = append(list, 2);
        System.out.printf("size(%s) = %d%n", toString(list), size(list));
        list = append(list, 3);
        System.out.printf("size(%s) = %d%n", toString(list), size(list));
    }

    /**
     * 정수 리스트의 값을 더해 반환하는 sum() 메서드 작성
     * @param list 정수 리스트
     * @return 리스트 요소의 합
     * @exception NoSuchElementException 입력한 리스트가 null인 경우
     */
    static int sum(Node list) {
        if (list == null) {
            throw new NoSuchElementException("입력한 list가 null입니다.");
        }
        int sum = 0;

        while (list != null) {
            sum += list.data;
            list = list.next;
        }

        return sum;
    }

    static void sumTest(){
        Node list = new Node(1);
        System.out.println(sum(list));
        list = append(list , 2);
        System.out.println(sum(list));
        list = append(list , 3);
        System.out.println(sum(list));

        try {
            list = null;
            System.out.println(sum(list));
        } catch(NoSuchElementException ignore){
            System.out.println("Error : NoSuchElementException");
        }
    }

    /**
     * 리스트의 마지막 노드를 삭제하는 removeLast() 메서드 작성
     * @param list 
     * @return 마지막 노드가 삭제된 리스트
     */
    static Node removeLast(Node list) {
        Node start = list;

        if (list == null || list.next == null) {
            return null;
        }

        while (list.next != null) {
            if (list.next.next == null) {
                list.next = null;
                break;
            }

            list = list.next;

        }

        return start;
    }

    static void removeLastTest() {
        Node list = new Node(1, new Node(2, new Node(3)));

        System.out.println(toString(list));
        list = removeLast(list);
        System.out.println(toString(list));
        list = removeLast(list);
        System.out.println(toString(list));
        list = removeLast(list);
        System.out.println(toString(list));
    }

    /**
     * 리스트를 복제해 새로운 리스트를 생성하는 copy() 메서드 작성
     * @param list 복제할 리스트
     * @return 동일한 요소로 복제된 새로운 리스트
     */
    static Node copy(Node list) {
        if (list == null) {
            return list;
        }

        Node node = new Node(list.data, list.next);
        Node result = node;

        while (list.next != null) {
            list = list.next;
            node.next = new Node(list.data, list.next);
            node = node.next;
        }

        return result;
    }

    static void copyTest() {
        Node list1 = new Node(1, new Node(2, new Node(3)));
        Node list2 = null;

        System.out.println(toString(list1) + " : " + toString(list2));
        list2 = copy(list1);
        System.out.println(toString(list1) + " : " + toString(list2));
        list1=append(list1, 4);
        System.out.println(toString(list1) + " : " + toString(list2));
    }

    /**
     * 리스트의 지정 범위만 복제하는 copyOfRange() 메서드 작성
     * @param list 복사할 리스트
     * @param p 시작 인덱스
     * @param q 끝 인덱스
     * @return 리스트에서 p번째부터 q번째 앞까지의 노드들을 복사한 새로운 리스트
     */
    static Node copyOfRange(Node list, int p, int q) {
        if (list == null) {
            return list;
        }

        Node node = null;;
        
        try {
            for (int i=p; i<q; i++) {
                node = append(node, get(list, i));
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException();
        }

        return node;
    }

    static void copyOfRangeTest() {
        Node list1 = new Node(1, new Node(2, new Node(3)));
        System.out.println(toString(list1));

        Node list2 = copyOfRange(list1, 1, 3);
        System.out.println(toString(list2));
    }

    static Node getNode(Node list, int index) {
        for (int i=0; i<index; i++) {
            if (list == null) {
                throw new NoSuchElementException();
            }
            list = list.next;
        }

        return list;
    }

    /**
     * 리스트에서 i번째 요소를 변경하는 set() 메서드 작성
     * @param list
     * @param i 인덱스
     * @param x 변경 값
     * @exception NoSuchElementException - 지정한 위치에 요소가 없음
     */
    static void set(Node list, int i, int x) {
        try {
            Node node = getNode(list, i);
            node.data = x;
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }

    static void setTest() {
        Node list = new Node(1, new Node(2, new Node(3)));
        System.out.println(toString(list));

        set(list, 1, 4);
        System.out.println(toString(list));

        try {
            set(list, 3, 0);
        } catch(NoSuchElementException ignore) {
            System.out.println("Error : NoSuchElementException");
        }
    }

    /**
     * 리스트에서 주어진 i번째 요소와 j번째 요소를 교환하는 swap() 메서드 작성
     * @param list
     * @param i 인덱스 번호
     * @param j 인덱스 번호
     */
    static void swap(Node list, int i, int j) {
        Node first = getNode(list, i);
        Node second = getNode(list, j);

        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    static void swapTest() {
        Node list = new Node(1, new Node(2, new Node(3)));
        System.out.println(toString(list));

        swap(list, 0, 2);
        System.out.println(toString(list));

        try {
            swap(list, 1, 4);
        } catch(NoSuchElementException ignore) {
            System.out.println("Error : NoSuchElementException");
        }
    }

    /**
     * 2개의 리스트를 받아 정렬된 새로운 리스트를 생성하는 merged() 메서드 작성
     * @param list1 오름차순으로 정렬된 리스트
     * @param list2 오름차순으로 정렬된 리스트
     * @return list1과 list2의 모든 원소를 오름차순으로 포함한 새로운 리스트
     */
    static Node merged(Node list1, Node list2) {
        // 요구사항에는 없지만 오름차순으로 정렬되어있는지 확인하는 코드도 있으면 좋을듯?
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        Node result = list1;

        while (list2 != null) {
            int data = list2.data;
            // list1에 삽입

            if (list1.data > data) {
                list1 = new Node(data, list1);
                list2 = list2.next;
                continue;
            }

            while(list1.next != null) {
                if (list1.next.data > data) {
                    list1.next = new Node(data, list1.next);
                    break;
                }
                list1 = list1.next;
            }

            if (list1.next == null) {
                list1.next = new Node(data);
            }
            
            list2 = list2.next;
        }

        return result;
    }

    static void mergedTest() {
        Node list1 = new Node(1, new Node(2, new Node(5)));
        Node list2 = new Node(1, new Node(3, new Node(4)));
        System.out.println(toString(list1));
        System.out.println(toString(list2));

        Node list3 = merged(list1, list2);
        System.out.println(toString(list3));
    }

    /**
     * 리스트의 요소를 왼쪽으로 이동하는 rotateLeft() 메서드 작성
     * 리스트의 첫 번째 원소를 마지막으로 이동
     * 새로운 노드는 생성되지 않습니다.
     * @param list
     * @return 왼쪽으로 회전된 리스트
     */
    static Node rotateLeft(Node list) {
        Node start = list;

        int first = get(list, 0);

        while(list.next != null) {
            list.data = list.next.data;
            list = list.next;
        }

        list.data = first;
        
        return start;
    }

    static void rotateLeftTest() {
        Node list = new Node(1, new Node(2, new Node(3)));
        System.out.println(toString(list));

        list = rotateLeft(list);
        System.out.println(toString(list));

        list = rotateLeft(list);
        System.out.println(toString(list));
    }
}