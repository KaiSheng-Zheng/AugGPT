import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private HashMap<Product, Store> hashMap = new HashMap<Product, Store>();

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        boolean re = false;
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            product.setRating(rating);
            re = true;
        }
        return re;
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean re = false;
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            hashMap.put(product, store);
            shoppingCart.add(product);
            re = true;
        }
        return re;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (shoppingCart.size() > 0) {
            if (sortMethod == SortBy.PurchaseTime) {
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
            }
            if (sortMethod == SortBy.Rating) {
                Product[] pro = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    pro[i] = shoppingCart.get(i);
                }
                int end = shoppingCart.size();
                while (end > 0) {
                    int flag = 0;
                    for (int i = 1; i < end; i++) {
                        if (pro[i - 1].getAvgRating() > pro[i].getAvgRating()) {
                            Product store = pro[i];
                            pro[i] = pro[i - 1];
                            pro[i - 1] = store;
                            flag = 1;
                        }
                    }
                    if (flag == 0) {
                        break;
                    }
                    end--;
                }
                for (Product product : pro) {
                    System.out.println(product);
                }
            }
            if (sortMethod == SortBy.Price) {
                Product[] pro = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    pro[i] = shoppingCart.get(i);
                }
                int end = shoppingCart.size();
                while (end > 0) {
                    int flag = 0;
                    for (int i = 1; i < end; i++) {
                        if (pro[i - 1].getPrice() > pro[i].getPrice()) {
                            Product store = pro[i];
                            pro[i] = pro[i - 1];
                            pro[i - 1] = store;
                            flag = 1;
                        }
                    }
                    if (flag == 0) {
                        break;
                    }
                    end--;
                }
                for (Product product : pro) {
                    System.out.println(product);
                }
            }
        }
    }

    public boolean refundProduct(Product product) {
        boolean have = false;
            if (shoppingCart.contains(product)) {
                shoppingCart.remove(product);
                wallet = wallet + product.getPrice();
                hashMap.get(product).transact(product, 1);
                have = true;
        }
        return have;
    }


}
