import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Customer {
    private static int cnt ;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart =new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (wallet >= product.getPrice() && store.hasProduct(product)) {
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product, 0);
            return true;
        } else {
            return false;
        }
    }

    public boolean refundProduct(Product product) {
        int existence = 0;
        Store store=new Store(product.getName());
        for (int i = 0; i < Store.productList1.size(); i++) {
            if (Store.productList1.get(i)==product){
                existence=1;
                break;
            }
        }
        if (existence==1){
            store.transact(product,1);
            shoppingCart.remove(product);
            Store.productList1.remove(product);
            updateWallet(product.getPrice());
            return true;
        }else {
            return false;
        }

    }


    private class SortRating implements Comparator<Product> {
        public int compare(Product o1, Product o2) {
            if (o1.getAvgRating() < o2.getAvgRating()) {
                return -1;
            } else if ((o1.getAvgRating() > o2.getAvgRating())) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private class SortPrice implements Comparator<Product> {
        public int compare(Product o1, Product o2) {
            if (o1.getPrice() < o2.getPrice()) {
                return -1;
            } else if (o1.getPrice() > o2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case Price:
                Product[] a = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    a[i] = shoppingCart.get(i);
                }
                Arrays.sort(a, new SortPrice());
                for (int i = 0; i < a.length; i++) {
                    System.out.println(a[i].toString());
                }
                break;
            case Rating:
                Product[] b = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    b[i] = shoppingCart.get(i);
                }
                Arrays.sort(b, new SortRating());
                for (int i = 0; i < b.length; i++) {
                    System.out.println(b[i].toString());
                }
                break;
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
        }
    }


}
