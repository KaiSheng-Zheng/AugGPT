import java.util.ArrayList;
import java.util.*;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products;default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id=cnt;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>= product.getPrice()){
            shoppingCart.add(product);
            wallet-= product.getPrice();
            store.transact(product,0);
            product.store = store;
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod) {
        if (SortBy.PurchaseTime == sortMethod) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        } else if (SortBy.Rating == sortMethod) {
            float[] rating_ = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                rating_[i] = shoppingCart.get(i).getAvgRating();
            }
            for (int i = 0; i < rating_.length - 1; i++) {
                for (int j = 0; j < rating_.length - 1 - i; j++) {
                    if (rating_[j] > rating_[j + 1]) {
                        float temp = rating_[j];
                        rating_[j] = rating_[j + 1];
                        rating_[j + 1] = temp;
                    }
                }
            }
            List<Product> pro=new ArrayList<>();

            for (int i = 0; i <shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (rating_[i] == shoppingCart.get(j).getAvgRating()) {
                        if (!pro.contains(shoppingCart.get(j))){
                            pro.add(shoppingCart.get(j));
                        }
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(pro.get(i).toString());
            }
        } else if (SortBy.Price == sortMethod) {
            float[] rating_ = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                rating_[i] = shoppingCart.get(i).getPrice();
            }
            for (int i = 0; i < rating_.length - 1; i++) {
                for (int j = 0; j < rating_.length - 1 - i; j++) {
                    if (rating_[j] > rating_[j + 1]) {
                        float temp = rating_[j];
                        rating_[j] = rating_[j + 1];
                        rating_[j + 1] = temp;
                    }
                }
            }
            List<Product> pro=new ArrayList<>();
            for (int i=0; i <shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (rating_[i] == shoppingCart.get(j).getPrice()) {
                        if (!pro.contains(shoppingCart.get(j))){
                        pro.add(shoppingCart.get(j));
                        }
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(pro.get(i).toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            product.store.transact(product,1);
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }else {
            return false;
        }
    }

}
