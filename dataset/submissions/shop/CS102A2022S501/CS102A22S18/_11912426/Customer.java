

import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt = 0;
    private int id;
    private  String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name,float wallet){
        this.name = name;
        this.wallet = wallet;
        this.cnt = this.cnt + 1;
        this.id = this.cnt;
        this.shoppingCart = new ArrayList<Product>();
    }

    public ArrayList<Product> getShoppingCart(){
        return shoppingCart;
    }

    public boolean rateProduct(Product product,int rating){
        if(rating ==1 || rating == 2|| rating ==3|| rating ==4||rating ==5){
            product.setRating(rating);
            return true;
        }else{
            return false;
        }
    }

    public void updateWallet(float amount){
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store,Product product){
        if(store.getProductList().contains(product) && this.wallet >= product.getPrice()){
            this.shoppingCart.add(product);
            this.wallet = this.wallet - product.getPrice();
            return true;
        }else{
            return false;
        }
    }


    public void viewShoppingCart(SortBy sortMethod){
       switch (sortMethod){
           case PurchaseTime:
               for (int i = 0; i < this.shoppingCart.size(); i++) {
                   System.out.println(this.shoppingCart.get(i).toString());
               }
               break;

           case Price:
               for (int j = 0; j <this.shoppingCart.size() ; j++) {
                  for (int i = 0; i < this.shoppingCart.size()-1-j ; i++) {
                     if(this.shoppingCart.get(i).getPrice() >= this.shoppingCart.get(i+1).getPrice()){
                       Collections.swap(this.shoppingCart,i,i+1);
                     }
                  }
               }

               for (int i = 0; i < this.shoppingCart.size(); i++) {
                   System.out.println(this.shoppingCart.get(i).toString());
               }
               break;

           case Rating:
               for (int j = 0; j <this.shoppingCart.size() ; j++) {
                   for (int i = 0; i < this.shoppingCart.size()-1-j ; i++) {
                       if(this.shoppingCart.get(i).getAvgRating() >= this.shoppingCart.get(i+1).getAvgRating()){
                           Collections.swap(this.shoppingCart,i,i+1);
                       }
                   }
               }

               for (int i = 0; i < this.shoppingCart.size(); i++) {
                   System.out.println(this.shoppingCart.get(i).toString());
               }
               break;
       }

    }

    public boolean refundProduct(Product product){
        if(this.shoppingCart.contains(product)){
            this.shoppingCart.remove(product);
            this.wallet = this.wallet + product.getPrice();
            return true;
        }else{
            return false;
        }
    }



}
