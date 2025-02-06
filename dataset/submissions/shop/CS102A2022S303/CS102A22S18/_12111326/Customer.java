import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.id = ++cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (1 <= rating && rating <= 5) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        this.wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            store.transact(product, 0);
            wallet = wallet - product.getPrice();
            product.store = store;
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }

        if (sortMethod.equals(SortBy.Rating)) {
            ArrayList<Product> newProducts = new ArrayList<>(shoppingCart.size());
            for (int i = 0; i < shoppingCart.size(); i++) {
                newProducts.add(shoppingCart.get(i));
            }
            newProducts.sort(new SortByRating());
            for (Product newProduct : newProducts) {
                System.out.println(newProduct.toString());
            }
        }


        if (sortMethod.equals(SortBy.Price)) {
            ArrayList<Product> newProducts = new ArrayList<>(shoppingCart.size());
            for (int i = 0; i < shoppingCart.size(); i++) {
                newProducts.add(shoppingCart.get(i));
            }
            newProducts.sort(new SortByPrice());
            for (Product newProduct : newProducts) {
                System.out.println(newProduct.toString());
            }
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

    class SortByPrice implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return Float.compare(o1.getPrice() , o2.getPrice());
        }
    }

    class SortByRating implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return Float.compare(o1.getAvgRating() , o2.getAvgRating());
        }
    }
}

