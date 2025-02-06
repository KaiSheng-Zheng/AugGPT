import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet;

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
        this.wallet += amount;
    }


    public boolean hasProduct(Product product) {
        boolean hasProduct = false;
        for (Product item : shoppingCart) {
            if (item.equals(product)) {
                hasProduct = true;
                break;
            }
        }

        return hasProduct;
    }

    public boolean removeProduct(Product product) {
        boolean deleted = false;

        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).equals(product)) {
                shoppingCart.remove(i);
                deleted = true;
                break;
            }
        }

        return deleted;
    }


    public void viewShoppingCart(SortBy sortMethod) {
        HashMap<Float, Product> finalResult = new HashMap<>();


        for (int i = 0; i < shoppingCart.size(); i++) {
            Product item = shoppingCart.get(i);
            switch (sortMethod) {
                case PurchaseTime:
                    finalResult.put((float) i, item);
                    break;
                case Price:
                    // deal with the situation that many products have the same price
                    finalResult.put(item.getPrice() * 10000 + i, item);
                    break;
                case Rating:
                    // deal with the situation that many products have the same rating
                    finalResult.put(item.getAvgRating() * 10000 + i, item);
                    break;
            }
        }
        ArrayList<Float> sortedKeys = new ArrayList<Float>(finalResult.keySet());
        sortedKeys.sort(Comparator.naturalOrder());

        for (float key : sortedKeys) {
            System.out.println(finalResult.get(key).toString());
        }

    }


    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            this.updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product, 0);


            return true;
        } else {
            return false;
        }
    }


    public boolean refundProduct(Product product) {
        if (!hasProduct(product) || product.getSoldFrom() == null)
            return false;

        product.getSoldFrom().transact(product, 1);
        removeProduct(product);
        updateWallet(+product.getPrice());

        return true;
    }
}
