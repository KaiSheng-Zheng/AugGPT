import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private HashMap<Product,Store> storeList = new HashMap<Product,Store>();
    private float wallet;


    public Customer(String name, float wallet){
        this.wallet = wallet;this.name=name;
        cnt++;this.id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)){
            return true;
        }else {
            return false;
        }
    }
    public void updateWallet(float amount){
        this.wallet = wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.getProductList().contains(product) && wallet>=product.getPrice()){
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            storeList.put(product,store);
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:{
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            } case Rating:{
                ArrayList<Product> copy = new ArrayList<Product>(shoppingCart);
                ArrayList<Float> rate = new ArrayList<>();
                for (Product product : shoppingCart) {
                    rate.add(product.getAvgRating());
                }
                rate.sort(Comparator.naturalOrder());
                for (int i = 0;i<rate.size();i++){
                    for (int j =0;j<copy.size();j++){
                        if (rate.get(i)==copy.get(j).getAvgRating()){
                            System.out.println(copy.get(j).toString());
                            copy.remove(copy.get(j));
                        }
                    }
                }break;
            } case Price:{
                ArrayList<Product> copy1 = new ArrayList<Product>(shoppingCart);
                ArrayList<Float> price = new ArrayList<>();
                for (Product product : shoppingCart) {
                    price.add(product.getPrice());
                }price.sort(Comparator.naturalOrder());
                for (int i = 0;i<price.size();i++){
                    for (int j =0;j<copy1.size();j++){
                        if (price.get(i)==copy1.get(j).getPrice()){
                            System.out.println(copy1.get(j).toString());
                            copy1.remove(copy1.get(j));
                        }
                    }
                }break;
            }
        }
    }

    public boolean refundProduct(Product product){
        Store store = storeList.get(product);
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            store.transact(product,1);
            return true;
        }else{
            return false;
        }
    }
}
