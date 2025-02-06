import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();  // The list of purchased products; default is empty.
    private float wallet;
    HashMap<Integer,Store> map= new HashMap<>();

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt += 1;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        product.setRating(rating);//maybe something wrong
        boolean result;
        if (rating >= 1 && rating <= 5) {
            result = true;
        } else {
            result = false;
        }return result;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }
    public void  SortByPrice(){
        HashMap<Float,Product> priceMap = new HashMap<>();
        for(int i = 0;i<shoppingCart.size();i++){
            priceMap.put(shoppingCart.get(i).getPrice(),shoppingCart.get(i));
        }

        float[] arr = new float[shoppingCart.size()];
        for(int i = 0;i< shoppingCart.size();i++){
            arr[i] = shoppingCart.get(i).getPrice();
        }
        Arrays.sort(arr);
        for (int i = 0;i< shoppingCart.size();i++){
            System.out.println(priceMap.get(arr[i]).toString());
        }
    }

    public void  SortByRating(){
        HashMap<Float,Product> ratingMap = new HashMap<>();
        for(int i = 0;i<shoppingCart.size();i++){
            ratingMap.put(shoppingCart.get(i).getAvgRating(),shoppingCart.get(i));
        }

        float[] arr = new float[shoppingCart.size()];
        for(int i = 0;i< shoppingCart.size();i++){
            arr[i] = shoppingCart.get(i).getAvgRating();
        }
        Arrays.sort(arr);
        for (int i = 0;i< shoppingCart.size();i++){
            System.out.println(ratingMap.get(arr[i]).toString());
        }
    }

    public boolean purchaseProduct(Store store, Product product){
        map.put(product.getId(),store);//
        boolean result = false;
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            result = true;
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
        }
        return result;
    }public boolean refundProduct(Product product){
        boolean result = false;
       if(shoppingCart.contains(product)){
           result = true;
           updateWallet(product.getPrice());
           shoppingCart.remove(product);
           map.get(product.getId()).transact(product , 1);
       }return result;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod == SortBy.Price) {
            SortByPrice();
        }
        if (sortMethod == SortBy.Rating) {
            SortByRating();
        }
        if (sortMethod == SortBy.PurchaseTime) {
            for(int i = 0;i < shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }
}