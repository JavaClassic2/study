package com.nhnacademy;

import java.util.Arrays;

public class ArrayUtils {
    public static void main(String[] args) {
        // testMin();
        // testMax();
        // testMean();
        // testReverse();
        // testWithoutDuplicates();
        // testConcatenate();
        // testShuffle();
        // testTally();
        // testArrayCopy();
        // testSieveOfEratosthenes();
        testPascalTriangle();
    }

    /**
     * int 배열에서 최솟값 찾기
     * @param numbers 배열
     * @return 배열의 최솟값
     * @exception NullPointerExcpetion 입력된 numbers가 null인 경우
     * @exception IllegalArgumentException 입력된 numbers의 길이가 0인 경우
     */
    static int min(int[] numbers){
        if (numbers.length == 0) {
            throw new IllegalArgumentException();
        }

        int min = numbers[0];
        
        for (int n : numbers) {
            if (min > n) {
                min = n;
            }
        }

        return min;
    }

    static int max(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException();
        }

        int max = numbers[0];
        
        for (int n : numbers) {
            if (max < n) {
                max = n;
            }
        }

        return max;
    }

    static int mean(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        
        for (int i : numbers) {
            sum += i;
        }

        return sum / numbers.length;
    }

    static int[] reverse(int[] numbers) {
        int[] result = new int[numbers.length];

        // int i=0, j=numbers.length; 이런식도 가능
        for (int i=0; i<numbers.length; i++) {
            result[i] = numbers[numbers.length-i-1];
        }

        return result;
    }

    static int[] withoutDuplicates(int[] numbers) {
        int[] result = new int[numbers.length];
        int index = 0;

        // 이중 for문 + break도 가능 <- isDuplicate 대체
        for (int i=0; i<numbers.length; i++) {
            if (!isDuplicate(result, numbers[i])) {
                result[index] = numbers[i];
                index++;
            }
        }

        return Arrays.copyOf(result, index);
        // return concatenate(new int[]{}, numbers)
    }

    private static boolean isDuplicate(int[] numbers, int number) {
        for (int n : numbers) {
            if (n == number) {
                return true;
            }
        }
        return false;
    }

    // 다 넣은 후에 withotuDuplicates 해도 됨
    static int[] concatenate(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int index = 0;

        for (int i=0; i<a.length; i++) {
            if (!isDuplicate(result, a[i])) {
                result[index] = a[i];
                index++;
            }
        }

        for (int i=0; i<b.length; i++) {
            if (!isDuplicate(result, b[i])) {
                result[index] = b[i];
                index++;
            }
        }

        return Arrays.copyOf(result, index);
    }

    static void shuffle(int[] a) {
        for (int i=0; i<a.length; i++) {
            int num1 = (int)(Math.random() * a.length);
            int num2 = (int)(Math.random() * a.length);
    
            int temp = a[num1];
            a[num1] = a[num2];
            a[num2] = temp;
        }
    }

    static int[] tally(String message) {
        int[] numbers = new int[message.length()];
        char[] splitMessage = message.toCharArray();

        for (int i=0; i<numbers.length; i++) {
            numbers[i] = (int)splitMessage[i];
        }

        int[] result = new int[26];
        
        for (int i : numbers) {
            if (i < 95) {
                i -= 65;
            } else {
                i -= 97;
            }
            result[i] += 1;
        }

        return result;
    }

    static int arraycopy(int[] src, int srcPos, int[] dest, int destPos, int size) {
        if (src.length <= srcPos || dest.length <= destPos || src.length < srcPos+size || dest.length < destPos + size) {
            throw new IllegalCallerException();
        }

        int[] copy = new int[size];
        for (int i=0; i<size; i++) {
            copy[i] = src[i+srcPos];
        }

        for (int i=0; i<size; i++) {
            dest[i+destPos] = copy[i];
        }

        return 0;
    }

    /**
     * 배열의 각 요소를 곱하여 그 합을 반환하는 메서드를 작성하고, 테스트하세요
     * innerProdut(x,y) = n∑i=0 x[i]y[i]
     * @param x
     * @param y
     * @return
     */
    static double innerProduct(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("배열의 사이즈가 같지 않습니다.");
        }

        int sum=0;
        for (int i=0; i<x.length; i++) {
            sum += x[i] * y[i];
        }

        return sum;
    }

    // 두 배열의 대수적 외적(algebraic outer product)을 계산하는 메서드를 작성하고, 테스트하세요.
    // p[i][j]=a[i]∗b[j]
    static double[][] outerProduct(double[] x, double[] y) {
        double[][] result = new double[x.length][y.length];
        
        for(int i=0; i<x.length; i++) {
            for (int j=0; j<y.length; j++) {
                result[i][j] = x[i] * y[j];
            }
        }

        return result;
    }
    
    // 두 배열의 행렬 곱하여 반환하는 메서드를 작성하고, 테스트하세요.
    // p[i][j]= n∑k=0 a[i][k]×b[k][j]
    static double[][] product(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalArgumentException("a와 b 행렬의 길이가 같지 않습니다.");
        }

        double[][] result = new double[a.length][b[0].length];
        
        for(int i=0; i<a.length; i++) {
            for (int j=0; j<b.length; j++) {
                for (int k=0; k<a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    // 배열의 전치 행렬을 생성하여 반환하는 메서드를 작성하고, 테스트하세요.
    // ta[i][j] = a[j][i]
    static double[][] transpose(double[][] a) {
        double[][] result = new double[a[0].length][a.length];
        
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[0].length; j++) {
                result[i][j] = a[j][i];
            }
        }

        return result;
    }

    // 에라토스테네스의 체 (소수 구하기)
    static int[] sieveOfEratosthenes(int size) {
        int[] numbers = new int[size-1];

        for (int i=0; i<numbers.length; i++) {
            numbers[i] = i+2;
        }

        int index = 0;

        while (index < numbers.length){
            int prime = numbers[index];
            numbers = Arrays.stream(numbers).filter(n -> (n==prime) || (n%prime != 0)).toArray();
            index++;
        }

        return numbers;
    }

    static int[][] pascalTriangle(int size) {
        int[][] result = new int[size][];
        
        for (int i=0; i<size; i++) {
            result[i] = new int[i+1];
            Arrays.fill(result[i], 1);
        }

        if (result.length < 3) {
            return result;
        }

        for (int i=2; i<size; i++) {
            for (int j=1; j<result[i].length-1; j++) {
                result[i][j] = result[i-1][j-1] + result[i-1][j];
            }
        }

        return result;
    }

    static void testMin() {
        int[] numbers = {1, 5, 2, 4};
        int[] test1 = {1, 2, 3, 4, 5}; // 1
        int[] test2 = {5, 4, 3, 2, 1}; // 1
        int[] test3 = {4, 1, 4, 4, 4}; // 1
        int[] test4 = {3, 3, 3, 7, 3}; // 3
        int[] test5 = {6, 1, 4, 3, 7}; // 2
        int[] error = {};
        
        System.out.printf("min(%s) = %d%n", Arrays.toString(numbers), min(numbers));
        System.out.printf("min(%s) = %d%n", Arrays.toString(test1), min(test1));
        System.out.printf("min(%s) = %d%n", Arrays.toString(test2), min(test2));
        System.out.printf("min(%s) = %d%n", Arrays.toString(test3), min(test3));
        System.out.printf("min(%s) = %d%n", Arrays.toString(test4), min(test4));
        System.out.printf("min(%s) = %d%n", Arrays.toString(test5), min(test5));
        
        try {
            System.out.printf("min(%s) = %d%n", Arrays.toString(error), min(error));
        } catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    static void testMax() {
        int[] numbers = {1, 5, 2, 4};
        int[] test1 = {1, 2, 3, 4, 5}; // 5
        int[] test2 = {5, 4, 3, 2, 1}; // 5
        int[] test3 = {4, 1, 4, 4, 4}; // 4
        int[] test4 = {3, 3, 3, 7, 3}; // 7
        int[] test5 = {6, 1, 4, 3, 7}; // 7
        
        System.out.printf("max(%s) = %d%n", Arrays.toString(numbers), max(numbers));
        System.out.printf("max(%s) = %d%n", Arrays.toString(test1), max(test1));
        System.out.printf("max(%s) = %d%n", Arrays.toString(test2), max(test2));
        System.out.printf("max(%s) = %d%n", Arrays.toString(test3), max(test3));
        System.out.printf("max(%s) = %d%n", Arrays.toString(test4), max(test4));
        System.out.printf("max(%s) = %d%n", Arrays.toString(test5), max(test5));
    }

    static void testMean() {
        int[] numbers = {1, 5, 2, 4}; // 3
        int[] test1 = {1, 2, 3, 4, 5}; // 3
        int[] test2 = {5, 4, 3, 2, 1}; // 3
        int[] test3 = {4, 1, 4, 4, 4}; // 3
        int[] test4 = {3, 3, 3, 7, 3}; // 3
        int[] test5 = {6, 1, 4, 3, 7}; // 4

        System.out.printf("mean(%s) = %d%n", Arrays.toString(numbers), mean(numbers));
        System.out.printf("mean(%s) = %d%n", Arrays.toString(test1), mean(test1));
        System.out.printf("mean(%s) = %d%n", Arrays.toString(test2), mean(test2));
        System.out.printf("mean(%s) = %d%n", Arrays.toString(test3), mean(test3));
        System.out.printf("mean(%s) = %d%n", Arrays.toString(test4), mean(test4));
        System.out.printf("mean(%s) = %d%n", Arrays.toString(test5), mean(test5));
    }

    static void testReverse() {
        int[] numbers = {1, 2, 3}; // {3, 2, 1}
        int[] test1 = {1}; // {1}
        int[] test2 = {1, 2, 1, 2}; // {2, 1, 2, 1}
        int[] test3 = {1, 1, 2, 3, 5, 8}; // {8, 5, 3, 2, 1, 1}
        int[] test4 = {1, 10, 100, 1000, 10000, 100000}; // {100000, 10000, 1000, 100, 10, 1} 

        System.out.printf("reverse(%s) = %s%n", Arrays.toString(numbers), Arrays.toString(reverse(numbers)));
        System.out.printf("reverse(%s) = %s%n", Arrays.toString(test1), Arrays.toString(reverse(test1)));
        System.out.printf("reverse(%s) = %s%n", Arrays.toString(test2), Arrays.toString(reverse(test2)));
        System.out.printf("reverse(%s) = %s%n", Arrays.toString(test3), Arrays.toString(reverse(test3)));
        System.out.printf("reverse(%s) = %s%n", Arrays.toString(test4), Arrays.toString(reverse(test4)));
    }

    static void testWithoutDuplicates() {
        int[] a = {1, 2, 1, 3 , 1, 2, 5};
        int[] b = withoutDuplicates(a);

        System.out.printf("withoutDuplicates(%s) = %s%n", Arrays.toString(a), Arrays.toString(b));
    }

    static void testConcatenate() {
        int[] a = { 1, 3, 5, 7 };
        int[] b = { 1, 2, 3, 5, 8 };
        int[] c = { 1, 1, 2, 3, 5, 8 };

        System.out.println("a : " + Arrays.toString(a));
        System.out.println("b : " + Arrays.toString(b));
        System.out.println("a + b : " + Arrays.toString(concatenate(a, b)));
        System.out.println("c : " + Arrays.toString(c));
        System.out.println("c + a : " + Arrays.toString(concatenate(c, a)));
    }

    static void testShuffle() {
        int[] a = { 1, 3, 5, 7 };

        System.out.println("a : " + Arrays.toString(a));
        int[] temp1 = a.clone();
        shuffle(temp1);
        System.out.println("shuffle(a) : " + Arrays.toString(temp1));
        int[] temp2 = a.clone();
        shuffle(temp2);
        System.out.println("shuffle(a) : " + Arrays.toString(temp2));
        int[] temp3 = a.clone();
        shuffle(temp3);
        System.out.println("shuffle(a) : " + Arrays.toString(temp3));
    }

    static void testTally() {
        String message = "HelloWorld";
        int [] frequencies = tally(message);
        System.out.printf("tally(%s) = %s%n",message, Arrays.toString(frequencies));

        message = "NHNAcademyJavaClass";
        frequencies = tally(message);
        System.out.printf("tally(%s) = %s%n",message, Arrays.toString(frequencies));
        
        message = "Icandothisallday";
        frequencies = tally(message);
        System.out.printf("tally(%s) = %s%n",message, Arrays.toString(frequencies));
        
        message = "HopeIsTheGreatestOfTheGiftsWellReceive";
        frequencies = tally(message);
        System.out.printf("tally(%s) = %s%n",message, Arrays.toString(frequencies));

    }

    static void testArrayCopy() {
        int[] src = {1, 2, 3, 4, 5, 6};
        int[] dest= new int[10];

        System.out.printf("src = %s%n", Arrays.toString(src));
        System.out.printf("dest = %s%n", Arrays.toString(dest));

        arraycopy(src, 0, dest, 0, 6);
        System.out.printf("dest = %s%n", Arrays.toString(dest));

        arraycopy(src, 0, dest, 4, 6);
        System.out.printf("dest = %s%n", Arrays.toString(dest));

        arraycopy(src, 2, dest, 0, 4);
        System.out.printf("dest = %s%n", Arrays.toString(dest));

        arraycopy(dest, 0, dest, 2, 4);
        System.out.printf("dest = %s%n", Arrays.toString(dest));

        arraycopy(dest, 2, dest, 0, 8);
        System.out.printf("dest = %s%n", Arrays.toString(dest));
    }

    // 행렬 테스트

    static void testSieveOfEratosthenes() {
        int[] result = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,  53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        System.out.println(Arrays.toString(result).equals(Arrays.toString(sieveOfEratosthenes(100))));
        // System.out.printf("sieveOfEratosthenes(100) : %s%n",Arrays.toString(sieveOfEratosthenes(100)));
        // System.out.printf("sieveOfEratosthenes result : %s%n", Arrays.toString(result));
        
        int[] result2 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};
        System.out.println(Arrays.toString(result2).equals(Arrays.toString(sieveOfEratosthenes(1000))));
        // System.out.printf("sieveOfEratosthenes(1000) : %s%n",Arrays.toString(sieveOfEratosthenes(1000)));
        // System.out.printf("sieveOfEratosthenes result : %s%n", Arrays.toString(result2));
    }
    
    static void testPascalTriangle() {
        int[][] result = {
            {1},
            {1, 1},
            {1, 2, 1},
            {1, 3, 3, 1},
            {1, 4, 6, 4, 1}
        };
        
        System.out.println("pascalTriangle(5) : ");
        Arrays.stream(pascalTriangle(5)).forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println("result : ");
        Arrays.stream(result).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}
