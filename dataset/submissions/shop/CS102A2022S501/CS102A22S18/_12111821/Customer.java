import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private HashMap<Product, Store> map = new HashMap<>();

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean hasThisProduct = store.getProductList().contains(product);

        if (hasThisProduct && wallet > product.getPrice()) {
            store.transact(product, 0);
            float cost = product.getPrice() * (-1);
            updateWallet(cost);
            shoppingCart.add(product);
            map(product, store);
            return true;
        } else {
            return false;
        }
    }


    public ArrayList<Product> copyList(ArrayList<Product> shoppingCart) {
        ArrayList<Product> cart = new ArrayList<>();
        cart.addAll(shoppingCart);
        return cart;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : copyList(shoppingCart)) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Price) {
            priceSort(copyList(shoppingCart));
        } else if (sortMethod == SortBy.Rating) {
            rateSort(copyList(shoppingCart));
        }
    }

    class priceComparator implements Comparator<Product>{
        @Override
        public int compare(Product product1, Product product2) {

            return Float.compare(product1.getPrice(),product2.getPrice());
        }
    }

    class rateComparator implements Comparator<Product>{
        @Override
        public int compare(Product product1, Product product2) {

            return Float.compare(product1.getAvgRating(),product2.getAvgRating());
        }
    }

    public void priceSort(ArrayList<Product> shoppingCart) {
        Collections.sort(shoppingCart, new priceComparator());
        for (Product product : shoppingCart) {
            System.out.println(product);
        }
    }

    public void rateSort(ArrayList<Product> shoppingCart) {
        Collections.sort(shoppingCart, new rateComparator());
        for (Product product : shoppingCart) {
            System.out.println(product);
        }
    }

    public void map(Product product, Store store) {
        map.put(product, store);
    }

    public Store recallStore (HashMap<Product, Store> map, Product product) {
        return map.get(product);
    }

    public boolean refundProduct(Product product) {
        boolean boughtProduct = shoppingCart.contains(product);

        if (boughtProduct) {
            recallStore(map, product).transact(product, 1);
            float cost = product.getPrice();
            updateWallet(cost);
            shoppingCart.remove(product);
            return true;
        } else {
            return false;
        }
    }

}
