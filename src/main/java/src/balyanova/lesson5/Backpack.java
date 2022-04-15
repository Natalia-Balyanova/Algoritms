package src.balyanova.lesson5;
//Задача о рюкзаке найти самые дорогие товары. ограничение 5 кг
public class Backpack {
    public static int[] weights;
    public static int[] prices;
    public static final int LIMIT = 5;

    public static void main(String[] args) {
        Product notebook = new Product("Notebook", 4,40000);
        Product clock = new Product("Clock", 1, 5000);
        Product kettlebell = new Product("Kettlebell", 5, 100);
        Product guitar = new Product("Guitar", 3, 37000);
        Product smartphone = new Product("Smartphone", 2, 10000);

        weights = new int[]{notebook.getWeight(), clock.getWeight(), kettlebell.getWeight(), guitar.getWeight(), smartphone.getWeight()};
        prices = new int[]{notebook.getPrice(), clock.getPrice(), kettlebell.getPrice(), guitar.getPrice(), smartphone.getPrice()};
        System.out.println("Сумма самых дорогих продуктов для рюкзака в пределах 5 кг: " + findMaxProd(prices.length - 1, LIMIT));//47000
    }

    private static int findMaxProd(int i, int LIMIT) {
        if(i <= 0){
            return 0;
        }
        if(weights[i] > LIMIT) {
            return findMaxProd(i - 1, LIMIT);
        } else {
            return Math.max(findMaxProd(i - 1, LIMIT), findMaxProd(i - 1, LIMIT - weights[i]) + prices[i]);
        }
    }
}
