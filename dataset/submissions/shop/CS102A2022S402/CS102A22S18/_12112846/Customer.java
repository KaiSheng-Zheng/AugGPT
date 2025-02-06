import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class Customer {

    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    private HashMap<Product, Store> purchasedHistory = new HashMap<>();

    public Customer(String name, float wallet) {
        id=++cnt;
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating) { return product.setRating(rating); }
    public void updateWallet(float amount) {
        wallet = amount + wallet;
    }
    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= wallet) {
            store.transact(product, 0);
            wallet -= product.getPrice();
            purchasedHistory.put(product, store);
            shoppingCart.add(product);
            return true;
        }
        return false;
    }

    private class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product p1,Product p2){
            if (p2.getAvgRating() <= p1.getAvgRating()){
                return 1;
            }else {return -1;}
        }
    }
    private class SortByPrice implements Comparator<Product>{
        @Override
        public int compare(Product p1,Product p2){
            if (p2.getPrice()<=p1.getPrice()) {
                return 1;
            }else {return -1;}
        }
    }


    public void viewShoppingCart(SortBy sortMethod){
        switch(sortMethod){
            case PurchaseTime:{

                for(int i=0; i<shoppingCart.size(); i++){
                    System.out.println(shoppingCart.get(i).toString());
                }break;
            }
            case Rating:{
                Product[] tmp = new Product[shoppingCart.size()];
                for(int i=0; i<shoppingCart.size(); i++){
                    tmp[i] = shoppingCart.get(i);
                }
                Arrays.sort(tmp,new SortByRating());

                for(int i=0; i<tmp.length; i++){
                    System.out.println(tmp[i].toString());
                }break;
            }
            case Price:{
                Product[] tmp = new Product[shoppingCart.size()];
                for (int i=0; i<shoppingCart.size(); i++){
                    tmp[i] = shoppingCart.get(i);
                }
                Arrays.sort(tmp,new SortByPrice());
                for (int i=0; i<tmp.length; i++){
                    System.out.println(tmp[i].toString());
                }break;
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            this.purchasedHistory.remove(product);
            this.purchasedHistory.get(product).transact(product, 1);
            this.shoppingCart.remove(product);
            this.wallet += product.getPrice();
            return true;
        }
        return false;
    }



}
