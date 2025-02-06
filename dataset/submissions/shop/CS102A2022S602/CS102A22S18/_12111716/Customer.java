import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public int c;
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
this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>= product.getPrice()){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            c++;
            product.setA(c);
            this.shoppingCart.add(product);
            product.sets(store);
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(shoppingCart.size()==0){}
        else {
if(sortMethod==SortBy.PurchaseTime) {
    Product[] P = new Product[shoppingCart.size()];
    for (int i = 0; i < shoppingCart.size(); i++) {
        P[i] = shoppingCart.get(i);
    }
    Arrays.sort(P, Comparator.comparingInt(Product::getA));
    for (Product product : P) {
        System.out.println(product.toString());
    }
}
if(sortMethod==SortBy.Price){
    Product[] P = new Product[shoppingCart.size()];
    for (int i = 0; i < shoppingCart.size(); i++) {
        P[i] = shoppingCart.get(i);
    }
    Arrays.sort(P, (P1, P2) -> Float.compare(P1.getPrice(), P2.getPrice()));
    for(int j=0;j<P.length;j++){
    for(int i=0;i<P.length-1;i++){
        if(P[i].getPrice()==P[i+1].getPrice()){
            P[i]=P[i].getA()>P[i+1].getA()?P[i+1]:P[i];
        }
    }}
    for (Product product : P) {
        System.out.println(product.toString());
    }
}
if(sortMethod==SortBy.Rating){
    Product[] P = new Product[shoppingCart.size()];
    for (int i = 0; i < shoppingCart.size(); i++) {
        P[i] = shoppingCart.get(i);
    }
    Arrays.sort(P, (P1, P2) -> Float.compare(P1.getAvgRating(), P2.getAvgRating()));
    for(int j=0;j<P.length;j++){
        for(int i=0;i<P.length-1;i++){
            if(P[i].getAvgRating()==P[i+1].getAvgRating()){
                P[i]=P[i].getA()>P[i+1].getA()?P[i+1]:P[i];
            }
        }}
    for (Product product : P) {
        System.out.println(product.toString());
    }
}
    }}

    public boolean refundProduct(Product product){
if(hasProductc(product)){
    updateWallet(product.getPrice());
  this.shoppingCart.remove(product);
product.getS().transact(product,1);
    return true;
}
    return false;

}
    public boolean hasProductc(Product product){
        for (Product value : shoppingCart) {
            if (product.getId() == value.getId()) {
                return true;
            }
        }
        return false;
    }


}



