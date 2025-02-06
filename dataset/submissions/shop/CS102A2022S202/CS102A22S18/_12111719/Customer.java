import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private HashMap<Product,Store> origin=new HashMap<>();
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (!store.hasProduct(product)||wallet<product.getPrice()){
            return false;
        }
        store.transact(product,0);
        shoppingCart.add(product);
        updateWallet(-product.getPrice());
        origin.put(product,store);
        return true;
    }
    public void viewShoppingCart(SortBy sortMethod){
        HashMap<Product,Integer> ccc = new HashMap<>();
        for(int i=0;i<shoppingCart.size();i++){
            ccc.put(shoppingCart.get(i),i);
        }
        ArrayList<Product> ab = new ArrayList<>(shoppingCart);
        if (sortMethod== SortBy.Rating){
            for (int i=0;i<ab.size()-1;i++){
                Product temp1;
                Product temp2;
                for (int j=i+1;j<ab.size();j++){
                    if (ab.get(i).getAvgRating()>ab.get(j).getAvgRating()){
                        temp1=ab.get(j);
                        temp2=ab.get(i);
                        ab.remove(i);
                        ab.add(i,temp1);
                        ab.remove(j);
                        ab.add(j,temp2);
                    }
                    if (ab.get(i).getAvgRating()==ab.get(j).getAvgRating()&&ccc.get(ab.get(i))>ccc.get(ab.get(j))){
                        temp1=ab.get(j);
                        temp2=ab.get(i);
                        ab.remove(i);
                        ab.add(i,temp1);
                        ab.remove(j);
                        ab.add(j,temp2);
                    }
                }
            }
            for (Product product : ab) {
                System.out.println(product);
            }
        }
        if (sortMethod==SortBy.Price){
            for (int i=0;i<ab.size()-1;i++){
                Product temp1;
                Product temp2;
                for (int j=i+1;j<ab.size();j++){
                    if (ab.get(i).getPrice()>ab.get(j).getPrice()) {
                        temp1 = ab.get(j);
                        temp2 = ab.get(i);
                        ab.remove(i);
                        ab.add(i, temp1);
                        ab.remove(j);
                        ab.add(j, temp2);
                    }
                    if (ab.get(i).getPrice()==ab.get(j).getPrice()&&ccc.get(ab.get(i))>ccc.get(ab.get(j))){
                        temp1=ab.get(j);
                        temp2=ab.get(i);
                        ab.remove(i);
                        ab.add(i,temp1);
                        ab.remove(j);
                        ab.add(j,temp2);
                    }
                }
            }
            for (Product product : ab) {
                System.out.println(product);
            }
        }
        if (sortMethod==SortBy.PurchaseTime){
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }
    }
    public boolean refundProduct(Product product){
        if (!shoppingCart.contains(product)){
            return false;
        }
        Store a=origin.get(product);
        a.transact(product,1);
        origin.remove(product);
        shoppingCart.remove(product);
        updateWallet(product.getPrice());
        return true;
    }
}