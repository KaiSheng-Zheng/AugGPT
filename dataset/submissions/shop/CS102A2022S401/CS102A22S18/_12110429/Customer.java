
import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet =this.wallet+ amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.transact(product,0);
            this.wallet =this.wallet- product.getPrice();
            shoppingCart.add(product);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        } else if (sortMethod.equals(SortBy.Price)) {
            ArrayList<Product> temp = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                temp.add(shoppingCart.get(i));
            }
            Product tool;
            for(int i=0;i<shoppingCart.size()-1;i++){
                for(int j=0;j<shoppingCart.size()-i-1;j++){
                    if(temp.get(i).getPrice()>temp.get(i+1).getPrice()){
                        tool=temp.get(i);
                        temp.set(i,temp.get(i+1));
                        temp.set(i+1,tool);
                    }
                }
            }
            for (int i = 0; i < temp.size(); i++) {
                System.out.println(temp.get(i));
            }
        }
        else if(sortMethod.equals(SortBy.Rating)){
            ArrayList<Product> temp = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                temp.add(shoppingCart.get(i));
            }
            Product tool;
            for(int i=0;i<shoppingCart.size()-1;i++) {
                for (int j = 0; j < shoppingCart.size() - i - 1; j++) {
                    if (temp.get(i).getAvgRating() > temp.get(i + 1).getAvgRating()) {
                        tool = temp.get(i);
                        temp.set(i, temp.get(i + 1));
                        temp.set(i + 1, tool);
                    }
                }
            }
            for(int i=0;i<temp.size();i++){
                System.out.println(temp.get(i));
            }
        }
    }

    public  boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            this.wallet+=product.getPrice();
            Store.TuiKuanHelper(product).transact(product,1);
            return  true;
        }
        return false;
    }

}

