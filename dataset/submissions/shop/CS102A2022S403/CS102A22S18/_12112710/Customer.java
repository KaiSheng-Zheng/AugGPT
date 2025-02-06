import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getWallet() {
        return wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }


    
    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public void updateCart(Product product) {
        this.shoppingCart.add(product);
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.getWallet() >= product.getPrice()) {
            store.transact(product, 0);
            updateCart(product);
            updateWallet(-product.getPrice());
            return true;
        } else return false;
    }


     private class SortP implements Comparator<Product> {
        @Override
        public int compare(Product product1, Product product2) {
            if (product2.getPrice() <= product1.getPrice()) {
                return 1;
            } else return -1;
        }
    }


    private class SortR implements Comparator<Product> {
        @Override
        public int compare(Product product1, Product product2) {
            if (product2.getAvgRating() <= product1.getAvgRating()) {
                return 1;
            } else return -1;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }

        }

        if (sortMethod.equals(SortBy.Rating)) {
            Comparator sp = new SortR();
            Product[] products = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                products[i] = shoppingCart.get(i);
            }
            Arrays.sort(products, sp);
            for (int i = 0; i < products.length; i++) {
                System.out.println(products[i].toString());
            }
        }

        if (sortMethod.equals(SortBy.Price)) {
            Comparator sr = new SortP();
            Product[] products = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                products[i] = shoppingCart.get(i);
            }
            Arrays.sort(products, sr);
            for (int i = 0; i < products.length; i++) {
                System.out.println(products[i].toString());
            }
        }
    }


    public boolean refundProduct(Product product) {
        return true;
    }


}

