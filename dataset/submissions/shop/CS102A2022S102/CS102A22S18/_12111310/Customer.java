import java.util.*;
import java.lang.*;

public class Customer {
    private static int cnt;
    private final int id;
    private final String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Product> shoppingCartR=new ArrayList<>();
    private ArrayList<Product> shoppingCartP=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (1 <= rating && rating <= 5) {
            product.setRating(rating);
            return true;
        }
        return false;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean enough = store.hasProduct(product) && wallet >= product.getPrice();
        if (enough) {
            store.transact(product, 0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
        }
        return enough;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (Product x : shoppingCart) {
                    System.out.println(x);
                }
                break;
            case Rating:
                float[] compare = new float[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (shoppingCart.get(i).getAvgRating() > shoppingCart.get(j).getAvgRating()) {
                            compare[i]++;
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < compare.length; j++) {
                        if (compare[j]==i){
                            shoppingCartR.add(shoppingCart.get(j));
                        }
                    }
                }
                for (Product x : shoppingCartR) {
                    System.out.println(x);
                }
                break;
            case Price:
                float[] compare1 = new float[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (shoppingCart.get(i).getPrice() > shoppingCart.get(j).getPrice()) {
                            compare1[i]++;
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < compare1.length; j++) {
                        if (compare1[j]==i){
                            shoppingCartP.add(shoppingCart.get(j));
                        }
                    }
                }
                for (Product x : shoppingCartP) {
                    System.out.println(x);
                }
                break;
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }
        return false;
    }
}