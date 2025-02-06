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
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            product.setRating(rating);
            return true;
        }else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            wallet -= product.getPrice();
            shoppingCart.add(product);
            store.transact(product, 0);
            product.store = store;
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] products = new Product[shoppingCart.size()];
        for (int i = 0; i < products.length; i++) {
            products[i] = shoppingCart.get(i);
        }

        switch (sortMethod) {
            case Price:
                Arrays.sort(products, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice() - o2.getPrice() < 0) {
                            return -1;
                        }else if (o1.getPrice() - o2.getPrice() > 0) {
                            return 1;
                        }else {
                            return 0;
                        }
                    }
                });
                break;
            case Rating:
                Arrays.sort(products, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getAvgRating() - o2.getAvgRating() < 0) {
                            return -1;
                        }else if (o1.getAvgRating() - o2.getAvgRating() > 0) {
                            return 1;
                        }else {
                            return 0;
                        }
                    }
                });
                break;
        }

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            product.store.transact(product, 1);
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Customer alice = new Customer("Alice", 20000);
        Store store1 = new Store("a");
        Store store2 = new Store("b");
        Store store3 = new Store("c");

        Product product_laptop = new Product("laptop", 1.25f);
        Product product_table = new Product("table", 1.33f);
        Product product_mouse = new Product("mouse", 9f);
        Product product_phone = new Product("phone", 0.2f);

        store1.addProduct(product_laptop);
        store1.addProduct(product_table);
        store2.addProduct(product_mouse);
        store3.addProduct(product_phone);

        alice.purchaseProduct(store1, product_laptop);
        alice.purchaseProduct(store1, product_table);
        alice.purchaseProduct(store2, product_mouse);
        alice.purchaseProduct(store3, product_phone);

        alice.viewShoppingCart(SortBy.Price);
    }
}

enum SortBy {
    PurchaseTime, Rating, Price
}