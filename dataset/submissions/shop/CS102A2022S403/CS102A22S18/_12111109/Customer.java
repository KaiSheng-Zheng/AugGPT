
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet;
    private ArrayList<Store> productStore = new ArrayList<Store>();
    private Product[] arr = new Product[100010];

    public Customer(String name, float wallet) {
        this.wallet = wallet;
        this.name = name;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (product.getPrice() <= wallet && store.hasProduct(product) == true) {
            store.transact(product, 0);
            shoppingCart.add(product);
            productStore.add(store);
            wallet -= product.getPrice();
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        int n = shoppingCart.size();
        for (int i = 0; i < shoppingCart.size(); i++) {
            arr[i] = shoppingCart.get(i);
        }
        if(sortMethod == SortBy.Price)
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n-1; j++) {
                    if (arr[j].getPrice() > arr[j + 1].getPrice()) {
                        Product temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        if(sortMethod == SortBy.Rating)
                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < n-1; j++) {
                        if (arr[j].getAvgRating() > arr[j + 1].getAvgRating()) {
                            Product temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    }
                }
        for(int i=0;i<n;i++){
            System.out.printf("%s\n", arr[i].toString());
        }
    }

    public boolean refundProduct(Product product) {
        boolean f = false;
        Store st = null;
        Product pr = null;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i) == product) {
                f = true;
                st = productStore.get(i);
                pr = shoppingCart.get(i);
                shoppingCart.remove(i);
                productStore.remove(i);
                break;
            }
        }
        if (f == true) {
            st.transact(pr, 1);
            wallet += pr.getPrice();
            return f;
        } else return f;
    }
}

