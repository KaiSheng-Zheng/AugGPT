import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    HashMap<Product,Store> hashMap = new HashMap<>();

    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating < 6 && rating > 0) {
            product.setRating(rating);
            return true;
        } else return false;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.removeProduct(product);
            store.transact(product,0);
            hashMap.put(product,store);
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> newShoppingCart=new ArrayList<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            newShoppingCart.add(shoppingCart.get(i));
        }
        if (sortMethod == SortBy.Price) {
            for (int i = 0; i < newShoppingCart.size() - 1; i++) {
                            for (int j = 0; j < newShoppingCart.size() - 1; j++) {
                                if (newShoppingCart.get(j).getPrice() > newShoppingCart.get(j + 1).getPrice()) {
                                    Product temp = newShoppingCart.get(j);
                                    newShoppingCart.set(j, newShoppingCart.get(j + 1));
                                    newShoppingCart.set(j + 1, temp);
                    }
                }
            }
        }
        if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < newShoppingCart.size() - 1; i++) {
                for (int j = 0; j < newShoppingCart.size() - 1; j++) {
                    if (newShoppingCart.get(j).getAvgRating() > newShoppingCart.get(j + 1).getAvgRating()) {
                        Product temp = newShoppingCart.get(j);
                        newShoppingCart.set(j, newShoppingCart.get(j + 1));
                        newShoppingCart.set(j + 1, temp);
                    }
                }
            }
        }
        for (int i = 0; i < newShoppingCart.size(); i++) {
            System.out.println(newShoppingCart.get(i).toString());
        }
    }

    public boolean refundProduct(Product product) {
        boolean flag = false;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i)==product) {
                updateWallet(product.getPrice());
                shoppingCart.remove(product);
              hashMap.get(product).transact(product,1);
              flag = true;
            }
        }
        return flag;
    }
}

