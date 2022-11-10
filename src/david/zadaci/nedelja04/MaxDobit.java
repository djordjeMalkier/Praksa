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
            System.out.println(solveFindMaxValue(products, budget));

        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }

    private static double sumStr(String s) {
        double sum = 0;
        for(String num: s.split(" "))
            sum += Double.parseDouble(num);
        return sum;
    }

    public static String solveFindMaxValue(List<Product> products, double budget) {
        double[] profits = new double[products.size()];
        double[] weights = new double[products.size()];
        for (int i = 0; i < products.size(); i++) {
            profits[i] = products.get(i).getValue();
            weights[i] = products.get(i).getPrice();
        }
        return findMaxValue(profits, weights, budget, 0);
    }

    private static String findMaxValue(double[] profits, double[] weights, double budget, int currentIndex) {
        //base
        if (budget <= 0 || currentIndex >= profits.length) {
            return " ";
        }

        //recursive call
        String profitWithElement = " ";
        if(weights[currentIndex] <= budget ) {
            profitWithElement = profits[currentIndex] + " " +
                    findMaxValue(profits, weights, budget - weights[currentIndex], currentIndex + 1);
        }

        //recursive call after excluding the element
        String profitWithoutElement = findMaxValue(profits, weights, budget, currentIndex + 1);
        if (sumStr(profitWithElement) >= sumStr(profitWithoutElement)) {
            return profitWithElement;
        } else {
            return profitWithoutElement;
        }
    }

}
