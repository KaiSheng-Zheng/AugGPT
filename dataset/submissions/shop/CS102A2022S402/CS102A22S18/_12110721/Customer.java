import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private int cont= 0;
    public Customer(String name, float wallet){
        cont++;
        this.id = cont;
        this.name = name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (product.getPrice()<=wallet) {
            boolean flag = store.removeProduct(product);
            if (flag) {
                this.shoppingCart.remove(product);
                wallet-=product.getPrice();
            }
            return flag;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){

    }
    public boolean refundProduct(Product product){
        return true;
    }
}
