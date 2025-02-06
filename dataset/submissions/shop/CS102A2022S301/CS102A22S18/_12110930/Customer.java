import java.util.*;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private float wallet;
    private Map<Integer, Store> map;
    private Map<Integer, Integer> sortMap;
    private ArrayList<Product> shoppingCart;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        this.id = ++cnt;
        this.map = new HashMap<Integer, Store>();
        this.sortMap = new HashMap<Integer, Integer>();
        this.shoppingCart = new ArrayList<Product>();
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
            product.setRating(rating);
            return true;
        }
        return false;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            map.put(product.getId(), store);
            sortMap.put(product.getId(), this.shoppingCart.size() + 1);
            this.shoppingCart.add(product);
            this.updateWallet(-product.getPrice());
            store.transact(product, 0);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (this.shoppingCart.size() > 0) {
            if (sortMethod.equals(SortBy.Rating)) {
                for (int i = 0; i < this.shoppingCart.size() - 1; i++) {
                    for (int j = 0; j < this.shoppingCart.size() - 1 - i; j++) {
                        if (this.shoppingCart.get(j).getAvgRating() > this.shoppingCart.get(j + 1).getAvgRating()) {
                            Product temp = this.shoppingCart.get(j);
                            this.shoppingCart.set(j, this.shoppingCart.get(j + 1));
                            this.shoppingCart.set(j + 1, temp);
                        } else if (this.shoppingCart.get(j).getAvgRating() == this.shoppingCart.get(j + 1)
                                .getAvgRating()
                                && sortMap.get(this.shoppingCart.get(j).getId()) > sortMap
                                        .get(this.shoppingCart.get(j + 1).getId())) {
                            Product temp = this.shoppingCart.get(j);
                            this.shoppingCart.set(j, this.shoppingCart.get(j + 1));
                            this.shoppingCart.set(j + 1, temp);
                        }
                    }
                }
            }

            if (sortMethod.equals(SortBy.Price)) {
                for (int i = 0; i < this.shoppingCart.size() - 1; i++) {
                    for (int j = 0; j < this.shoppingCart.size() - 1 - i; j++) {
                        if (this.shoppingCart.get(j).getPrice() > this.shoppingCart.get(j + 1).getPrice()) {
                            Product temp = this.shoppingCart.get(j);
                            this.shoppingCart.set(j, this.shoppingCart.get(j + 1));
                            this.shoppingCart.set(j + 1, temp);
                        } else if (this.shoppingCart.get(j).getPrice() == this.shoppingCart.get(j + 1).getPrice()
                                && sortMap.get(this.shoppingCart.get(j).getId()) > sortMap
                                        .get(this.shoppingCart.get(j + 1).getId())) {
                            Product temp = this.shoppingCart.get(j);
                            this.shoppingCart.set(j, this.shoppingCart.get(j + 1));
                            this.shoppingCart.set(j + 1, temp);
                        }
                    }
                }
            }

            for (Product product : this.shoppingCart) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("empty");
        }
    }

    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            this.shoppingCart.remove(product);
            this.updateWallet(product.getPrice());
            Store store = this.map.get(product.getId());
            store.transact(product, 1);
            return true;
        }
        return false;
    }
}