import java.util.*;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.wallet = wallet;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            return true;
        }else{
            return false;
        }
    }
    public class ComRat implements Comparator<Product>{
        @Override
        public int compare(Product product1, Product product2){
            if (product1.getAvgRating()<product2.getAvgRating()){
                return -1;
            }else{
                return 1;
            }
        }
    }
    public class ComPc implements Comparator<Product>{
        @Override
        public int compare(Product product1, Product product2){
            if (product1.getPrice()>=product2.getPrice()){
                return 1;
            }else{
                return -1;
            }
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:{
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }break;
            }case Rating:{
                ArrayList<Product> ratingList=new ArrayList<>();
                for (int i = 0; i < shoppingCart.size(); i++) {
                    ratingList.add(shoppingCart.get(i));
                }
                ComRat rat=new ComRat();
                Collections.sort(ratingList,rat);
                for (int i = 0; i < ratingList.size(); i++) {
                    System.out.println(ratingList.get(i));
                }
                break;
            }case Price:{
                ArrayList<Product> priceList=new ArrayList<>();
                for (int i = 0; i < shoppingCart.size(); i++) {
                    priceList.add(shoppingCart.get(i));
                }
                ComPc pc=new ComPc();
                Collections.sort(priceList,pc);
                for (int i = 0; i < priceList.size(); i++) {
                    System.out.println(priceList.get(i));
                }
                break;
            }
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }
}
