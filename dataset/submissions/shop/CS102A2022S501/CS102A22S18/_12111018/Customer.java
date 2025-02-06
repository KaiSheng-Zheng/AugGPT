

import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        boolean a=rating<=5&&rating>=1;
        if (a){
            product.addRatings(rating);
        }
        return a;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public void updateWallet(float amount){
        setWallet(this.wallet+amount);
    }
    public boolean purchaseProduct(Store store, Product product){
        boolean a=store.hasProduct(product)&&product.getPrice()<=this.wallet;
        if (a){
            store.transact(product,0);
            shoppingCart.add(product);
            setWallet(this.wallet-product.getPrice());
        }
        return a;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product>newProduct1=new ArrayList<>(shoppingCart);
        ArrayList<Product>newProduct2=new ArrayList<>(shoppingCart);
        if (sortMethod==SortBy.PurchaseTime){
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Rating){
            CompareRating cr=new CompareRating();
            Collections.sort(newProduct1,cr);
            for (int i=0;i<newProduct1.size();i++){
                System.out.println(newProduct1.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Price){
            ComparePrice cp=new ComparePrice();
            Collections.sort(newProduct2,cp);
            for (int i=0;i<newProduct2.size();i++){
                System.out.println(newProduct2.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        boolean a=shoppingCart.contains(product);
        if (a){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.getStore().transact(product,1);
        }
        return a;
    }
}
