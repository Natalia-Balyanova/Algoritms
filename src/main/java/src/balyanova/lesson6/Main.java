package src.balyanova.lesson6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Создать и запустить программу для построения двоичного дерева. \n" +
                "В цикле построить 20 деревьев с глубиной в 4 уровней. \n" +
                "Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int. \n" +
                "Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -25 до 25.");
        createTree(20,4,-25,25);

        System.out.println();
    }

    public static void createTree (int treeQuantity, int maxLevelNumber, int lowRandomLimit, int highRandomLimit){
        int balancedTreeQuantity = 0;
        int nonBalancedTreeQuantity;
        for (int i = 1; i <= treeQuantity; i++) {
            TreeImpl <Integer> tree = new TreeImpl<>(maxLevelNumber);
            for (int j = 0; j <= (Math.pow(2,maxLevelNumber)-1); j++) {
                tree.add((int) (Math.random()*(highRandomLimit-lowRandomLimit) + lowRandomLimit));
            }
            if (isBalanced(tree.getRoot())){
                balancedTreeQuantity++;
            }
            tree.display();
        }

        int percent = balancedTreeQuantity * 100 / treeQuantity;
        nonBalancedTreeQuantity = 100 - balancedTreeQuantity;
        int nonBalancedPercent = 100 - percent;

        System.out.println("Количество сбалансированных деревьев = " + balancedTreeQuantity + "." +
                " Процент сбалансированных деревьев = " + percent + "%."
                + " Количество несбалансированных деревьев = " + nonBalancedTreeQuantity +
                ". Процент несбалансирвоанных деревьев = " + nonBalancedPercent);
    }

    public static boolean isBalanced(Node <Integer> node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node <Integer> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

//        Tree<Integer> tree = new TreeImpl<>();
//
//        tree.add(60);
//        tree.add(50);
//        tree.add(66);
//        tree.add(40);
//        tree.add(55);
//        tree.add(70);
//        tree.add(31);
//        tree.add(45);
//        tree.add(42);
//        tree.add(43);
//        tree.add(69);
//        tree.add(67);
//        tree.add(68);
//        tree.add(81);

//        tree.display();
//
//        tree.remove(40);
//
//        tree.display();

//        tree.traverse(Tree.TraversMode.IN_ORDER);
//        tree.traverse(Tree.TraversMode.PRE_ORDER);
//        tree.traverse(Tree.TraversMode.POST_ORDER);
}