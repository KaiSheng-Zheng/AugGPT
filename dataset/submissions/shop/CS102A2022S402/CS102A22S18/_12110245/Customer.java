import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;
    private HashMap<Product,Store>productStoreHashMap=new HashMap<>();

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;

    }
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }
        else{
            return false;
        }
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&this.wallet>= product.getPrice()){
            store.transact(product,0);
            this.shoppingCart.add(product);
            this.productStoreHashMap.put(product,store);
            this.wallet-=product.getPrice();
            return true;
        }
        else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            for(Product c:shoppingCart){
                System.out.println(c.toString());
            }
        }
        if(sortMethod==SortBy.Rating){
            Product[]RatingSort=new Product[shoppingCart.size()];
            for(int i=0;i<shoppingCart.size();i++){
                RatingSort[i]=shoppingCart.get(i);
            }
            Arrays.sort(RatingSort,new SortByRating());
            for(Product c:RatingSort){
                System.out.println(c.toString());
            }
        }
        if(sortMethod==SortBy.Price){
            Product[]PriceSort=new Product[shoppingCart.size()];
            for(int i=0;i<shoppingCart.size();i++){
                PriceSort[i]=shoppingCart.get(i);
            }
            Arrays.sort(PriceSort,new SortByPrice());
            for(Product c:PriceSort){
                System.out.println(c.toString());
            }
        }

    }
    public boolean refundProduct(Product product){
        if(this.shoppingCart.contains(product)){
            this.shoppingCart.remove(product);
            this.wallet+= product.getPrice();
            //this.productStoreHashMap.remove(product);
            this.productStoreHashMap.get(product).addProduct(product);
            this.productStoreHashMap.get(product).transact(product,1);
            return true;
        }
        else{
            return false;
        }
    }

}
class SortByRating implements Comparator<Product> {
    @Override
    public int compare(Product p1,Product p2){
        if(p2.getAvgRating()<=p1.getAvgRating()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
class SortByPrice implements Comparator<Product>{
    @Override
    public int compare(Product p1,Product p2){
        if(p2.getPrice()<=p1.getPrice()){
            return 1;
        }
        else{
            return -1;
        }
    }
}

