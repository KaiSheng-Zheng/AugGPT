import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Store> stores;

    public Customer(String name, float wallet) {
        cnt += 1;
        id = cnt;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
        this.stores = new ArrayList<>();
        this.wallet = wallet;
    }


    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            store.transact(product, 0);
            wallet -= product.getPrice();
            stores.add(store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> s = new ArrayList<>(shoppingCart);
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : s) {
                System.out.println(product);
            }
        }
        if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < s.size() - 1; i++) {
                for (int j = 0; j < s.size() - 1 - i; j++) {
                    Product temp;
                    if (s.get(j).getAvgRating() > s.get(j + 1).getAvgRating()) {
                        temp = s.get(j);
                        s.add(j, s.get(j + 1));
                        s.remove(j + 1);
                        s.add(j + 1, temp);
                        s.remove(j + 2);
                    }
                }
            }
            for (Product product : s) {
                System.out.println(product);
            }
        }
        if (sortMethod == SortBy.Price) {
            for (int i = 0; i < s.size() - 1; i++) {
                for (int j = 0; j < s.size() - 1 - i; j++) {
                    Product temp;
                    if (s.get(j).getPrice() > s.get(j + 1).getPrice()) {
                        temp = s.get(j);
                        s.add(j, s.get(j + 1));
                        s.remove(j + 1);
                        s.add(j + 1, temp);
                        s.remove(j + 2);
                    }
                }
            }
            for (Product product : s) {
                System.out.println(product);
            }
        }
        s.clear();
    }

    public boolean refundProduct(Product product) {
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i) == product) {
                stores.get(i).transact(product, 1);
                shoppingCart.remove(shoppingCart.get(i));
                updateWallet(product.getPrice());
                stores.remove(stores.get(i));
                return true;
            }
        }
        return false;
    }
}

class SortByRating implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getAvgRating() - o2.getAvgRating());
    }
}

class SortByPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}


