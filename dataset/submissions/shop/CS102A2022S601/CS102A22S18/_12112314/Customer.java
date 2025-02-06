import java.util.*;
import java.lang.*;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        boolean e = false;
        if (rating >= 1 && rating <= 5) {
            e = true;
            product.setRating(rating);
        }
        return e;
    }

    ;

    public void updateWallet(float amount) {
        setWallet(wallet + amount);
    }

    ;

    public float getWallet() {
        return wallet;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean e = false;
        if (store.hasProduct(product) & getWallet() >= product.getPrice()) {
            e = true;
            store.transact(product, 0);
            shoppingCart.add(product);
            setWallet(wallet - product.getPrice());
        }
        return e;
    }

    ;

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime: {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            }
            case Rating: {
                ArrayList<Product> w=new ArrayList<>();
                w= (ArrayList<Product>) shoppingCart.clone();
                for (int i = 0; i < shoppingCart.size()-1; i++) {
                    for (int j = i+1; j <shoppingCart.size() ; j++) {
                        boolean e=shoppingCart.get(i).getAvgRating()-shoppingCart.get(j).getAvgRating()>0;
                        if (e){
                            Collections.swap(shoppingCart,i,j);
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    for (int j = i+1; j < shoppingCart.size(); j++) {
                        boolean e=shoppingCart.get(i).getAvgRating()-shoppingCart.get(j).getAvgRating()==0;
                        if (e){
                            if (w.indexOf(shoppingCart.get(i))>w.indexOf(shoppingCart.get(j))){Collections.swap(shoppingCart,i,j);}
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            }
            case Price: {
                ArrayList<Product> w=new ArrayList<>();
                w= (ArrayList<Product>) shoppingCart.clone();
                for (int i = 0; i < shoppingCart.size()-1; i++) {
                    for (int j = i+1; j <shoppingCart.size() ; j++) {
                        boolean e=shoppingCart.get(i).getPrice()-shoppingCart.get(j).getPrice()>0;
                        if (e){
                            Collections.swap(shoppingCart,i,j);
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    for (int j = i+1; j < shoppingCart.size(); j++) {
                        boolean e=shoppingCart.get(i).getPrice()-shoppingCart.get(j).getPrice()==0;
                        if (e){
                            if (w.indexOf(shoppingCart.get(i))>w.indexOf(shoppingCart.get(j))){Collections.swap(shoppingCart,i,j);}
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            }
        }
    }

    ;

    public boolean hasShopping(Product product) {
        boolean e = false;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId() == product.getId()) {
                e = true;
                break;
            }
        }
        return e;
    }

    ;

    public boolean refundProduct(Product product) {
        return true;
    }

    ;
}
