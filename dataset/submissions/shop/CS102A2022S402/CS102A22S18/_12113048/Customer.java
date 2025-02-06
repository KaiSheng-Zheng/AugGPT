import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)) return true;
        else return false;
    }

    public void updateWallet(float amount){
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            this.wallet = this.wallet - product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++){
                    System.out.println(shoppingCart.get(i));
                }
            case Price:
                for (int i = 0; i < shoppingCart.size(); i++){
                    for (int j = i+1 ; j < shoppingCart.size(); j++){
                        if (shoppingCart.get(i).getPrice() > shoppingCart.get(j).getPrice()){
                            Collections.swap(shoppingCart,i,j);
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++){
                    System.out.println(shoppingCart.get(i));
                }
            case Rating:
                for (int i = 0; i < shoppingCart.size(); i++){
                    for (int j = i+1 ; j < shoppingCart.size(); j++){
                        if (shoppingCart.get(i).getAvgRating() > shoppingCart.get(j).getAvgRating()){
                            Collections.swap(shoppingCart,i,j);
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++){
                    System.out.println(shoppingCart.get(i));
                }
        }
    }
}