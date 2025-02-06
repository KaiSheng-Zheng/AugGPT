import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        this.id = ++cnt;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if(rating>=1 && rating<=5){
            product.getRatings().add(rating);
            return true;
        }else{
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    
    public boolean purchaseProduct(Store store, Product product){
        if(!shoppingCart.contains(product) && store.hasProduct(product) && wallet >= product.getPrice()){
            wallet -= product.getPrice();
            product.setStore(store);
            product.setPurcheTime(new Date());
            shoppingCart.add(product);
            store.transact(product, 0);
            return true;
        }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getPurcheTime().getTime()>=o2.getPurcheTime().getTime() ? 1 : -1;
                }
            });
        }else if(sortMethod==SortBy.Rating){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getAvgRating()!=o2.getAvgRating()){
                        return o1.getAvgRating()>o2.getAvgRating() ? 1 : -1;
                    }
                    return o1.getPurcheTime().getTime()>=o2.getPurcheTime().getTime() ? 1 : -1;
                }
            });
        }else if(sortMethod==SortBy.Price){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getPrice()!=o2.getPrice()){
                        return o1.getPrice()>o2.getPrice() ? 1 : -1;
                    }
                    return o1.getPurcheTime().getTime()>=o2.getPurcheTime().getTime() ? 1 : -1;
                }
            });
        }
        for(Product p: shoppingCart){
            System.out.println(p);
        }
    }

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet += product.getPrice();
            product.getStore().transact(product, 1);
            return true;
        }else{
            return false;
        }
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
}
