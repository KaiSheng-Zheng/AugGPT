package Lab;

import java.util.ArrayList;

public class Customer{
    private static int cnt;
private int id;
private String name;
private ArrayList<Product> shoppingCart;
private float wallet;
public boolean rateProduct(Product product,int rating){
    if (product.setRating(rating)==true){
        return true;
    }
    else return false;
}
public void updateWallet(float amount){
    wallet=wallet+amount;
}
public boolean purchaseProduct(Store store,Product product){
    if (store.hasProduct(product)==true){
        if (product.getPrice()<=wallet){
            updateWallet(product.getPrice());
            store.removeProduct(product);
            return true;
        }
    }
    return false;
}
public void viewShoppingCart(SortBy sortmethod){

}
public boolean refundProduct(Product product){
    return true;

}

}
