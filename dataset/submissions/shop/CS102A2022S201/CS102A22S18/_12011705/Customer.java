import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.shoppingCart = new ArrayList<>();
        this.wallet = 0;
    }
    public boolean rateProduct(Product product, int rating){
        if(rating>=1&&rating<=5){
            return true;
        }
        return false;
    }
    public void updateWallet(float amount){
            wallet = wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        for (int i = 0;i<shoppingCart.size();i++){
            if (product.getId()==shoppingCart.get(i).getId()){
                if(wallet>=shoppingCart.get(i).getPrice()){
                    return true;
                }
            }
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){

    }
}