package Customer;

import Product.Product;
import Store.Store;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.sort;

public class Customer {
    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Customer.cnt = cnt;
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

    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet=0;
    public Customer(){
        cnt++;
        id=cnt;
    }
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        if(rating >=1 && rating <=5){
            product.getRatings().add(rating);
            return true;
        }
        return false;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            wallet-=product.getPrice();
            return true;
        }
        return false;
    }

}
