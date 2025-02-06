import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.

    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private int order = 0;

    private Comparator<Product> byPurchaseTime = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getOrder() - o2.getOrder();
        }
    };

    private Comparator<Product> byRating = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            if (Math.abs(o1.getAvgRating() - o2.getAvgRating()) < 1e-6) {
                return o1.getOrder() - o2.getOrder();
            } else if (o1.getAvgRating() > o2.getAvgRating()) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    private Comparator<Product> byPrice = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            if (Math.abs(o1.getPrice() - o2.getPrice()) < 1e-6) {
                return o1.getOrder() - o2.getOrder();
            } else if (o1.getPrice() > o2.getPrice()) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    public Customer(String name, float wallet) {
        this.id = ++cnt;
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
        if (store.hasProduct(product)) {
            if (this.wallet > product.getPrice()) {
                shoppingCart.add(product);
                updateWallet(-product.getPrice());
                store.transact(product, 0);
                product.setOrder(++this.order);
                product.setProductStore(store);
                return true;
            }
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.Rating) {
            shoppingCart.sort(byRating);
        } else if (sortMethod == SortBy.Price) {
            shoppingCart.sort(byPrice);
        }
        for (Product p : shoppingCart) {
            System.out.println(p);
        }
    }

    public boolean hasProduct(Product product) {
        for (Product p : this.shoppingCart) {
            if (p == product) {
                return true;
            }
        }
        return false;
    }

    public boolean removeProduct(Product product) {
        if (!this.hasProduct(product)) {
            return false;
        }
        this.shoppingCart.remove(product);
//        for (int i = 0; i < this.shoppingCart.size(); i++) {
//            if (this.shoppingCart.get(i).getId() == product.getId()) {
//                this.shoppingCart.remove(i);
//            }
//        }
        return true;
    }

    public boolean refundProduct(Product product) {
        if (this.hasProduct(product)) {
            this.removeProduct(product);
            updateWallet(product.getPrice());
            product.getProductStore().transact(product, 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Product product_mouse = new Product("mouse", Math.round(100.155f * 100) / 100.0f);
        Product product_table = new Product("table", Math.round(100.156f * 100) / 100.0f);
        Product product_phone = new Product("phone", Math.round(100.157f * 100) / 100.0f);
        Product product_laptop = new Product("laptop1", Math.round(100.158f * 100) / 100.0f);
        Product product_apple = new Product("apple", Math.round(100.158f * 100) / 100.0f);

        Store store1 = new Store("s1");
        store1.addProduct(product_laptop);
        store1.addProduct(product_table);
        store1.addProduct(product_mouse);
        store1.addProduct(product_phone);
        store1.addProduct(product_apple);

        Customer alice = new Customer("Alice", 20000);
        alice.purchaseProduct(store1, product_laptop);
        alice.purchaseProduct(store1, product_table);
        alice.purchaseProduct(store1, product_mouse);
        alice.purchaseProduct(store1, product_phone);

        alice.refundProduct(product_mouse);
        alice.purchaseProduct(store1, product_apple);
        alice.purchaseProduct(store1, product_mouse);

        alice.viewShoppingCart(SortBy.PurchaseTime);
    }
}
