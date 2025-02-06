import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (wallet >= product.getPrice()) {
            if (store.hasProduct(product)) {
                wallet -= product.getPrice();
                shoppingCart.add(product);
                store.transact(product,0);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> arrayList = new ArrayList<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            arrayList.add(shoppingCart.get(i));
        }
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product a : shoppingCart) {
                System.out.println(a);
            }
        } else if (sortMethod == SortBy.Price) {
            Collections.sort(arrayList, new SortByPrice());
            for (Product a : arrayList) {
                System.out.println(a);
            }
        } else {
            Collections.sort(arrayList, new SortByRating());
            for (Product a : arrayList) {
                System.out.println(a);
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.indexOf(product)==-1){
            return false;
        }else {
            shoppingCart.remove(product);
            wallet+= product.getPrice();
            product.getStore().Storerefund(product);
            return true;
        }
    }


    class SortByPrice implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            if (o1.getPrice() > o2.getPrice()) {
                return 1;
            } else if (o1.getPrice() < o2.getPrice()){
                return -1;
            }else {
                return 0;
            }
        }
    }

    class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            if (o1.getAvgRating() > o2.getAvgRating()) {
                return 1;
            } else if (o1.getAvgRating() < o2.getAvgRating()){
                return -1;
            }else {
                return 0;
            }
        }
    }
}
