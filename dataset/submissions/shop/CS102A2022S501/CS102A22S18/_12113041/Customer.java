import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
       cnt++;
       id=cnt;
       this.name=name;
       this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating) {
        if (!product.setRating(rating)) {
            return false;
        } else {

            return true;
        }
    }

    public void updateWallet(float amount){
        if(amount>=0) {
            this.wallet+=amount;
        }
        if(amount<0){
            this.wallet+=amount;
        }
    }
//Purchase product from store
    public boolean purchaseProduct(Store store, Product product){
        boolean b=true;
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            this.wallet = this.wallet-product.getPrice();
            shoppingCart.add(product);
            store.transact(product, 0);
        } else {
            b = false;
                }
        return b;
    }


    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> list = new ArrayList<>(shoppingCart);
        if(sortMethod==SortBy.Price){
            sortbyprice(list);
        }
        else if(sortMethod==SortBy.Rating){
            sortbyrating(list);
        }
        else if(sortMethod==SortBy.PurchaseTime){
            sortbytime(list);
        }
    }

    public enum SortBy {
        PurchaseTime, Rating, Price
    }

    public void sortbyprice(ArrayList<Product> list) {
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (p1.getPrice() > p2.getPrice()) {
                    return 1;
                } else if (p1.getPrice() < p2.getPrice()) {
                    return -1;
                } else {
                    if (list.indexOf(p1)>list.indexOf(p2)) {
                        return 1;
                    } else if (list.indexOf(p1)<list.indexOf(p2)) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void sortbyrating(ArrayList<Product> list){
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2){
                if(p1.getAvgRating()>p2.getAvgRating()) {
                    return 1;
                }
                else if(p1.getAvgRating()<p2.getAvgRating()) {
                    return -1;
                }
                else {
                    if(list.indexOf(p1)>list.indexOf(p2)){
                        return 1;
                    }
                    else if(list.indexOf(p1)<list.indexOf(p2)){
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
            }
        });
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }

    public void sortbytime(ArrayList<Product> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public boolean refundProduct(Product product){
        return false;
    }
}

