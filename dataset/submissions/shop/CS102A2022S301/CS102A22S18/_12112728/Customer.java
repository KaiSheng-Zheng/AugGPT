import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public static int cal;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (wallet >= product.getPrice() && store.hasProduct(product)) {
            shoppingCart.add(product);
            cal++;
            product.setNumber(cal);
            wallet -= product.getPrice();
            product.setStore(store);
            store.transact(product, 0);
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
            Collections.sort(shoppingCart, new Comparator<Product>() {
                public int compare(Product a1, Product a2) {
                    if (a1.getAvgRating() - a2.getAvgRating() > 0) {
                        return 0;
                    } else if (a1.getAvgRating() - a2.getAvgRating() < 0) {
                        return -1;
                    } else {
                        if (a1.getNumber() >= a2.getNumber()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        } else if (sortMethod == SortBy.Price) {
            Collections.sort(shoppingCart, new Comparator<Product>() {
                public int compare(Product a1, Product a2) {
                    if (a1.getPrice() - a2.getPrice() > 0) {
                        return 0;
                    } else if (a1.getPrice() - a2.getPrice() < 0) {
                        return -1;
                    } else {
                        if (a1.getNumber() >= a2.getNumber()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        boolean test = false;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId() == product.getId() && Objects.equals(shoppingCart.get(i).getName(), product.getName())) {
                test = true;
                break;
            }
        }
        if (test) {
            this.wallet += product.getPrice();
            shoppingCart.remove(product);
            product.getStore().transact(product, 1);
        }
        return test;
    }

}
