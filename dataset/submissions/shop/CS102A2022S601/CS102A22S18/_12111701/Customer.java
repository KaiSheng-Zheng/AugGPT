import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public int yy;

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet-=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>= product.getPrice()){
            store.transact(product,0);
            updateWallet(product.getPrice());
            yy++;
            product.setA(yy);
            this.shoppingCart.add(product);
            return true;
        }else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(shoppingCart.size()==0){
            return;
        }else{
            if(sortMethod==SortBy.PurchaseTime){
                Product[] s = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    s[i] = shoppingCart.get(i);
                }
                for (int i = s.length-1; i>-1; i--) {
                    System.out.println(s[i].toString());
                }
            }
            if(sortMethod==SortBy.Price){
                Product[] k = new Product[shoppingCart.size()];
                for (int h = 0; h < shoppingCart.size(); h++) {
                    k[h] = shoppingCart.get(h);
                }
                Arrays.sort(k, (P1, P2) -> Float.compare(P1.getPrice(), P2.getPrice()));
                for(int y=0;y<k.length;y++){
                    for(int i=0;i<k.length-1;i++){
                        if(k[i].getPrice()==k[i+1].getPrice()){
                            k[i]=k[i].getA()>k[i+1].getA()?k[i+1]:k[i];
                        }
                    }}
                for (Product product : k) {
                    System.out.println(product.toString());
                }
            }
            if(sortMethod==SortBy.Rating){
                Product[] cf = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    cf[i] = shoppingCart.get(i);
                }
                Arrays.sort(cf, (P1, P2) -> Float.compare(P1.getAvgRating(), P2.getAvgRating()));
                for(int q=0;q<cf.length;q++){
                    for(int w=0;w<cf.length-1;w++){
                        if(cf[w].getAvgRating()==cf[w+1].getAvgRating()){
                            cf[w]=cf[w].getA()>cf[w+1].getA()?cf[w+1]:cf[w];
                        }
                    }}
                for (Product product : cf) {
                    System.out.println(product.toString());
                }
            }
        }
    }
    public boolean refundProduct(Product product){
        if(hasProduct(product)){
            updateWallet(product.getPrice());
            this.shoppingCart.remove(product);
            product.getS().transact(product,1);
            return true;
        }
        return false;

    }
    public boolean hasProduct(Product product){
        for (Product value : shoppingCart) {
            if (product.getId() == value.getId()) {
                return true;
            }
        }
        return false;
    }
}
