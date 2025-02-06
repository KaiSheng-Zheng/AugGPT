
import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    //private ArrayList<Product> productInShoppingCart = new ArrayList<>();
    //private ArrayList<Store> stores = new ArrayList<>();
    private HashMap<Integer, Store> purchase = new HashMap<>();
    public Customer(String name , float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
       if(product.setRating(rating)){
           return true;
       }else {
           return false;
       }
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            shoppingCart.add(product);
            wallet -= product.getPrice();
            store.transact(product, 0);
            //stores.add(store);
            //productInShoppingCart.add(product);
            purchase.put(product.getId(), store);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }else if(sortMethod == SortBy.Rating){
            int len = shoppingCart.size();
            float[] record = new float[len];
            for (int i = 0; i < len; i++) {
                record[i] = shoppingCart.get(i).getAvgRating();
            }
            int[] index = ArraySort(record);
            for (int i = 0; i < len; i++) {
                System.out.println(shoppingCart.get(index[i]).toString());
            }
        }else if(sortMethod == SortBy.Price){
            int len = shoppingCart.size();
            float[] record = new float[len];
            for (int i = 0; i < len; i++) {
                record[i] = shoppingCart.get(i).getPrice();
            }
            int[] index = ArraySort(record);
            for (int i = 0; i < len; i++) {
                System.out.println(shoppingCart.get(index[i]).toString());
            }
        }
    }
    public int[] ArraySort(float[] arr){
        float temp;
        int index;
        int k = arr.length;
        int[] index1 = new int[k];
        for (int i = 0; i < k; i++) {
            index1[i] = i;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    index = index1[j];
                    index1[j] = index1[j + 1];
                    index1[j + 1] = index;
                }
            }
        }
        return index1;
    }
    public boolean refundProduct(Product product){
        if(purchase.containsKey(product.getId())){
            //getStore(product).transact(product, 1);
            purchase.get(product.getId()).transact(product , 1);
            shoppingCart.remove(product);
            wallet += product.getPrice();
            purchase.remove(product.getId());
            //productInShoppingCart.remove(product);
            //stores.remove(getStore(product));
            return true;
        }
        return false;
    }
    /*public boolean judge(Product product){
        for (int i = 0; i < productInShoppingCart.size(); i++) {
            if(product == productInShoppingCart.get(i)){
                return true;
            }
        }
        return false;
    }
    public Store getStore(Product product){
        for (int i = 0; i < productInShoppingCart.size(); i++) {
            if(product == productInShoppingCart.get(i)){
                return stores.get(i);
            }
        }
        return null;
    }*/
}
