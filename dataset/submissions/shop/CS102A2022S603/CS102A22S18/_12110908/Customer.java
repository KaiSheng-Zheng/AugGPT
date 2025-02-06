import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet) {
        id=++cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet = wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && product.getPrice()<=wallet){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:{
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            }
            case Rating:{
                Product[] cartTemp = new Product[shoppingCart.size()];
                for (int i=0; i<shoppingCart.size(); i++){
                    cartTemp[i]=shoppingCart.get(i);
                }
                Arrays.sort(cartTemp, new sortRatings());
                for (int i=0; i<cartTemp.length; i++){
                    System.out.println(cartTemp[i].toString());
                }
                break;
            }
            case Price:{
                Product[] cartTemp = new Product[shoppingCart.size()];
                for (int i=0; i<shoppingCart.size(); i++){
                    cartTemp[i]=shoppingCart.get(i);
                }
                Arrays.sort(cartTemp, new sortPrice());
                for (int i=0; i<cartTemp.length; i++){
                    System.out.println(cartTemp[i].toString());
                }
                break;
            }
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }
    private static class sortRatings implements Comparator<Product>{
        @Override
        public int compare(Product o1, Product o2) {
            if (o1.getAvgRating()>=o2.getAvgRating()){
                return 1;
            }else {
                return -1;
            }
        }
    }
    private static class sortPrice implements Comparator<Product>{
        @Override
        public int compare(Product o1, Product o2) {
            if (o1.getPrice()>=o2.getPrice()){
                return 1;
            }else {
                return -1;
            }
        }
    }
}
