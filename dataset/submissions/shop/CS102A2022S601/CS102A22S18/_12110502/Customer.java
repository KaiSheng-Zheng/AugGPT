import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Comparator.naturalOrder;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.id = cnt;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else return false;
    }

    public void updateWallet(float amount) {
        Float opp = amount;
        if (this.getWallet() >= amount) {
            wallet -= amount;
        } else wallet += amount;//??????
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void updateshoppingCart(Product product, Boolean Buy) {
        if (Buy) {
            getShoppingCart().add(product);
        } else getShoppingCart().remove(product);
    }

    public float getWallet() {
        return wallet;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product) && this.getWallet() >= product.getPrice()) {
            updateWallet(product.getPrice());
            updateshoppingCart(product, true);
            store.transact(product,0);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (Product product : this.getShoppingCart()) {
                    System.out.println(product.toString());
                }
                break;
            case Rating:
                ArrayList<Float> raTing = new ArrayList<>();
                for (Product product : this.getShoppingCart()) {
                    raTing.add(product.getAvgRating());
                }
                raTing.sort(naturalOrder());
                for (int i = 0; i < raTing.size(); i++) {
                    for (Product product : this.getShoppingCart()) {
                        if (raTing.get(i) == product.getAvgRating()) {
                            System.out.println(product.toString());
                        }
                    }
                }
                break;
            case Price:
                ArrayList<Float> priCe = new ArrayList<>();
                for (Product product : this.getShoppingCart()) {
                    priCe.add(product.getPrice());
                }
                priCe.sort(naturalOrder());
                for (int i = 0; i < priCe.size(); i++) {
                    for (Product product : this.getShoppingCart()) {
                        if (priCe.get(i) == product.getPrice()) {
                            System.out.println(product.toString());
                        }
                    }
                }
                break;
        }
    }

    public boolean refundProduct(Product product) {
        if (this.getShoppingCart().contains(product)) {
            updateshoppingCart(product, false);
            updateWallet(-product.getPrice());
            //?????
//product.getStore.update
Store.getStore(product).transact(product,1);
            return true;
        } else {
            return false;
        }
    }


}
