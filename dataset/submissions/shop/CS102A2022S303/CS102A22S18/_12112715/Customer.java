import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private final int id; // unique for each customer and the value is set to cnt.
    private final String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }


    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            //people operation
            updateWallet(-product.getPrice());
            this.shoppingCart.add(product);
            //store operation
            store.transact(product, 0);
            product.setBelongTo(store);
            return true;
        } else {
            return false;
        }
    }


    public void viewShoppingCart(SortBy sortMethod) {
        if (shoppingCart.size() == 0) {
            return;
        }
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod.equals(SortBy.Rating)) {
            ArrayList<Product> newShoppingCart = new ArrayList<>(shoppingCart);
            for (int i = newShoppingCart.size(); i > 0; i--) {
                for (int j = 0; j < i - 1; j++) {
                    if (newShoppingCart.get(j).getAvgRating() > newShoppingCart.get(j + 1).getAvgRating()) {
                        Product tempProduct = newShoppingCart.get(j);
                        newShoppingCart.set(j, newShoppingCart.get(j + 1));
                        newShoppingCart.set(j + 1, tempProduct);
                    }
                }
            }
            for (Product product : newShoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)) {
            ArrayList<Product> newShoppingCart = new ArrayList<>(shoppingCart);
            for (int i = 0; i < newShoppingCart.size(); i++) {
                for (int j = i + 1; j < newShoppingCart.size(); j++) {
                    if (newShoppingCart.get(i).getPrice() > newShoppingCart.get(j).getPrice()) {
                        Product tempProduct = newShoppingCart.get(i);
                        newShoppingCart.set(i, newShoppingCart.get(j));
                        newShoppingCart.set(j, tempProduct);
                    }
                }
            }
            for (Product product : newShoppingCart) {
                System.out.println(product.toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.getBelongTo().transact(product, 1);
            return true;
        }
        return false;
    }
}
