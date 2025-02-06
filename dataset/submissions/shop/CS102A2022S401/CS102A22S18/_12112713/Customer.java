

import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        shoppingCart = new ArrayList<>();
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) & wallet >= product.getPrice()) {
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }
        if (sortMethod == SortBy.Rating) {
            float[] avgRating = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                avgRating[i] = shoppingCart.get(i).getAvgRating();
            }
            ArrayList<Product> newCart = new ArrayList<>(shoppingCart);
            for (int i = 0; i < avgRating.length - 1; i++) {
                for (int j = 0; j < avgRating.length - 1 - i; j++) {
                    if (avgRating[j] > avgRating[j + 1]) {
                        Product temp = newCart.get(j);
                        newCart.set(j, newCart.get(j + 1));
                        newCart.set(j + 1, temp);
                    }
                }
            }
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }
        if (sortMethod == SortBy.Price) {
            float[] price = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                price[i] = shoppingCart.get(i).getPrice();
            }
            ArrayList<Product> newCart = new ArrayList<>(shoppingCart);
            for (int i = 0; i < price.length - 1; i++) {
                for (int j = 0; j < price.length - 1 - i; j++) {
                    if (price[j] > price[j + 1]) {
                        Product temp = newCart.get(j);
                        newCart.set(j, newCart.get(j + 1));
                        newCart.set(j + 1, temp);
                    }
                }
            }
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }
    }

    public boolean refundProduct(Product product) {
        return true;
    }
}
