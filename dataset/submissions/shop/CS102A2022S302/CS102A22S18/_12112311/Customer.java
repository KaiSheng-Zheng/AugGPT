import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private HashMap<Product, Store> map = new HashMap<>();

    public static void main(String[] args) {

    }

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        if (amount >= 0) {
            wallet += amount;
        } else {
            wallet += amount;
        }
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            wallet -= product.getPrice();
            store.transact(product, 0);
            map.put(product, store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> newProducts = new ArrayList<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            newProducts.add(shoppingCart.get(i));
        }
        switch (sortMethod) {
            case PurchaseTime:
                for (Product p : newProducts) {
                    System.out.println(p);
                }
                break;
            case Rating:
                newProducts.sort(new SortByRating());

                for (Product p : newProducts) {
                    System.out.println(p);
                }
                break;
            case Price:
                newProducts.sort(new SortByPrice());
                for (Product p : newProducts) {
                    System.out.println(p);
                }
                break;
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            this.wallet += product.getPrice();
            map.get(product).transact(product, 1);
            return true;
        } else {
            return false;
        }
    }
}

class SortByRating implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getAvgRating() >o2.getAvgRating()) {
            return 1;
        } else if (o1.getAvgRating() == o2.getAvgRating() ) {
            return 0;
        } else {
            return -1;
        }
    }
}

class SortByPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}


