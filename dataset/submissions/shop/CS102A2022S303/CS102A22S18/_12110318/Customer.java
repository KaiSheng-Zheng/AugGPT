import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        cnt += 1;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            product.setStore(store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        } else if (sortMethod == SortBy.Rating) {
            Product[] tmp = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                tmp[i] = shoppingCart.get(i);
            }
            Arrays.sort(tmp, new SortByRating());
            for (int i = 0; i < tmp.length; i++) {
                System.out.println(tmp[i].toString());
            }
        } else if (sortMethod == SortBy.Price) {
            Product[] tmp = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                tmp[i] = shoppingCart.get(i);
            }
            Arrays.sort(tmp, new SortByPrice());
            for (int i = 0; i < tmp.length; i++) {
                System.out.println(tmp[i].toString());
            }
        }
    }


    public boolean refundProduct(Product product) {
        int a = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (product.getId() == shoppingCart.get(i).getId()) {
                a = 1;
            }
        }
        if (a == 1) {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            product.getStore().setIncome(product.getStore().getIncome() - product.getPrice());
            product.getStore().addProduct(product);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product("aaa", 4);
        Product p2 = new Product("bbb", 3);
        Product p3 = new Product("ccc", 2);
        Product p4 = new Product("ddd", 1);
        p1.setRating(2);
        p1.setRating(1);
        Store store = new Store("hello");
        store.addProduct(p1);
        store.addProduct(p2);
        store.addProduct(p3);
        store.addProduct(p4);
        Customer alice = new Customer("Alice", 20000);
        alice.purchaseProduct(store, p1);
        alice.purchaseProduct(store, p2);
        alice.purchaseProduct(store, p3);
        alice.purchaseProduct(store, p4);
        System.out.println(p1.getAvgRating());
        p1.setRating(5);
        System.out.println(p1.getAvgRating());
        alice.viewShoppingCart(SortBy.PurchaseTime);
        alice.viewShoppingCart(SortBy.Rating);
        alice.viewShoppingCart(SortBy.Price);
        alice.viewShoppingCart(SortBy.PurchaseTime);
    }
}

class SortByRating implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getAvgRating() <= p1.getAvgRating() ? 1 : -1;

    }
}

class SortByPrice implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getPrice() <= p1.getPrice() ? 1 : -1;
    }
}


