import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private ArrayList<Store> wentStore;
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt = cnt + 1;
        this.id = cnt;
        shoppingCart = new ArrayList<Product>();
        wentStore = new ArrayList<Store>();
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }
        product.setRating(rating);
        return true;
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product) && wallet >= product.getPrice()) {
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            wentStore.add(store);
            store.transact(product, 0);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        } else if (sortMethod == SortBy.Price) {
//            Product maxpriceproduct;
//            for(Product product:shoppingCart){
//               for(Product product2:shoppingCart){
//                   if(product2.getPrice()>product.getPrice()){
//                       maxpriceproduct=product2;
//                   }
//               }
//            }
            sortIntMethod(new ArrayList<Product>(shoppingCart));
        } else if (sortMethod == SortBy.Rating) {
            sortIntMethod2(new ArrayList<Product>(shoppingCart));
        }
    }

    public static void sortIntMethod(List list) {
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Product p1 = (Product) o1;
                Product p2 = (Product) o2;
                if (p1.getPrice() > p2.getPrice()) {
                    return 1;
                } else if (p1.getPrice() == p2.getPrice()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            Product product = (Product) list.get(i);
            System.out.println(product.toString());
        }
    }

    public static void sortIntMethod2(List list) {
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Product p1 = (Product) o1;
                Product p2 = (Product) o2;
                if (p1.getAvgRating() > p2.getAvgRating()) {
                    return 1;
                } else if (p1.getAvgRating() == p2.getAvgRating()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            Product product = (Product) list.get(i);
            System.out.println(product.toString());
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            Store s = wentStore.get(shoppingCart.indexOf(product));
            s.transact(product, 1);
            wallet = wallet + product.getPrice();
            shoppingCart.remove(product);
            wentStore.remove(s);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shoppingCart=" + shoppingCart +
                ", wallet=" + wallet +
                '}';
    }
}
