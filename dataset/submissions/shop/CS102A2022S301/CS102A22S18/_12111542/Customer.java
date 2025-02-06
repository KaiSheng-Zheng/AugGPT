import java.util.*;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart =new ArrayList<>();
    private float wallet;
    ArrayList<Product> copy;
    public Customer(String name,float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }public boolean rateProduct(Product product,int rating){
        return  product.setRating(rating);
    }public void updateWallet(float amount){
        wallet+=amount;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }public ArrayList<Product> copyshoppingCart(ArrayList<Product> copy,ArrayList<Product> shoppingCart){
        copy=new ArrayList<>(shoppingCart.size());
        copy.addAll(shoppingCart);
        this.copy=copy;
        return this.copy;
    }

    public boolean purchaseProduct(Store store, Product product){
       if (store.hasProduct(product)&&product.getPrice()<=wallet){
           shoppingCart.add(product);
           wallet -= product.getPrice();
           store.transact(product, 0);
           return true;
        }else {
           return false;
       }
    }public void viewShoppingCart(SortBy sortMethod){
       copy=copyshoppingCart(copy,shoppingCart);
        if (sortMethod==SortBy.PurchaseTime){
            for (Product p:copy) {
                System.out.println(p);
            }
        }else if (sortMethod==SortBy.Rating){
            for (int i = 0; i < copy.size()-1; i++) {
                for (int j = 0; j < copy.size()-1-i; j++) {
                    if (copy.get(j).getAvgRating()>copy.get(j+1).getAvgRating()){
                        Collections.swap(copy,j,j+1);
                    }
                }
            }for (Product p:copy) {
                System.out.println(p);
            }
        }else if (sortMethod==SortBy.Price){
            for (int i = 0; i < copy.size()-1; i++) {
                for (int j = 0; j < copy.size()-1-i; j++) {
                    if (copy.get(j).getPrice()>copy.get(j+1).getPrice()){
                        Collections.swap(copy,j,j+1);
                    }
                }
            }
            for (Product p:copy) {
                System.out.println(p);
            }
        }copy.clear();
    }
    public boolean refundProduct(Product product){
        if (this.shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+=product.getPrice();
            product.sd.transact(product,1);
            return true;
        }else {
            return false;
        }
    }
}