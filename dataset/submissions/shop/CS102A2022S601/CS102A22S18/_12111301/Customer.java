import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        id = ++cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            this.shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.removeProduct(product);
            store.setIncome(store.getIncome() + product.getPrice());
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Rating:
                float[] rateSort = new float[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    rateSort[i] = shoppingCart.get(i).getAvgRating();
                }
                Arrays.sort(rateSort);
                for (int i = 0; i < shoppingCart.size(); i++) {
                    float rate = rateSort[i];
                    if (i > 0 && rateSort[i - 1] == rateSort[i]) continue;
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (rate == shoppingCart.get(j).getAvgRating()) {
                            System.out.println(shoppingCart.get(j).toString());
                        }
                    }
                }
                break;
            case Price:
                float[] priceSort = new float[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    priceSort[i] = shoppingCart.get(i).getPrice();
                }
                Arrays.sort(priceSort);
                for (int i = 0; i < shoppingCart.size(); i++) {
                    float price = priceSort[i];
                    if (i > 0 && priceSort[i] == priceSort[i - 1]) continue;
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (price == shoppingCart.get(j).getPrice()) {
                            System.out.println(shoppingCart.get(j).toString());
                        }
                    }
                }
                break;
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet = wallet + product.getPrice();
            product.store.transact(product, 1);
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}