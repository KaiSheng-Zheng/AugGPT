import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private  ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    public Customer (String name,float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id = cnt;
    }
    public boolean rateProduct(Product product,int rating){
        if (product.setRating(rating)){
            return true;
        }
        else {
            return false;
        }
    }
    public void updateWallet(float amount){
         wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store,Product product){
        if (store.hasProduct(product)  && wallet >= product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            return true;
        }
        else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case Rating:
                ArrayList<Product> copy1=new ArrayList<>();
                for (int i = 0; i < this.shoppingCart.size(); i++) {
                    copy1.add(shoppingCart.get(i));
                }
                Collections.sort(copy1,new SortByRating());
                for (int i = 0; i < copy1.size(); i++) {
                    System.out.println(copy1.get(i).toString());
                }
                break;
            case Price:
                ArrayList<Product> copy2=new ArrayList<>();
                for (int i = 0; i < this.shoppingCart.size(); i++) {
                    copy2.add(shoppingCart.get(i));
                }
                Collections.sort(copy2,new SortByPrice());
                for (int i = 0; i < copy2.size(); i++) {
                    System.out.println(copy2.get(i).toString());
                }
                break;
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size() ; i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }

        }



    }
    private class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2){
            if (p2.getAvgRating()<=p1.getAvgRating()){
                return 1;
            }
            return -1;
        }
    }
    private class SortByPrice implements Comparator<Product>{
        @Override
        public int compare(Product p1, Product p2){
            if (p2.getPrice()<=p1.getPrice()){
                return 1;
            }
            return -1;
        }
    }




}
