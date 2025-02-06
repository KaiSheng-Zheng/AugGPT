import java.util.ArrayList;
import java.util.Collections;


public class Customer {
    private static int cnt; 
    private  int id;  
    private String name;
    private ArrayList<Product> shoppingCart; 
    private float wallet;
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
        shoppingCart = new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        return  product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet = wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        boolean a = false;
        if(store.getProductList().contains(product) && this.wallet >= product.getPrice()){
            a = true;
           store.transact(product,0);
           this.wallet -= product.getPrice();
           
           this.shoppingCart.add(product);
        }
        return a;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for(Product cnt:shoppingCart) System.out.println(cnt);
                break;

            case Rating:
                Collections.sort(shoppingCart,(o1, o2) -> {
                    if(o1.getAvgRating() > o2.getAvgRating())return 1;
                   
                    else if(o1.getAvgRating() == o2.getAvgRating()){
                        if(shoppingCart.indexOf(o1) > shoppingCart.indexOf(o2) ) return 1;
                        else return -1;
                    }
                    
                    else return -1;
                });
                for(Product cnt :shoppingCart) System.out.println(cnt);
                break;

            case Price:
                Collections.sort(shoppingCart,(o1,o2) -> {
                    if(o1.getPrice() > o2.getPrice())return 1;
                   
                    else if(o1.getAvgRating() == o2.getAvgRating()){
                        if(shoppingCart.indexOf(o1) > shoppingCart.indexOf(o2) ) return 1;
                        else return -1;
                    }
                    
                    else return -1;
                });
                for(Product cnt :shoppingCart) System.out.println(cnt);
                break;

        }


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

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }
    public boolean refundProduct(Product product){
        return false;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
