import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private ArrayList<Product> refundCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&this.wallet>=product.getPrice()){
            this.shoppingCart.add(product);
            this.wallet-= product.getPrice();
            store.transact(product,0);
            product.setStore(store);
            return true;
        }else {return false;}
    }

    public void viewShoppingCart(SortBy sortMethod){

            if (sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product : shoppingCart) {
                System.out.println(product);
                }
            }
            if (sortMethod.equals(SortBy.Rating)){
                shoppingCart.sort(Comparator.comparing(Product::getAvgRating));
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
            }
            if (sortMethod.equals(SortBy.Price)){

                shoppingCart.sort(Comparator.comparing(Product::getPrice));
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
            }
        }
    public boolean refundProduct(Product product){
        if (!shoppingCart.contains(product)){
            
            
            return false;
        }else {shoppingCart.remove(product);
            refundCart.add(product);
            wallet+= product.getPrice();
            product.getStore().transact(product,1);
            return true;}
    }
}
