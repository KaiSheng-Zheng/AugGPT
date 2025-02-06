import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>(0);
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            return true;
        } else {
            return false;
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.findStore().transact(product, 1);
            return true;
        } else {
            return false;
        }
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime: {
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            }
            case Rating: {
                Product[] tempCart = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    tempCart[i] = shoppingCart.get(i);
                }
                Arrays.sort(tempCart,(p1, p2) -> {
                    if (p1.getAvgRating() >= (p2.getAvgRating())) {
                        return 1;
                    } else {
                        return -1;
                    }
                });
                for (Product product : tempCart) {
                    System.out.println(product.toString());
                }
                break;
            }
            case Price: {
                Product[] tempCart = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    tempCart[i] = shoppingCart.get(i);
                }
                Arrays.sort(tempCart,(p1, p2) -> {
                    if (p1.getPrice() >= (p2.getPrice())) {
                        return 1;
                    } else {
                        return -1;
                    }
                });
                for (Product product : tempCart) {
                    System.out.println(product.toString());
                }
                break;
            }
        }
    }
}
