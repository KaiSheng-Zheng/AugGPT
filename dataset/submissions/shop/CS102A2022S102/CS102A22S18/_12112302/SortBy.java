import java.util.ArrayList;

public enum SortBy {
    PurchaseTime, Rating, Price;

    public void Sort(SortBy a, ArrayList<Product> shoppingCart) {
        ArrayList<Product> d = shoppingCart;
        switch (a) {
            case PurchaseTime:
                for (Product i :
                        d) {
                    System.out.println(i);
                }
                break;
            case Rating:
                for (int i = 0; i < d.size() - 1; i++) {
                    for (int j = 0; j < d.size() - 1 - i; j++) {
                        float m = d.get(j).getAvgRating();
                        float n = d.get(j + 1).getAvgRating();
                        if (m > n) {
                            Product p = d.get(j);
                            d.set(j, d.get(j + 1));
                            d.set(j + 1, p);
                        }
                    }
                }
                for (Product i :
                        d) {
                    System.out.println(i);
                }
                break;
            default:
                for (int i = 0; i < d.size() - 1; i++) {
                    for (int j = 0; j < d.size() - 1 - i; j++) {
                        float m = d.get(j).getPrice();
                        float n = d.get(j + 1).getPrice();
                        if (m > n) {
                            Product p = d.get(j);
                            d.set(j, d.get(j + 1));
                            d.set(j + 1, p);
                        }
                    }
                }
                for (Product i :
                        d) {
                    System.out.println(i);
                }
        }
    }
}
