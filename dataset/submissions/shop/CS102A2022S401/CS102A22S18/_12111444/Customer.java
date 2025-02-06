
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;
    private ArrayList<Store> javab = new ArrayList<>();

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt += 1;
        id = cnt;
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
        if (store.hasProduct(product) && product.getPrice() <= this.wallet) {
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            for(int i = 0;i<javab.size(); i++){
                if(!javab.contains(store))
                javab.add(store);
            }
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)) {
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    int ans = 0;
                    if(o1.getPrice() > o2.getPrice()){
                        ans = 1;
                    }
                    if(o1.getPrice() < o2.getPrice()){
                        ans = -1;
                    }
                    if(o1.getPrice() == o2.getPrice()){
                        ans = 0;
                    }
                    return ans;
                }
            });
            for(int i = 0; i < shoppingCart.size(); i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod.equals(SortBy.Rating)) {
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    int ans= 0;
                    if(o1.getAvgRating() > o2.getAvgRating()){
                        ans = 1;
                    }
                    if(o1.getAvgRating() < o2.getAvgRating()){
                        ans = -1;
                    }
                    if(o1.getAvgRating() == o2.getAvgRating()){
                        ans= 0;
                    }
                    return ans;
                }
            });
            for(int i = 0; i < shoppingCart.size(); i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            for(int i = 0; i<javab.size();i++){
                for(int m = 0; m<javab.get(i).java.size(); m++){
                    if(javab.get(i).java.contains(product)){
                        javab.get(i).transact(product,1);
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }
}