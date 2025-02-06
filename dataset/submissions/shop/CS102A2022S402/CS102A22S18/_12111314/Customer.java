import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet = 0;
    private ArrayList<Store> stores = new ArrayList<>();

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        if (wallet + amount >= 0) {
            wallet += amount;
        }
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            stores.add(store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case Price:
                int[] compare = new int[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (shoppingCart.get(i).getPrice() > shoppingCart.get(j).getPrice()) {
                            compare[i]++;
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (compare[j] == i) {
                            System.out.println(shoppingCart.get(j).toString());
                        }
                    }
                }
                break;
            case Rating:
                int[] comp = new int[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (shoppingCart.get(i).getAvgRating() > shoppingCart.get(j).getAvgRating()) {
                            comp[i]++;
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (comp[j] == i) {
                            System.out.println(shoppingCart.get(j).toString());
                        }
                    }
                }
                break;
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            stores.get(shoppingCart.indexOf(product)).transact(product, 1);
            wallet += product.getPrice();
            stores.remove(shoppingCart.indexOf(product));
            shoppingCart.remove(product);
            return true;
        }
        return false;
    }
}
