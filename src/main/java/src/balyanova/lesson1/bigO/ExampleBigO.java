package src.balyanova.lesson1.bigO;

public class ExampleBigO {
    public static int fibonacci (int num) {
        if (num <= 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
