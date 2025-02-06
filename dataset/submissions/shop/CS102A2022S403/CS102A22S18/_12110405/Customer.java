import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private SortBy sortBy;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating > 0 && rating < 6) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        int s = shoppingCart.size();
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Price) {
            if (s > 2) {
                float[] price = new float[s];
                for (int i = 0; i < s; i++) {
                    price[i] = shoppingCart.get(i).getPrice();
                }
                Arrays.sort(price);
                for (int i = 0; i < s - 1; i++) {
                    if (price[i] == price[i + 1]) {
                        price[i + 1] = -1;
                    }
                }
                for (float i : price) {
                    for (Product product : shoppingCart) {
                        if (i == product.getPrice()) {
                            System.out.println(product.getPrice());
                        }
                    }
                }
            } else {
                System.out.println(shoppingCart.get(0));
            }

        } else if (sortMethod == SortBy.Rating) {
            if (s > 2) {
                float[] rate = new float[s];
                for (int i = 0; i < s; i++) {
                    rate[i] = shoppingCart.get(i).getAvgRating();
                }
                Arrays.sort(rate);
                for (int i = 0; i < s - 1; i++) {
                    if (rate[i] == rate[i + 1]) {
                        rate[i + 1] = -1;
                    }
                }
                for (float i : rate) {
                    for (Product product : shoppingCart) {
                        if (i == product.getAvgRating()) {
                            System.out.println(product.getAvgRating());
                        }
                    }
                }
            } else if (s==1){
                System.out.println(shoppingCart.get(0));
            }

        }
    }

    public boolean refundProduct(Product product) {
        return false;
    }
}