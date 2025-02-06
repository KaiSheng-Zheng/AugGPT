import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id = 1;
    private String name = "";
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet = 0;

    private int proCnt = 0;

    private HashMap<Product, Integer> proNum = new HashMap<Product, Integer>();

    private HashMap<Product, Store> from = new HashMap<Product, Store>();

    public Customer(String name, float wallet) {
        this.id = ++cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            shoppingCart.add(product);
            wallet -= product.getPrice();
            from.put(product, store);
            proNum.put(product, proCnt++);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            shoppingCart.sort(timeSort);
        } else if (sortMethod == SortBy.Price) {
            shoppingCart.sort(priceSort);
        } else if (sortMethod == SortBy.Rating) {
            shoppingCart.sort(rateSort);
        }
        for (Product i : shoppingCart) {
            System.out.println(i);
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            Store store = from.get(product);
            store.transact(product, 1);
            from.remove(product, store);
            wallet += product.getPrice();
            shoppingCart.remove(product);
            return true;
        } else {
            return false;
        }
    }

    Comparator<Product> timeSort = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return proNum.get(o1).compareTo(proNum.get(o2));
        }
    };

    Comparator<Product> rateSort = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            double r1 = o1.getAvgRating(), r2 = o2.getAvgRating();
            if (r1 > r2) {
                return 1;
            } else if (r1 < r2) {
                return -1;
            } else {
                if (proNum.get(o1) > proNum.get(o2)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    };

    Comparator<Product> priceSort = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            double r1 = o1.getPrice(), r2 = o2.getPrice();
            if (r1 > r2) {
                return 1;
            } else if (r1 < r2) {
                return -1;
            } else {
                if (proNum.get(o1) > proNum.get(o2)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    };
}
