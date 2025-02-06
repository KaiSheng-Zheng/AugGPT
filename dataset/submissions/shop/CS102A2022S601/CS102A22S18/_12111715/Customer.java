import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    HashMap<Product,Store> store = new HashMap<Product,Store>();
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private int counter;
    public Customer(String name, float wallet){
        this.name=name;this.wallet=wallet;cnt++;id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
       return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet>= product.getPrice()){
           store.transact(product,0);this.store.put(product,store);updateWallet(0-product.getPrice());shoppingCart.add(product);
           counter++;product.setPurchasetinme(counter);return true;}
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i));
                }
                break;
            case Rating:
                Collections.sort(shoppingCart,Rating);
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i));
                }
                break;
            case Price:
                Collections.sort(shoppingCart,Prize);
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i));
                }
                break;
        }
    }
    Comparator<Product> Rating = new Comparator<Product>() {
        @Override
        public int compare(Product P1, Product P2) {
            if(P1.getAvgRating()>P2.getAvgRating()) return 1;
            else if(P1.getAvgRating()<P2.getAvgRating()) return -1;
            else if(P1.getAvgRating()==P2.getAvgRating()) return P1.getPurchasetinme()-P2.getPurchasetinme();
            else return 0;
        }
    };
    Comparator<Product> Prize = new Comparator<Product>() {
        @Override
        public int compare(Product P1 ,Product P2) {
            if(P1.getPrice()>P2.getPrice()) return  1;
            else if(P1.getPrice()<P2.getPrice()) return -1;
            else if(P1.getPrice()==P2.getPrice())return P1.getPurchasetinme()-P2.getPurchasetinme();
            else return 0;
        }
    };
    public boolean refundProduct(Product product){
        if( shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            store.get(product).transact(product,1);
            store.get(product).addProduct(product);
            return true;
    }
        else return false;
}
}
