import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    HashMap<Product,Store> re = new HashMap<>();

    public Customer(String name, float wallet) {
        cnt = cnt + 1;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating <= 5 && rating >= 1) {
            product.setRating(rating);
            return true;
        } else return false;
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.setIncome(store.getIncome() + product.getPrice());
            store.removeProduct(product);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            re.put(product,store);
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        } else if (sortMethod == SortBy.Price) {
            ArrayList<Product> list = new ArrayList<>(shoppingCart);
            list.sort(new Comparator<Product>() {
                @Override
                public int compare(Product p1, Product p2) {
                    return Float.compare(p1.getPrice(), p2.getPrice());
                }
            });
            for (Product product : list) {
                System.out.println(product);
            }
        } else {
            ArrayList<Product> list = new ArrayList<>(shoppingCart);
            list.sort(new Comparator<Product>() {
                @Override
                public int compare(Product p1, Product p2) {
                    return Float.compare(p1.getAvgRating(), p2.getAvgRating());
                }
            });
            for (Product product : list) {
                System.out.println(product);
            }

        }
    }
        public boolean refundProduct (Product product){
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (product.getId() == shoppingCart.get(i).getId()) {
                    updateWallet(product.getPrice());
                    shoppingCart.remove(product);
                    re.get(product).transact(product,1);
                    return true;
                }
            }
            return false;
        }
    }