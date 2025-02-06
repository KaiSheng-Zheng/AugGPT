import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;default is empty.
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
        if (store.hasProduct(product)&&this.wallet>= product.getPrice()){
            store.transact(product,0);
            this.shoppingCart.add(product);
           updateWallet(-product.getPrice());
           product.setStore(store);
            return true;
        }
        else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> newShoppingCart=new ArrayList<>(shoppingCart);
if (sortMethod.equals(SortBy.Price)){
    newShoppingCart.sort(new SortByPrice());
    for (Product p : newShoppingCart){
        System.out.println(p);
    }

}
if (sortMethod.equals(SortBy.Rating)) {
    newShoppingCart.sort(new SortByRating());
    for (Product p : newShoppingCart) {
        System.out.println(p);
    }
}
if (sortMethod.equals(SortBy.PurchaseTime)){

    for (Product p : newShoppingCart){
        System.out.println(p);
    }
}
    }

    public boolean refundProduct(Product product){
       if (shoppingCart.contains(product)){
            product.getStore().transact(product,1);
            updateWallet(+product.getPrice());
            this.shoppingCart.remove(product);
            return true;
        }
        else{
            return false;
        }
    }
}
