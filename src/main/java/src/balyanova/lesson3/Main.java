package src.balyanova.lesson3;

public class Main {
    public static void main(String[] args) {
        int[] arrayFindEleven = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16}; //11
        int[] arrayFindThree = {1, 2, 4, 5, 6}; //3
        int[] arrayFindOne = {2, 3, 4, 5, 6, 7, 8}; //1
        int[] arrayFindFifteen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; //15
        int[] arrayNew = {}; //1

        findNumber(arrayFindEleven);
        findNumber(arrayFindThree);
        findNumber(arrayFindOne);
        findNumber(arrayFindFifteen);
        findNumber(arrayNew);

        testRing();

    }
    public static void findNumber(int[] arr) {
        if(arr.length == 0) { //for empty array
            System.out.println(1); //int[] arrayNew = {}; //1
            return;
        }
        if(arr[0] != 1) {//если под нулевым индексом не "1", значит 1 элемент пропущен
            System.out.println(1); //int[] arrayFindOne = {2, 3, 4, 5, 6, 7, 8}; //1
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] - arr[i] != 1) { //если пропуск в середине
                System.out.println(arr[i] + 1);
                return;
            }
        }
        System.out.println(arr[arr.length - 1] + 1); //если пропущен последний элемент
    }

    public static void testRing() {
        Queue<Integer> queue = new QueueImpl<>(4);
        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));
        System.out.println("add element: " + queue.insert(14));//false
        System.out.println("add element: " + queue.insert(17));//false

        queue.display();//[34, 12, 20, 16]
        System.out.println("remove: " + queue.remove());//34
        queue.display();//[12, 20, 16]
        System.out.println("add element: " + queue.insert(17));//true
        queue.display();//[]
        System.out.println("add element: " + queue.insert(100));//false
        queue.display();//[]
        System.out.println("remove: " + queue.remove());//12
        queue.display();//[]
    }
}
