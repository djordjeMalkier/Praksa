package david.zadaci.nedelja04;

import java.util.*;

public class MaxDobit {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Proizvod 1", 100, 80),
                new Product("Proizvod 2", 200, 100),
                new Product("Proizvod 3", 300, 150),
                new Product("Proizvod 4", 400, 385),
                new Product("Proizvod 5", 500, 125)));

        products.sort(Collections.reverseOrder(Comparator.comparingDouble(Product::getValue)));
        products.forEach(System.out::println);

        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextDouble()) return;

            double budget = scanner.nextDouble();
            List<Product> chosenProducts = solveFindMaxValue(products, budget);
            chosenProducts.forEach(System.out::println);
            System.out.println(sumList(chosenProducts));

        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }

    private static double sumList(List<Product> products) {
        double sum = 0;
        for (Product product: products) {
            sum += product.getValue();
        }
        return sum;
    }

    public static List<Product> solveFindMaxValue(List<Product> products, double budget) {
        return findMaxValue(products, budget, 0);
    }

    private static List<Product> findMaxValue(List<Product> products, double budget, int currentIndex) {
        //base
        if (budget <= 0 || currentIndex >= products.size()) {
            return new ArrayList<>();
        }

        //recursive call
        List<Product> profitWithElement = new ArrayList<>();
        if(products.get(currentIndex).getPrice() <= budget ) {
            profitWithElement = findMaxValue(products,
                    budget - products.get(currentIndex).getPrice(),
                    currentIndex + 1);
            profitWithElement.add(products.get(currentIndex));
        }

        //recursive call after excluding the element
        List<Product> profitWithoutElement = findMaxValue(products, budget, currentIndex + 1);
        if (sumList(profitWithElement) >= sumList(profitWithoutElement)) {
            return profitWithElement;
        } else {
            return profitWithoutElement;
        }
    }

}
