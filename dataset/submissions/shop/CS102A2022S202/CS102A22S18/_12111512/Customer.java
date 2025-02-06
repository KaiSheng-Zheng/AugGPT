import java.util.ArrayList;
import java.util.Collections;

public class Customer{
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        if (name == null) {
            this.name = "";
        } else {
            this.name = name;
        }
        this.wallet = wallet;

    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }



    public void updateWallet(float amount){
        wallet += amount;
    }



    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet>=product.getPrice()){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            product.setStore(store);
            return true;
        }
        else
            return false;
    }

    public boolean hasProduct(Product product){
        int a = 0;
        for (Product value : shoppingCart) {
            if (product == value) {
                a++;
                break;
            }
        }
        return a != 0;
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            shoppingCart.remove(product);
            return true;
        }
        else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            case Rating:
                for (int i=1;i<shoppingCart.size();i++){
                    for (int j=0;j<i;j++){
                        if (shoppingCart.get(i).getAvgRating()<shoppingCart.get(j).getAvgRating())
                            Collections.swap(shoppingCart,i,j);
                        else if (shoppingCart.get(i).getAvgRating()==shoppingCart.get(j).getAvgRating()){
                            if (shoppingCart.get(i).getId()<shoppingCart.get(j).getId())
                                Collections.swap(shoppingCart,i,j);
                        }
                    }
                }
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            case Price:
                for (int i=1;i<shoppingCart.size();i++){
                    for (int j=0;j<i;j++){
                        if (shoppingCart.get(i).getPrice()<shoppingCart.get(j).getPrice())
                            Collections.swap(shoppingCart,i,j);
                        else if (shoppingCart.get(i).getPrice()==shoppingCart.get(j).getPrice()){
                            if (shoppingCart.get(i).getId()<shoppingCart.get(j).getId())
                                Collections.swap(shoppingCart,i,j);
                        }
                    }
                }
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
        }
    }

    public boolean refundProduct(Product product){
        if (hasProduct(product)){
            removeProduct(product);
            updateWallet(product.getPrice());
            product.getStore().addProduct(product);
            product.getStore().transact(product,1);
            return true;
        }
        else
            return false;

    }

}

