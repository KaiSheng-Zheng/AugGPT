import java.util.ArrayList;
public class Customer {
    private static int cnt; //
    private int id;  //
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){this.name=name;this.wallet=wallet;cnt++;id=cnt;}

    public boolean rateProduct(Product product, int rating){
        product.setRating(rating);return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (wallet>=product.getPrice()&&store.hasProduct(product)){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.remove(product);
            return true;
        }else return false;
    }


    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i));}
        }else if (sortMethod==SortBy.Price){
            for (int i=0;i<shoppingCart.size();i++){
                for (int j=0;j<shoppingCart.size()-i-1;j++){
                    if (shoppingCart.get(j).getPrice()>shoppingCart.get(j+1).getPrice()){
                        Product n=shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j,n);
                    }
                }
            }
        }else if (sortMethod==SortBy.Rating){
            for (int i=0;i<shoppingCart.size();i++){
                for (int j=0;j<shoppingCart.size()-i-1;j++){
                    if (shoppingCart.get(j).getRating()>shoppingCart.get(j+1).getRating()){
                        Product n=shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j,n);
    }}}}}
    public boolean refundProduct(Product product){
        return true;
    }
}
