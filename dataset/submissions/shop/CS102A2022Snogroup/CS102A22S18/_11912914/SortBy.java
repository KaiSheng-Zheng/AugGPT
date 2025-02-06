import java.util.Comparator;

public enum SortBy {
    PurchaseTime, Rating, Price;

    public static Comparator<Product> compareByRating() {
        return (o1, o2) -> {
            if (o1.getAvgRating() < o2.getAvgRating()) {
                return -1;
            } else if (o1.getAvgRating() == o2.getAvgRating()) {
                return o1.getPurchaseTime() - o2.getPurchaseTime();
            } else {
                return 1;
            }
        };
    }

    public static Comparator<Product> compareByPrice() {
        return ((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()));
    }

    public static Comparator<Product> compareByPurchaseTime() {
        return ((o1, o2) -> Integer.compare(o1.getPurchaseTime(), o2.getPurchaseTime()));
    }
}
