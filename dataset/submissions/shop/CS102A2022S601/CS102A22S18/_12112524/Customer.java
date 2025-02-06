import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;

    }

    public boolean rateProduct(Product product, int rating) {
        if (1 <= rating && rating <= 5) {
            product.setRating(rating);
            return true;
        }
        return false;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            wallet -= product.getPrice();
            store.transact(product, 0);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;

            case Price:
                ArrayList<Product> priceArray = new ArrayList<>();
                priceArray.addAll(shoppingCart);
                for (int i = 0; i < priceArray.size()-1; i++) {
                    for (int j = 0; j < priceArray.size()-1-i; j++) {
                        if (priceArray.get(j).getPrice() > priceArray.get(j+1).getPrice()) {
                            Product temp = priceArray.get(j);
                            priceArray.set(j, priceArray.get(j+1));
                            priceArray.set(j+1, temp);
                        }
                    }
                }
                for (int i = 0; i < priceArray.size(); i++) {
                    System.out.println(priceArray.get(i));
                }
                break;

            case Rating:
                ArrayList<Product> ratingArray = new ArrayList<>();
                ratingArray.addAll(shoppingCart);
                //bubble sort
                for (int i = 0; i < ratingArray.size()-1; i++) {
                    for (int j = 0; j < ratingArray.size()-1-i; j++) {
                        if (ratingArray.get(j).getAvgRating() > ratingArray.get(j+1).getAvgRating()) {
                            Product temp = ratingArray.get(j);
                            ratingArray.set(j, ratingArray.get(j+1));
                            ratingArray.set(j+1, temp);
                        }
                    }
                }
                for (int i = 0; i < ratingArray.size(); i++) {
                    System.out.println(ratingArray.get(i));
                }
                break;
        }
    }

    public boolean refundProduct(Product product) {
        return true;
    }
}