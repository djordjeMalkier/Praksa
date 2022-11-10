package david.zadaci.nedelja04;

public class Product {
    private String name;
    private double price;
    private double value;

    public Product(String name, double price, double value) {
        this.name = name;
        this.price = price;
        this.value = value;
    }

    public double getPrice() {
        return price;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", value=" + value +
                '}';
    }
}
