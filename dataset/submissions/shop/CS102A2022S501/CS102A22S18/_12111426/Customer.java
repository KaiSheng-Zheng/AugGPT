import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        cnt=cnt+1;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }else{return false;}
    }
    public void updateWallet(float amount){
        if (wallet>=0) {
                wallet = wallet + amount;


        }
    }HashMap<Product,Store>stmMap=new HashMap<>();
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) &&wallet>=product.getPrice()){
            wallet=wallet- product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            if (!stmMap.containsKey(product)){
                stmMap.put(product,store);
            }
            return true;
        }else{
            return false;
        }

    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.Rating){
            ArrayList<Product>E=new ArrayList<>(shoppingCart);
            if (shoppingCart.size()>0){
                for (int i = 1; i < E.size(); i++) {
                    for (int j = 0; j <E.size()-i; j++) {
                        if (E.get(j).getAvgRating() > E.get(j + 1).getAvgRating()) {
                            Product c=E.get(j);
                            E.set(j, E.get(j + 1));
                            E.set(j + 1, c);
                        }
                    }
                }
            }
           for (int i=0;i<E.size();i++){
               System.out.println(E.get(i).toString());
           }
        }
        if (sortMethod==SortBy.Price){
            ArrayList<Product>F=new ArrayList<>(shoppingCart);
            if (shoppingCart.size()>0) {
                for (int i = 1; i < F.size(); i++) {
                    for (int j = 0; j < F.size() -i; j++) {
                        if (F.get(j).getPrice() > F.get(j + 1).getPrice()) {
                            Product d=F.get(j);
                            F.set(j, F.get(j + 1));
                            F.set(j + 1, d);
                        }
                    }
                }
            }
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(F.get(i).toString());
            }
        }
        if (sortMethod==SortBy.PurchaseTime){
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet = wallet + product.getPrice();
            stmMap.get(product).transact(product,1);
            return true;
        } else {
            return false;
        }
    }
}
