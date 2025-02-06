import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        this.id = cnt + 1;
        cnt++;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
            product.setRating(rating);
            return true;
        } else
            return false;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product) && this.wallet >= product.getPrice()) {
            this.wallet -= product.getPrice();
            shoppingCart.add(product);
            store.transact(product, 0);
            product.store=store;
            return true;
        } else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> newSort = new ArrayList<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            newSort.add(shoppingCart.get(i));
        }
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < newSort.size(); i++) {
                System.out.println(newSort.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            ArrayList<Product> sort2 = new ArrayList<>();
            for (int i = 0; i < newSort.size(); i++) {
                sort2.add(newSort.get(i));
            }
            for (int i = 0; i < sort2.size(); i++) {
                for (int j = 0; j < sort2.size(); j++) {
                    if (i < j && sort2.get(i).getAvgRating() > sort2.get(j).getAvgRating()) {
                        Collections.swap(sort2,i,j);
                    }
                }
            }
            for (int i = 0; i < sort2.size(); i++) {
                System.out.println(sort2.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Price) {
            ArrayList<Product> sort3 = new ArrayList<>();
            for (int i = 0; i < newSort.size(); i++) {
                sort3.add(newSort.get(i));
            }
            for (int i = 0; i < sort3.size(); i++) {
                for (int j = 0; j < sort3.size(); j++) {
                    if (i < j && sort3.get(i).getPrice() > sort3.get(j).getPrice()) {
                        Collections.swap(sort3,i,j);
                    }
                }
            }
            for (int i = 0; i < sort3.size(); i++) {
                System.out.println(sort3.get(i).toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            wallet += product.getPrice();
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (shoppingCart.get(i) == product) {
                    product.store.transact(product,1);
                }
            }
            shoppingCart.remove(product);
            return true;
        } else
            return false;
    }
}