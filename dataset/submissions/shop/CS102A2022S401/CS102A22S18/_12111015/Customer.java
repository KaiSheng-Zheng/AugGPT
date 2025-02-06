import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private HashMap<Integer, Store> fangbiantuihuo;
    private HashMap<Product, Integer> fangbiansort;

    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
        fangbiantuihuo = new HashMap<>();
        fangbiansort = new HashMap<>();
    }


    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }


    public void updateWallet(float amount){
        wallet = wallet + amount;
    }


    public boolean purchaseProduct(Store store, Product product){
        if ((store.hasProduct(product)) && (wallet >= product.getprice())) {
            shoppingCart.add(product);
            fangbiantuihuo.put(product.getId(), store);
            fangbiansort.put(product, shoppingCart.indexOf(product));
            wallet = wallet - product.getprice();
            store.transact(product, 0);
            return true;
        }
        else {
            return false;
        }
    }


    public void viewShoppingCart(SortBy sortMethod){
        for (int i = 0; i < shoppingCart.size(); i++) {
            fangbiansort.put(shoppingCart.get(i), shoppingCart.indexOf(shoppingCart.get(i)));
        }
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else if (sortMethod == SortBy.Price) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                if (shoppingCart.get(i).getprice() < shoppingCart.get(j).getprice()) {
                    Collections.swap(shoppingCart, i, j);
                }
                if ((shoppingCart.get(i).getprice() == shoppingCart.get(j).getprice()) && (fangbiansort.get(shoppingCart.get(i)) > fangbiansort.get(shoppingCart.get(j)))) {
                    Collections.swap(shoppingCart, i, j);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else if (sortMethod == SortBy.Rating){
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getAvgRating1() < shoppingCart.get(j).getAvgRating1()) {
                        Collections.swap(shoppingCart, i, j);
                    }
                    if ((shoppingCart.get(i).getAvgRating1() == shoppingCart.get(j).getAvgRating1()) && ((fangbiansort.get(shoppingCart.get(i)) > fangbiansort.get(shoppingCart.get(j))))) {
                        Collections.swap(shoppingCart, i, j);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }


    public boolean refundProduct(Product product){
        if (fangbiantuihuo.containsKey(product.getId())) {
            Store yuanlaide = fangbiantuihuo.get(product.getId());
            fangbiantuihuo.remove(product.getId());
            shoppingCart.remove(product);
            wallet = wallet + product.getprice();
            yuanlaide.transact(product, 1);
            return true;
        }
        else {
            return false;
        }
    }
}

