package src.balyanova.lesson2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppMain {
    private static final int SIZE = 10000;
    private static Long time;

    public static void main(String[] args) {
        List<Notebook> notebooks = init();

        startTime();
        SelectionSortNotebook.sort(notebooks);
        endTime();//337
        printNotebooks(notebooks);

//        startTime();
//        SelectionSortNotebook.compareSort(notebooks);
//        endTime();//31
//        printNotebooks(notebooks);

    }

    public static void startTime() {
        time = System.currentTimeMillis();
    }

    public static void endTime() {
        time = System.currentTimeMillis() - time;
        System.out.println("Wasted time: " + time);
    }

    private static void printNotebooks(List<Notebook> list) {
        for (Notebook n : list) {
            System.out.printf("SerialId: %s, price: %s, memory: %s, manufacturer: %s%n", n.getSerialId(),
                    n.getPrice(),
                    n.getMemory(), n.getManufacturer());
        }
    }

    private static ArrayList<Notebook> init() {
        ArrayList<Notebook> arrayList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(create());
        }
        return arrayList;
    }

    private static Notebook create() {
        Random random = new Random();
        BigDecimal price = BigDecimal.valueOf(random.nextInt(21) * 100 + 500);
        int memory = (random.nextInt(6) + 1) * 4;
        int manufacturersCount = Notebook.Manufacturer.values().length;
        Notebook.Manufacturer manufacturer = Notebook.Manufacturer.values()[random.nextInt(manufacturersCount)];
        return new Notebook(price, memory, manufacturer);
    }
}
