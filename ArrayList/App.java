public class App {
    public static void main(String[] args) {
        arrayListTest();
    }

    private static void arrayListTest() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add("bot");
        arrayList.remove(1);
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        
        arrayList.clear();
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        
        arrayList.add("taco");
        arrayList.add("yakki");
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
    }
}
