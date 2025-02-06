import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products;default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;this.id=cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public void buy(Product product){
        this.shoppingCart.add(product);
        this.updateWallet(-product.getPrice());
    }


    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&this.wallet>= product.getPrice()){
            store.transact(product,0);
            this.buy(product);
            return true;
        }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            for (Product product : this.shoppingCart) {
                System.out.println(product);
            }
        }
        if (sortMethod==SortBy.Price){
            ArrayList<Product> A= (ArrayList<Product>) this.shoppingCart.clone();
            ArrayList<Product> B=new ArrayList<>();
            ArrayList<Float> F=new ArrayList<>();
            for (Product value : A) {
                F.add(value.getPrice());
            }
            Collections.sort(F);
            for(float e:F){
                for(int i=0;i<A.size();i++){
                    if(A.get(i).getPrice()==e){
                        B.add(A.get(i));
                        A.remove(i);break;
                    }
                }
            }
            for (Product product : B) {
                System.out.println(product);
            }
        }
        if(sortMethod==SortBy.Rating){
            ArrayList<Product> A= (ArrayList<Product>) this.shoppingCart.clone();
            ArrayList<Product> B=new ArrayList<>();
            ArrayList<Float> F=new ArrayList<>();
            for (Product value : A) {
                F.add(value.getAvgRating());
            }
            Collections.sort(F);
            for(float e:F){
                for(int i=0;i<A.size();i++){
                    if(A.get(i).getAvgRating()==e){
                        B.add(A.get(i));
                        A.remove(i);break;
                    }
                }
            }
            for (Product product : B) {
                System.out.println(product);
            }
        }
    }

    public boolean hasProduct(Product product){
        boolean a=false;
        for (Product value : this.shoppingCart) {
            if (value == product) {
                a=true;
                break;
            }
        }return a;
    }

    public boolean refundProduct(Product product){
        if(hasProduct(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.getStore().transact(product,1);
            return true;
        }else return false;
    }
}