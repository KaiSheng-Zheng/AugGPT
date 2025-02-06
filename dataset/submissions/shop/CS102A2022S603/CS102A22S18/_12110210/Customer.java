import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet){
        ++cnt;
        this.name=name;
        this.wallet=wallet;
        this.id=cnt;
        this.shoppingCart=new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&this.wallet>= product.getPrice()){
            this.shoppingCart.add(product);
            this.wallet=wallet- product.getPrice();
            store.removeProduct(product);
            float in =store.getIncome();
            store.setIncome(in + product.getPrice());
            return true;
        }else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            ArrayList<Product> shopcart = shoppingCart;
            for(int i = 0;i<shopcart.size();i++){
//                shopcart.get(i).toString();
                System.out.println(shopcart.get(i));
            }
        }
        if(sortMethod==SortBy.Rating){
            ArrayList<Product> shopcart = shoppingCart;
            shopcart.sort(new SortByRating());
            for(int i = 0;i<shopcart.size();i++){
//                shopcart.get(i).toString();
                System.out.println(shopcart.get(i));
            }
        }
        if(sortMethod==SortBy.Price){
            ArrayList<Product> shopcart = shoppingCart;
            shopcart.sort(new SortByPrice());
            for(int i = 0;i<shopcart.size();i++){
//                shopcart.get(i).toString();
                System.out.println(shopcart.get(i));
            }
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }
//    public enum SortBy {
//        PurchaseTime, Rating, Price;
//    }
    class SortByRating implements Comparator<Product>{
        @Override
        public int compare(Product x, Product y){
            if(x.getAvgRating() > y.getAvgRating()){
                return 1;
            }else{
                return -1;
            }
        }
    }
    class SortByPrice implements Comparator<Product>{
        @Override
        public int compare(Product x, Product y){
            if(x.getPrice() > y.getPrice()){
                return 1;
            }else{
                return -1;
            }
        }
    }
}
