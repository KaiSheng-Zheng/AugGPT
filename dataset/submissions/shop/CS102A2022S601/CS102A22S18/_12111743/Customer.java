import java.util.ArrayList;

public class Customer {
 
    private static int cnt=0;
    private int id;
    private String name;
    private float wallet;
    private ArrayList<Product> shoppingCart=new ArrayList<>();

    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
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
    public float getWallet() {
        return wallet;
    }
    public void setWallet(float wallet) {
        this.wallet = wallet;
    }
    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }
    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

 
    public Customer(String name,float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
 
    public boolean rateProduct(Product product, int rating){
        for (int i = 0; i <shoppingCart.size(); i++) {
            if (rating > 0 & rating < 6) {
                return true;
            }
        }return false;
    }
    public void updateWallet(float amount){
        setWallet(getWallet()+amount);
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)==true&getWallet()>= product.getPrice()){
            store.transact(product,0);
            setWallet(getWallet()- product.getPrice());
            shoppingCart.add(product);
            return true;
        }return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime) {
            for(int i=0;i<shoppingCart.size();i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if(sortMethod==SortBy.Rating){
            for(int i=0;i<shoppingCart.size();i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if(sortMethod==SortBy.Price){
            for(int i=0;i<shoppingCart.size();i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        return false;
    }
}

