import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;id=cnt;this.shoppingCart=new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        if (rating>=1&&rating<=5){
          product.setRating(rating); return true;
        }else {return false;}
    }
    public void updateWallet(float amount){
wallet=wallet+amount;
}
    public boolean purchaseProduct(Store store, Product product){
    if (store.getProductList().contains(product)&&wallet>=product.getPrice()){
        wallet=wallet-product.getPrice();shoppingCart.add(product);
        store.transact(product,0);return true;
    }else {return false;
    }
}public void viewShoppingCart(SortBy sortMethod){
    SortBy type=sortMethod;
    switch (type){
        case PurchaseTime:int shuliang=shoppingCart.size();
            for (int i = 0; i <shuliang ; i++) {
                System.out.println(shoppingCart.get(i).toString());
            }break;
        case Rating:int n=shoppingCart.size();
        ArrayList<Product> sub=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                sub.add(shoppingCart.get(i));
            }
        ArrayList<Float> rate=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                rate.add(sub.get(i).getAvgRating());
            }
            Collections.sort(rate);int a=n;
            for (int j = 0; j <n ; j++) {
                for (int k = 0; k <a; k++) {
                    if (rate.get(j)==sub.get(k).getAvgRating()){
                        System.out.println(sub.get(k).toString());a--;sub.remove(k);break;
                    }
                }
            }break;
        case Price:int b=shoppingCart.size();
        ArrayList<Product> sub1=new ArrayList<>();
            for (int i = 0; i <b ; i++) {
                sub1.add(shoppingCart.get(i));
            }
            ArrayList<Float> price1=new ArrayList<>();
            for (int i = 0; i <b ; i++) {
                price1.add(shoppingCart.get(i).getPrice());
            }
            Collections.sort(price1);int g=b;
            for (int j = 0; j <b ; j++) {
                for (int k = 0; k <g; k++) {
                    if (price1.get(j)==sub1.get(k).getPrice()){
                        System.out.println(sub1.get(k).toString());g--;sub1.remove(k);break;
                    }
                }
            }
    }
    }public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.add(product);wallet=wallet+product.getPrice();return true;
        }else {
            return false;
        }
    }
}