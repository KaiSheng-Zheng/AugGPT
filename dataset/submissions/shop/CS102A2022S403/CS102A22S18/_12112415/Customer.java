import java.util.ArrayList;
public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>=product.getPrice(product)){
            shoppingCart.remove(product);
            updateWallet(-product.getPrice(product));
            return true;
        }
        else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if(sortMethod==SortBy.Rating) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size()-1-i; j++) {
                    if(shoppingCart.get(j).getAvgRating()>shoppingCart.get(j+1).getAvgRating()){
                        Product part=shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,part);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if(sortMethod==SortBy.Price){
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size()-1-i; j++) {
                    if(shoppingCart.get(j).getPrice(shoppingCart.get(j))>shoppingCart.get(j+1).getPrice(shoppingCart.get(j+1))){
                        Product part=shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,part);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }
}
