import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();// The list of purchased products;default is empty.
    private float wallet;

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
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
        if (store.hasProduct(product) && getWallet() >= product.getPrice()) {
            this.shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
       switch (sortMethod) {
            case Price:
                HashMap<Float, Product> priceToProduct = new HashMap<>();
                Float[] productPrice = new Float[shoppingCart.size()];

                for (int i = 0; i < shoppingCart.size(); i++) {
                    productPrice[i] = shoppingCart.get(i).getPrice();
                    priceToProduct.put(shoppingCart.get(i).getPrice(), shoppingCart.get(i));
                }

                Arrays.sort(productPrice,Collections.reverseOrder());

                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(priceToProduct.get(productPrice[i]));
                }
                break;

            case PurchaseTime:
                for (Product productInList : shoppingCart) {
                    System.out.println(productInList);
                }
                break;

            case Rating:
                HashMap<Float, Product> averageRatingToProduct = new HashMap<>();
                Float[] productAverageRating = new Float[shoppingCart.size()];

                for (int i = 0; i < shoppingCart.size(); i++) {
                    productAverageRating[i] = shoppingCart.get(i).getAvgRating();
                    averageRatingToProduct.put(shoppingCart.get(i).getAvgRating(), shoppingCart.get(i));
                }

                Arrays.sort(productAverageRating,Collections.reverseOrder());

                for (int i = 0; i < productAverageRating.length; i++) {
                    System.out.println(averageRatingToProduct.get(productAverageRating[i]));
                }

        }



    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            product.getBelongStore().transact(product,1);
            return true;
        } else {
            return false;
        }
    }
}


