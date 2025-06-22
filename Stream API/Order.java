import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        Map<String, List<Order>> grouping = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct));

        Map<String, Double> spisok = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct,
                        Collectors.summingDouble(Order::getCost)));


        List<Map.Entry<String, Double>> sorted = new ArrayList<>(spisok.entrySet());

        sorted.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        List<Map.Entry<String, Double>> top3 = sorted.stream()
                .limit(3)
                .toList();

        System.out.println("3 самых дорогих продукта:");
        for (var entry : top3) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "$");
        }
    }
}

class Order {
    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }
}
