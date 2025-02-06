import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id = 0;  // unique for each customer and the value is set to cnt.
    private String name = "";
    private ArrayList<Product> shoppingCart = new ArrayList<Product>(); // The list of purchased products; default is empty.
    private float wallet = 0;

    public Customer(String name, float wallet) {
        cnt = cnt + 1;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
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
        wallet =(float) wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product)) {
            if (wallet >= product.getPrice()) {
                store.removeProduct(product);
                shoppingCart.add(product);
                wallet = (float) wallet - product.getPrice();
                store.getincome( product.getPrice());
                return true;
            } else return false;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        int x = 0;
        if(shoppingCart!=null) {
            if (sortMethod == SortBy.PurchaseTime) {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
            } else if (sortMethod == SortBy.Price) {
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    if (shoppingCart.get(i).getPrice() == shoppingCart.get(i + 1).getPrice()) {
                        x++;
                    }
                }
                if (x == shoppingCart.size() - 1) {
                    for (int i = 0; i < shoppingCart.size(); i++) {
                        System.out.println(shoppingCart.get(i).toString());
                    }
                } else {
                    ComparePrice ca = new ComparePrice();
                    Collections.sort(shoppingCart, ca);
                    for (int i = 0; i < shoppingCart.size(); i++) {
                        System.out.println(shoppingCart.get(i).toString());
                    }
                }
            } else if (sortMethod == SortBy.Rating) {
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    if (shoppingCart.get(i).getAvgRating() == shoppingCart.get(i + 1).getAvgRating()) {
                        x++;
                    }
                }
                if (x == shoppingCart.size() - 1) {
                    for (int i = 0; i < shoppingCart.size(); i++) {
                        System.out.println(shoppingCart.get(i).toString());
                    }
                } else {
                    CompareR cb = new CompareR();
                    Collections.sort(shoppingCart, cb);
                    for (int i = 0; i < shoppingCart.size(); i++) {
                        System.out.println(shoppingCart.get(i).toString());
                    }
                }
            }
        }
    }

    public boolean refundProduct(Product product) {
        return false;
    }

    public class ComparePrice implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            if (p1.getPrice() > p2.getPrice())
                return 1;
            else return -1;
        }
    }

    public class CompareR implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            if (p1.getAvgRating() > p2.getAvgRating())
                return 1;
            else return -1;
        }
    }

}

