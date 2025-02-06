import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private HashMap<Product, Store> match=new HashMap<>();

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        Customer.cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean isStoreContains = store.hasProduct(product);
        boolean isMoneyEnough = wallet >= product.getPrice();
        if (isMoneyEnough && isStoreContains) {
            wallet -= product.getPrice();
            shoppingCart.add(product);
            match.put(product, store);
            store.transact(product,0);
        }
        return isMoneyEnough && isStoreContains;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product p : shoppingCart) {
                System.out.println(p);
            }
        }

        if (sortMethod == SortBy.Rating) {
            ArrayList<Product> copy = new ArrayList<>(shoppingCart);
            Collections.sort(copy, new Comparator<Product>() {
                @Override

                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating() > o2.getAvgRating()) {
                        return 1;
                    } else if (o1.getAvgRating() == o2.getAvgRating()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
            for (Product p : copy) {
                System.out.println(p);
            }
        }

        if (sortMethod == SortBy.Price) {
            ArrayList<Product> copy = new ArrayList<>(shoppingCart);
            Collections.sort(copy, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice() > o2.getPrice()) {
                        return 1;
                    } else if (o1.getPrice() == o2.getPrice()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
            for (Product p : copy) {
                System.out.println(p);
            }
        }
    }

    public boolean refundProduct(Product product) {
        boolean isMatch = match.containsKey(product);
        if (isMatch) {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            match.get(product).transact(product,1);
            match.remove(product);
        }
        return isMatch;
    }
}


