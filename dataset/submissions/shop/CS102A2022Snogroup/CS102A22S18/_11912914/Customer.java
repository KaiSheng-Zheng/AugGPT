import java.util.ArrayList;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    private static int time = 0;

    public Customer(String name, float wallet) {
        this.id = ++cnt;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet > product.getPrice()) {
            this.wallet -= product.getPrice();
            this.shoppingCart.add(product);
            product.setPurchaseTime(++time);
            product.setStore(store);
            product.getStore().transact(product, 0);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case Price: {
                this.shoppingCart.sort(SortBy.compareByPrice());
                break;
            }
            case Rating: {
                this.shoppingCart.sort(SortBy.compareByRating());
                break;
            }
            case PurchaseTime: {
                this.shoppingCart.sort(SortBy.compareByPurchaseTime());
                break;
            }
        }
        for (Product p : this.shoppingCart) {
            System.out.println(p);
        }
    }

    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            this.shoppingCart.remove(product);
            this.wallet += product.getPrice();
            Store store = product.getStore();
            store.transact(product, 1);
            return true;
        } else {
            return false;
        }
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Customer.cnt = cnt;
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

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public static int getTime() {
        return time;
    }

    public static void setTime(int time) {
        Customer.time = time;
    }
}
