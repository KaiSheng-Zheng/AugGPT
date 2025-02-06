
import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>() ; // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        if(rating<0){return false;}
        else{product.setRating(rating); return true;}
    }
    public void updateWallet(float amount){
        this.wallet+=amount;//Update the wallet of this customer.
        // The amount could be positive (gaining money) or negative (consuming money). Assume that arguments are always valid.
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)==true && this.wallet>= product.getPrice())
        {updateWallet(-product.getPrice()); shoppingCart.add(product); store.transact(product,0);
            return true;}
        else{return false;}
    }
   
    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> cao = new ArrayList<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
             cao.add(shoppingCart.get(i));
        }
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < cao.size(); i++) {
                System.out.println(cao.get(i));
            }
        }
        if (sortMethod == SortBy.Price) {
            for (int i = 0; i < cao.size() - 1; i++) {
                for (int j = 0; j < cao.size() - 1 - i; j++) {
                    if (cao.get(j).getPrice() > cao.get(j + 1).getPrice()) {
                        Product temp = cao.get(j);
                        cao.set(j, cao.get(j + 1));
                        cao.set(j + 1, temp);
                    }
                }
            }
            for (int i = 0; i < cao.size(); i++) {
                System.out.println(cao.get(i));
            }

        }
        if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < cao.size() - 1; i++) {
                for (int j = 0; j < cao.size() - 1 - i; j++) {
                    if (cao.get(j).getAvgRating() > cao.get(j + 1).getAvgRating()) {
                        Product temp = cao.get(j);
                        cao.set(j, cao.get(j + 1));
                        cao.set(j + 1, temp);
                    }
                }
            }
            for (int i = 0; i < cao.size(); i++) {
                System.out.println(cao.get(i));
            }

        }
    }
    public boolean refundProduct(Product product){
        return true;
    }
}