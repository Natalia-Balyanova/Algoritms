algoritmsAndStructures
Определить сложность следующих алгоритмов: -. Поиск элемента массива с известным индексом ответ: O(1) - т.к. известен индекс
-. Дублирование одномерного массива через foreach
ответ: O(n)

-. Удаление элемента массива с известным индексом без сдвига
ответ: O(1) - т.к. известен индекс

-. Удаление элемента массива с неизвестным индексом без сдвига
ответ: O(n)

-. Удаление элемента массива с неизвестным индексом со сдвигом
ответ: O(n)

Определить сложность следующих алгоритмов. Сколько произойдет итераций?
a) O(nlogn)

int n = 10000;
List<Integer> arrayList = new ArrayList<>();
for (int i = 0; i < n; i++) { O(n)
for (int j = 1; j < n; j *= 2) {O(logn)
arrayList.add(i * j);
}
}
b) O(n^2)

int n = 10000;
List<Integer> arrayList = new ArrayList<>();
for (int i = 0; i < n; i += 2) { O(n)
for (int j = i; j < n; j++) { O(n)
arrayList.add(i * j);
}
}
с) O(n) -

int n = 10000;
List<Integer> arrayList = new ArrayList<>();
for (int i = 0; i < n; i ++) { O(n)
for (int j = 0; j < n; j++) { O(n)
arrayList.add(i * j);
n--; -
}
}
d*)O(n)
factorial(12)
public static int factorial(int n) {
if (n == 1) {
return n;
}
return n * factorial(n - 1);
}

e*)
fib(20);

public static int fib(int n) {
if (n == 1) || (n == 2)) {
return n;
}
return fib(n - 1) + fib(n - 2);
}