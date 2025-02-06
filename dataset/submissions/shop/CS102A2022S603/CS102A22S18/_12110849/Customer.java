import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;

    private int purchaseid;//

    public Customer(String name, float wallet){
        this.name = name;//
        this.id = ++cnt;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating))  return true;
        else return false;
    }
    public void updateWallet(float amount){
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && this.wallet >= product.getPrice()){
            product.setStore(store);
            product.getStore().transact(product,0);
            product.setPurchasetime(++purchaseid);//
            updateWallet(-product.getPrice());//
            shoppingCart.add(product);
//            store.setIncome(product.getPrice());
//            store.removeProduct(product);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> a = new ArrayList<>();
        a.addAll(shoppingCart);
        if (sortMethod == SortBy.Rating){
            for (int i=0;i<a.size();i++){
                for (int j=i+1;j<a.size(); j++){
                    if (a.get(i).getAvgRating() > a.get(j).getAvgRating()){ //
                        Collections.swap(a,j,i);
                    }
                    if (a.get(i).getAvgRating() == a.get(j).getAvgRating()){
                        if (a.get(i).getPurchasetime() > a.get(j).getPurchasetime()){
                            Collections.swap(a,j,i);
                        }
                    }
                }
            }
        }
        if (sortMethod == SortBy.Price){
            for (int i=0;i<a.size();i++){
                for (int j=i+1;j<a.size(); j++){
                    if (a.get(i).getPrice() > a.get(j).getPrice()){ //
                        Collections.swap(a,j,i);
                    }
                    if (a.get(i).getPrice() == a.get(j).getPrice()){
                        if (a.get(i).getPurchasetime() > a.get(j).getPurchasetime()){
                            Collections.swap(a,j,i);
                        }
                    }
                }
            }
        }
        for (int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.getStore().transact(product,1);
            return true;
        }
        else return false;
    }
}
