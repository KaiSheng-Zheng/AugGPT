

import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product>shoppingCart = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name = name;
        this. wallet = wallet;
        cnt++;
        this.id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        boolean flag = false;
        if(store.hasProduct(product) && product.getPrice()<=wallet){
            flag = true;
            shoppingCart.add(product);
            wallet -= product.getPrice();
            store.getProductList().remove(product);
            store.setIncome(store.getIncome()+product.getPrice());
        }
        return flag;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.toString() .equals (SortBy.PurchaseTime.toString())){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }

        }
        if(sortMethod.toString() .equals(SortBy.Rating.toString())){
            int[] order = new int[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                order[i] = i;
            }
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                for (int j = i+1; j <shoppingCart.size(); j++) {
                    if(shoppingCart.get(order[i]).getAvgRating() > shoppingCart.get(order[j]).getAvgRating()||shoppingCart.get(order[i]).getAvgRating() == shoppingCart.get(order[j]).getAvgRating()&&order[i]>order[j]){
                        int temp = order[i];
                        order[i] = order[j];
                        order[j] = temp;
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(order[i]));
            }

        }
        if(sortMethod.toString() .equals(SortBy.Price.toString())){
            int[] order = new int[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                order[i] = i;
            }
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                for (int j = i+1; j <shoppingCart.size() ; j++) {
                    if(shoppingCart.get(order[i]).getPrice() > shoppingCart.get(order[j]).getPrice()||shoppingCart.get(order[i]).getPrice() == shoppingCart.get(order[j]).getPrice()&&order[i]>order[j]){
                        int temp = order[i];
                        order[i] = order[j];
                        order[j] = temp;
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(order[i]));
            }
        }


    }

    public boolean refundProduct(Product product){
        return true;
    }


}
