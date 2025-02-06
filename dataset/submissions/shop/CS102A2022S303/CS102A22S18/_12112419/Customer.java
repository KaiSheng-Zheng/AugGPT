import java.lang.reflect.Array;
import java.util.*;

public class Customer {
    private static int cnt;
    private int id; //
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
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
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product)) {
            if (wallet - product.getPrice() >= 0) {
                wallet = wallet - product.getPrice();
                shoppingCart.add(product);
                store.transact(product, 0);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int compare(Product o1, Product o2) {
        if (o1.getId() >= o2.getId()) {
            return 1;
        } else {
            return -1;
        }
    }

    public int compare2(Product o1, Product o2) {
        if (o1.getAvgRating() >= o2.getAvgRating()) {
            return 1;
        } else {
            return -1;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (shoppingCart.size() >= 2) {
            if (sortMethod == SortBy.PurchaseTime) {
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                        if (shoppingCart.get(j).getId() > shoppingCart.get(j + 1).getId()) {
                            Collections.swap(shoppingCart, j, j + 1);
                        }
                    }
                }
            }
        } else {
            return;
        }

        if (shoppingCart.size() >= 2) {
            if (sortMethod == SortBy.Rating) {
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                        if (shoppingCart.get(j).getAvgRating() > shoppingCart.get(j + 1).getAvgRating()) {
                            Collections.swap(shoppingCart, j, j + 1);
                        }
                        if (shoppingCart.get(j).getPrice() == shoppingCart.get(j + 1).getPrice()) {
                            if (shoppingCart.get(j).getId() > shoppingCart.get(j + 1).getId()) {
                                Collections.swap(shoppingCart, j, j + 1);
                            }
                        }
                    }
                }
            }
        } else {
            return;
        }

        if (shoppingCart.size() >= 2) {
            if (sortMethod == SortBy.Price) {
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                        if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice()) {
                            Collections.swap(shoppingCart, j, j + 1);
                        }
                        if (shoppingCart.get(j).getPrice() == shoppingCart.get(j + 1).getPrice()) {
                            if (shoppingCart.get(j).getId() > shoppingCart.get(j + 1).getId()) {
                                Collections.swap(shoppingCart, j, j + 1);
                            }
                        }
                    }
                }
            }
        }
        else {
            return;
        }

        for (int i = 0; i <shoppingCart.size() ; i++) {
            System.out.println(shoppingCart.get(i));
        }
    }


    public boolean refundProduct(Product product) {
        while (shoppingCart.size() != 0) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                while (shoppingCart.get(i) == product) {
                    shoppingCart.remove(product);
                    wallet += product.getPrice();
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}

