

import java.util.ArrayList;
import java.util.Comparator;


public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;


    public Customer(String name, float wallet) {
        cnt++;
        this.id=cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
    }


    public boolean rateProduct(Product product, int rating) {
        if (rating<1||rating>5){
            return false;
        }else {product.setRating(rating);return true;}
    }


    public void updateWallet(float amount) {
        this.wallet = this.wallet + amount;
    }
    public enum SortBy {
        PurchaseTime, Rating, Price
    }


    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            this.shoppingCart.add(product);
            store.getProductList().remove(product);
            this.updateWallet(-product.getPrice());
            store.setIncome(store.getIncome()+product.getPrice());
            return true;}
        else {return false;}
    }


    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (Product A : this.shoppingCart) {
                System.out.println(A);
            }
        }
        if (sortMethod.equals(SortBy.Rating)) {
           shoppingCart.sort(new Comparator<Product>() {
               @Override
               public int compare(Product o1, Product o2) {
                   return (int) (o1.getAvgRating()- o2.getAvgRating());
               }
           });
            for (Product A : this.shoppingCart) {
                System.out.println(A);;}


            if (sortMethod.equals(SortBy.Price)) {
               shoppingCart.sort(new Comparator<Product>() {
                   @Override
                   public int compare(Product o1, Product o2) {
                       return (int) (o1.getPrice()- o2.getPrice());
                   }
               });
                for (Product A : this.shoppingCart) {
                    System.out.println(A);;}
            }
        }


    }


    public boolean refundProduct(Product product){

         return false;
        }



}