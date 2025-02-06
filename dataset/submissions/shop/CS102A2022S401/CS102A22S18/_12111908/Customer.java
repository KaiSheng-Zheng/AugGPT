import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Collections.*;

public class Customer {
    static int countBuy = 0;
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private ArrayList<Product> shoppingTime = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        id = ++cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            wallet -= product.getPrice();
            product.store = store;
            shoppingCart.add(product);
            shoppingTime.add(product);
            product.buyTime = ++countBuy;
            store.transact(product,0);
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.buyTime < o2.buyTime) return 0;
                    else return 1;
                }
            });
        } else {
            if (sortMethod == SortBy.Rating) {
                Collections.sort(shoppingCart, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getAvgRating() > o2.getAvgRating()) return 1;
                        else if (o1.getAvgRating() < o2.getAvgRating()) return -1;
                        else {
                            if (o1.buyTime > o2.buyTime) return 1;
                            else return -1;
                        }
                    }
                });
            } else if (sortMethod == SortBy.Price) {
                Collections.sort(shoppingCart, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice() > o2.getPrice()) return 1;
                        else if (o1.getPrice() < o2.getPrice()) return -1;
                        else {
                            if (o1.buyTime > o2.buyTime) return 1;
                            else return -1;
                        }
                    }
                });
            }
        }
        for (int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i));
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            product.store.transact(product,1);
            this.wallet += product.getPrice();
            shoppingCart.remove(product);
            shoppingTime.remove(product);
            return true;
        } else return false;

    }
}