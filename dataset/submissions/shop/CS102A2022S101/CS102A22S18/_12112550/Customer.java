import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private ArrayList<source> productSource = new ArrayList<>();
    private source source;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        setId(cnt);
    }

    public void setId(int cnt) {
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        }
        return false;
    }

    public void updateWallet(float amount) {
        this.wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) & product.getPrice() <= this.wallet) {
            shoppingCart.add(product);
            source productsource = new source(store,product);
            productSource.add(productsource);
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> copyShoppingCart = new ArrayList<>(shoppingCart);
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < copyShoppingCart.size(); i++) {
                System.out.println(copyShoppingCart.get(i));
            }
        }
        if (sortMethod == SortBy.Price) {
            Collections.sort(copyShoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice() > o2.getPrice()) return 1;
                    if (o1.getPrice() < o2.getPrice()) return -1;
                    return 0;
                }
            });

            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(copyShoppingCart.get(i));
            }
        }
        if (sortMethod == SortBy.Rating) {
            Collections.sort(copyShoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating() > o2.getAvgRating()) return 1;
                    if (o1.getAvgRating() < o2.getAvgRating()) return -1;
                    return 0;
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(copyShoppingCart.get(i));
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            for (int i = 0; i < productSource.size(); i++) {
                if(product == productSource.get(i).getProduct()){
                    productSource.get(i).getStore().transact(product,1);
                }
            }
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            return true;
        }
        return false;
    }

    class source{
        private Store store;
        private Product product;
        public source(Store store, Product product){
            this.store = store;
            this.product = product;
        }

        public Product getProduct() {
            return product;
        }

        public Store getStore() {
            return store;
        }
    }
}


