

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt;// initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private  static int pcnt;

    public Customer(String name, float wallet){
        cnt++;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);

    }
    public void updateWallet(float amount){
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(product.zainamai == store.getId() && product.getPrice() <= this.wallet) {
            this.shoppingCart.add(product);//update shoppingCart
            updateWallet(-product.getPrice());
            store.transact(product,0);

            pcnt++;
            product.purchasetime = pcnt;
            return true;
        }
        return false;
    }
    public ArrayList<Product> sortbypt(ArrayList<Product> list){
        Collections.sort(list, new Comparator<Product>(){
            public int compare(Product p1, Product p2) {
                int v1=p1.purchasetime;
                int v2=p2.purchasetime;
                if( v1>v2 ){
                    return 1;
                }
                if(v1==v2){
                    return 0;
                }
                return -1;
            }
        });
        return list;
    }
    public ArrayList<Product> sortbyra(ArrayList<Product> list){
        Collections.sort(list, new Comparator<Product>(){
            public int compare(Product p1, Product p2) {
                double v1=p1.getRating();
                double v2=p2.getRating();
                if( v1>v2 ){
                    return 1;
                }
                if(v1==v2){
                    int vv1=p1.purchasetime;
                    int vv2=p2.purchasetime;
                    if( vv1>vv2 ){
                        return 1;
                    }
                    if(vv1==vv2){
                        return 0;
                    }
                    return -1;
                }
                return -1;
            }
        });
        return list;
    }
    public ArrayList<Product> sortbypr(ArrayList<Product> list){
        Collections.sort(list, new Comparator<Product>(){
            public int compare(Product p1, Product p2) {
                double v1=p1.getPrice();
                double v2=p2.getPrice();
                if( v1>v2 ){
                    return 1;
                }
                if(v1==v2){
                    return 0;
                }
                return -1;
            }
        });
        return list;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> arrayList = new ArrayList<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            arrayList.add(shoppingCart.get(i));
        }

        if (sortMethod==SortBy.Rating){
            arrayList = sortbyra(arrayList);
        }
        if (sortMethod==SortBy.Price){
            arrayList = sortbypr(arrayList);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).toString());
        }
    }
    public boolean refundProduct(Product product) {
        if (!this.shoppingCart.contains(product)) {
            return false;
        }
        this.shoppingCart.remove(product);
        updateWallet(product.getPrice());
        product.shangdian.transact(product,1);
        return true;
    }
}
