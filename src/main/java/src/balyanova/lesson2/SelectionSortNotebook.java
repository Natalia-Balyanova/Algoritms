package src.balyanova.lesson2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SelectionSortNotebook extends SelectionSort {
    public static List<Notebook> sort(List<Notebook> notebooks) {
        int min;
        for (int i = 0; i < notebooks.size() - 1; i++) {//чтобы не получить IndexOutOfBoundEx
            min = i;
            for (int j = i + 1; j < notebooks.size(); j++) {
                if (notebooks.get(j).compareTo(notebooks.get(min)) < 0) {
                    min = j;
                }
            }
            if (i == min) {
                continue;
            }
            Notebook temp = notebooks.get(i);
            notebooks.set(i, notebooks.get(min));
            notebooks.set(min, temp);
        }
        return notebooks;
    }

    public static void compareSort(List<Notebook> n) {//реализуем компаратор (сравнение объектов)
        Comparator<Notebook> comparator = Comparator.comparing(Notebook::getPrice)
                .thenComparing(Notebook::getMemory)
                .thenComparing(Notebook::getManufacturer);
        n.sort(comparator);
    }
}
