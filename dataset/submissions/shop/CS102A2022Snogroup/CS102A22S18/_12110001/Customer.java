import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
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
        if (rating <= 5 && rating >= 1) {
            product.setRating(rating);
            return true;
        }
        return false;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.transact(product, 0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            return true;
        }
        return false;
    }

    public boolean refundProduct(Product product){
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> products = new ArrayList<>(shoppingCart);
        switch (sortMethod) {
            case PurchaseTime:
                break;
            case Price:
                products.sort(new SortByPrice());
                break;
            case Rating:
                products.sort(new SortByRate());
                break;
        }
        for (Product p:products
             ) {
            System.out.println(p);
        }
    }



}

class SortByPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}

class SortByRate implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getAvgRating() - o2.getAvgRating());
    }
}



