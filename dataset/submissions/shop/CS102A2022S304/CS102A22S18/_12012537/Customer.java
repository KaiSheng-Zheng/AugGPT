import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products;default is empty.

    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        boolean t = product.setRating(rating);
        return t;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            shoppingCart.add(product);
            this.wallet -= product.getPrice();
            store.transact(product, 0);
            product.in=store;
//    store.removeProduct(product);//if store should be renew
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] temp1 = new Product[shoppingCart.size()];
        for (int i = 0; i < shoppingCart.size(); i++) {
            temp1[i] = shoppingCart.get(i);
        }
        if (sortMethod == SortBy.Price) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i; j < shoppingCart.size(); j++) {
                    if (temp1[i].getPrice() > temp1[j].getPrice()) {
                        Product temp = temp1[i];
                        temp1[i] = temp1[j];
                        temp1[j] = temp;
                    }
                }
            }
        } else if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i; j < shoppingCart.size(); j++) {
                    if (temp1[i].getAvgRating() > temp1[j].getAvgRating()) {
                        Product temp = temp1[i];
                        temp1[i] = temp1[j];
                        temp1[j] = temp;
//                        shoppingCart.set(i, shoppingCart.get(j));
//                        shoppingCart.set(j, temp);
                    }
                }
            }
        }
        for (Product product : temp1) {
            System.out.println(product);
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            product.in.transact(product,1);

            return true;
        } else {
            return false;
        }
    }


}

