import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
                break;
            case Rating:
                float[] shabi=new float[shoppingCart.size()];
                ArrayList<Product> sl=new ArrayList<>();
                for(int i=0;i<shoppingCart.size();i++){shabi[i]=shoppingCart.get(i).getAvgRating();}
                Arrays.sort(shabi);
                for(int i=0;i<shoppingCart.size();i++){
                    for(int j=0;j<shoppingCart.size();j++){
                        if(shoppingCart.get(i).getAvgRating()==shabi[j]){
                            sl.add(j,shoppingCart.get(i));
                            shabi[j]=-1;break;
                        }
                    }
                }
                for (Product product : sl) {
                    System.out.println(product);
                }
                break;
            case Price:
                float[] shabi2=new float[shoppingCart.size()];
                ArrayList<Product> sl2=new ArrayList<>();
                for(int i=0;i<shoppingCart.size();i++){shabi2[i]=shoppingCart.get(i).getPrice();}
                Arrays.sort(shabi2);
                for(int i=0;i<shoppingCart.size();i++){
                    for(int j=0;j<shoppingCart.size();j++){
                        if(shoppingCart.get(i).getPrice()==shabi2[j]){
                            sl2.add(j,shoppingCart.get(i));
                            shabi2[j]=-1;break;
                        }
                    }
                }
                for (Product product : sl2) {
                    System.out.println(product);
                }
                break;
        }
    }

    public boolean refundProduct(Product product){
return true;
    }
}
