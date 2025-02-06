import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.

    private int id;  // unique for each product and the value is set to cnt.


    public static void setCnt(int cnt) {
        Customer.cnt = cnt;
    }
    public int getCnt(){
        return Customer.cnt;
    }
    public void setId(int id){
        this.id=cnt+1;
    }
    public int getId(){
        return this.id;
    }

    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.

    private float wallet;
    public Customer(String name, float wallet){
        cnt += 1;
        this.id = cnt;
        this.name =name;
        this.wallet = wallet;

    }
    public boolean rateProduct(Product product, int rating){
        if (!(rating>5 || rating<1)){
            product.setRating(rating);
            return true;
        }
        else return false;
    }
    public void updateWallet(float amount){
            wallet = wallet+amount;

    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>= product.getPrice()){
            shoppingCart.add(product);
            product.setPurchasetime (shoppingCart.size());
            this.updateWallet(-product.getPrice());
            store.transact(product,0);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        List<Product> list=shoppingCart;
        Comparator<Product> a=Comparator.comparing(Product::getPrice);
        Comparator<Product> b=Comparator.comparing(Product::getAvgRating);
        Comparator<Product> c=Comparator.comparingInt(Product::getPurchasetime);
        if(sortMethod.equals(SortBy.Price)) {
            list.sort(a.thenComparing(c));
        }
        else if(sortMethod.equals(SortBy.Rating)){
            list.sort(b.thenComparing(c));
        }
        else if(sortMethod.equals(SortBy.PurchaseTime)){
            list= shoppingCart;
        }
        for (int i = 0; i < shoppingCart.size();i++)
        System.out.println(list.get(i));
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet = wallet + product.getPrice();
            product.getStore().transact(product,1);
        return true;
        }
        else return false;
    }
}
