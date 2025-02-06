import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private  float wallet;

    private ArrayList<Store> stores = new ArrayList<>();

    public Customer(String name,float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store,Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            stores.add(store);
            return true;
        }
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
                ArrayList<Product> shoppingCart1 = new ArrayList<>();
                shoppingCart1 = shoppingCart;
                shoppingCart1.sort((o1, o2) -> {
                    float diff = o1.getAvgRating() - o2.getAvgRating();
                    if (diff > 0f){
                        return 1;
                    }
                    else if (diff == 0f){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                });
                for (Product product : shoppingCart1){
                    System.out.println(product.toString());
                }
                break;
            case Price:
                ArrayList<Product> shoppingCart2 = new ArrayList<>();
                shoppingCart2 = shoppingCart;
                shoppingCart2.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        float diff = o1.getPrice()-o2.getPrice();
                        if (diff > 0f){
                            return 1;
                        }
                        else if (diff == 0f){
                            return 0;
                        }
                        else{
                            return -1;
                        }
                    }
                });
                for (Product product : shoppingCart2){
                    System.out.println(product.toString());
                }
        }
    }

    public boolean refundProduct(Product product){
        for (int i = 0;i < shoppingCart.size();i++){
            if (shoppingCart.get(i).getId() == product.getId()){
                shoppingCart.remove(product);
                wallet += product.getPrice();
                stores.get(i).transact(product,1);
                stores.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }
}
