import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    HashMap<Product,Store> map = new HashMap<>();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public boolean hasProduct(Product product) {
        return shoppingCart.contains(product);
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) return false;
        else {
            shoppingCart.add(product);
            return true;
        }
    }

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating <= 5 && rating >= 0) {
            product.setRating(rating);
            return true;
        } else return false;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            map.put(product,store);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> temp = new ArrayList<>(shoppingCart);
        if (sortMethod == SortBy.Price) {
            for (int i = 0; i < temp.size() - 1; i++) {
                for (int j = 0; j < temp.size() - 1 - i; j++) {
                    if (temp.get(j).getPrice() > temp.get(j + 1).getPrice()) {
                        Product inProduct = temp.get(j + 1);
                        temp.set(j + 1, temp.get(j));
                        temp.set(j, inProduct);
                    }
                }
            }
            for (int i = 0; i < temp.size(); i++) {
                System.out.println(temp.get(i));
            }
        }
        if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < temp.size() - 1; i++) {
                for (int j = 0; j < temp.size() - 1 - i; j++) {
                    if (temp.get(j).getAvgRating() > temp.get(j + 1).getAvgRating()) {
                        Product inProduct = temp.get(j + 1);
                        temp.set(j + 1, temp.get(j));
                        temp.set(j, inProduct);
                    }
                }
            }
            for (int i = 0; i < temp.size(); i++) {
                System.out.println(temp.get(i));
            }
        }
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < temp.size(); i++) {
                System.out.println(temp.get(i));

            }

        }
    }

    public boolean refundProduct(Product product) {
        if (hasProduct(product)) {
            int position= getShoppingCart().indexOf(product);
            map.get(product).transact(product,1);
            updateWallet(product.getPrice());
            this.shoppingCart.remove(product);
            return true;
        } else return false;

    }
}
