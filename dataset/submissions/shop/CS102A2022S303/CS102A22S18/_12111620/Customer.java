import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
        cnt ++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet-product.getPrice() >= 0){
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            return true;
        }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod == SortBy.PurchaseTime){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }else if (sortMethod == SortBy.Rating){
            ArrayList<Float> Number = new ArrayList<>();

            for (Product value : shoppingCart) {
                Number.add(value.getAvgRating());
            }

            ArrayList<Integer> ratingNumber = new ArrayList<>();
            int max = 0;
            for (int i = 0; i < shoppingCart.size(); i++) {
                int j = 0;

                for (; j < shoppingCart.size(); j++) {
                    if (Number.get(j) > max){
                        max = j;
                    }
                }

                ratingNumber.add(max);
                max = 0;
                Number.set(j,0f);
            }

            ArrayList<Product> newShoppingCart = new ArrayList<>();

            for (int i = 0; i < shoppingCart.size(); i++) {
                newShoppingCart.add(shoppingCart.get(ratingNumber.get(i)));
            }

            for (int i = 0; i < shoppingCart.size(); i++) {
                shoppingCart.set(i,newShoppingCart.get(i));
            }

            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }else if (sortMethod == SortBy.Price){
            ArrayList<Float> Number = new ArrayList<>();

            for (Product value : shoppingCart) {
                Number.add(value.getPrice());
            }

            ArrayList<Integer> priceNumber = new ArrayList<>();
            int max = 0;
            for (int i = 0; i < shoppingCart.size(); i++) {
                int j = 0;

                for (; j < shoppingCart.size(); j++) {
                    if (Number.get(j) > max){
                        max = j;
                    }
                }

                priceNumber.add(max);
                max = 0;
                Number.set(j,0f);
            }

            ArrayList<Product> newShoppingCart = new ArrayList<>();

            for (int i = 0; i < shoppingCart.size(); i++) {
                newShoppingCart.add(shoppingCart.get(priceNumber.get(i)));
            }

            for (int i = 0; i < shoppingCart.size(); i++) {
                shoppingCart.set(i,newShoppingCart.get(i));
            }

            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
    }
}
