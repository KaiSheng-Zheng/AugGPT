import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart;// The list of purchased products;default is empty.
    private ArrayList<Store> shoppingStore;
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
        shoppingCart=new ArrayList<>();
        shoppingStore=new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (wallet>= product.getPrice()&& store.hasProduct(product)){
            shoppingCart.add(product);
            shoppingStore.add(store);
            product.setStoreName(store);
            store.transact(product,0);
            updateWallet(-product.getPrice());
            return true;
        }
        else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod.equals(SortBy.Rating)){
            Product[]aa=new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                aa[i]=shoppingCart.get(i);
            }Arrays.sort(aa,new SortByRating());
            for (Product product : aa) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)){
            Product[]bb=new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                bb[i]=shoppingCart.get(i);
            }Arrays.sort(bb,new SortByPrice());
            for (Product product : bb) {
                System.out.println(product.toString());
            }
        }


    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            product.getStoreName().transact(product,1);
            return true;
        }
        else{
            return false;
        }
    }
    private class SortByRating implements Comparator<Product> {
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
    private class SortByPrice implements Comparator<Product>{
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
}
