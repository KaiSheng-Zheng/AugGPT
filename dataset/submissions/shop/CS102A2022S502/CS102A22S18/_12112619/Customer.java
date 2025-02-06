import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.wallet = wallet;
        this.name = name;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        } else {
            product.setRating(rating);
            return true;
        }
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            shoppingCart.add(product);
            store.transact(product, 0);
            updateWallet(-product.getPrice());
            return true;
        } else {
            return false;
        }
    }

    //problem: can't deal with the case with same price or same rating
    //feature of a HashMap: if a newly added object has a key identical with a previous one, new object will substitute the original one
    public void viewShoppingCart(SortBy sortMethod) {
        HashMap<Float, Product> mapRating = new HashMap<>();
        float[] rating = new float[shoppingCart.size()];
        HashMap<Float, Product> mapPrice = new HashMap<>();
        float[] price = new float[shoppingCart.size()];
        switch (sortMethod) {
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            case Rating:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    int j;
                    for (j = 0; mapRating.containsKey(shoppingCart.get(i).getAvgRating() + 0.00000001f * j); j++) {
                    }
                    mapRating.put(shoppingCart.get(i).getAvgRating() + 0.00000001f * j, shoppingCart.get(i));
                    rating[i] = shoppingCart.get(i).getAvgRating() + 0.00000001f * j;
                }
                Arrays.sort(rating);
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(mapRating.get(rating[i]));
                }
                break;
            case Price:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    int j;
                    for (j = 0; mapPrice.containsKey(shoppingCart.get(i).getPrice() + 0.000001f * j); j++) {
                    }
                    //add a little bit to distinguish two products with same price
                    mapPrice.put(shoppingCart.get(i).getPrice() + 0.000001f * j, shoppingCart.get(i));
                    price[i] = shoppingCart.get(i).getPrice() + 0.000001f * j;
                }
                Arrays.sort(price);
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(mapPrice.get(price[i]));
                }
                break;
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            this.wallet += product.getPrice();
            product.getBelongTo().transact(product, 1);
            return true;
        } else {
            return false;
        }
    }
}
