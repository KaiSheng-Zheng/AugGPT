
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        boolean judge=(rating<=5&&rating>=1);
        if (judge){
            product.getRatings().add(rating);
        }
        return judge;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Customer.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public void updateWallet(float amount){
        setWallet(getWallet()+amount);
    }
    public boolean purchaseProduct(Store store, Product product){
        boolean judge=(store.hasProduct(product)&&product.getPrice()<=getWallet());
        if (judge){
            store.transact(product,0);
            shoppingCart.add(product);
            setWallet(getWallet()- product.getPrice());
        }
        return judge;
    }

    public void viewShoppingCart(SortBy sortByWhat){

        if (sortByWhat==SortBy.PurchaseTime){

            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }else if (sortByWhat==SortBy.Price){
            ArrayList<Product>newProducts=new ArrayList<>(shoppingCart);
            SortByPrice sbp=new SortByPrice();
            Collections.sort(newProducts,sbp);
            for (int i=0;i<newProducts.size();i++){
                System.out.println(newProducts.get(i).toString());
            }

        }else if (sortByWhat==SortBy.Rating){
            ArrayList<Product>newProducts=new ArrayList<>(shoppingCart);
            SortByRatings sbr=new SortByRatings();
            Collections.sort(newProducts,sbr);
            for (int i=0;i<newProducts.size();i++){
                System.out.println(newProducts.get(i).toString());
            }

        }
    }
    public boolean refundProduct(Product product){
        boolean judge=shoppingCart.contains(product);
        if (judge){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.getStoreIn().transact(product,1);
        }
        return judge;
    }

}
class SortByRatings implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
       if (o1.getAvgRating()>=o2.getAvgRating()){
           return 1;
       }else {
           return -1;
       }
    }

}
class SortByPrice implements Comparator<Product>{
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice()>=o2.getPrice()){
            return 1;
        }else {
            return -1;
        }
    }
}
//class SortByPrice implements Comparator<Product>{
//    @Override
//    public int compare(Product o1, Product o2) {
//       return o1.getPrice().compareTo(o2.getPrice());
//    }
//}