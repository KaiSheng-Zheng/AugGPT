import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart= new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private ArrayList<Store> stores=new ArrayList<>();

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(wallet>=product.getPrice()&&store.hasProduct(product)){
            wallet-=product.getPrice();
            store.transact(product,0);
            shoppingCart.add(product);
            stores.add(store);
            return true;
        }
        else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingcart=shoppingCart;
        if(sortMethod==SortBy.PurchaseTime){
            for(int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if(sortMethod==SortBy.Rating){
            ArrayList<Product> copy = new ArrayList<>(shoppingcart);
            copy.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    float rat1=o1.getAvgRating();
                    float rat2=o2.getAvgRating();
                    return ((rat1-rat2)>=0)?1:-1;
                }
            });
            for(int i=0;i<copy.size();i++){
                System.out.println(copy.get(i).toString());
            }
        }
        if(sortMethod==SortBy.Price){
            ArrayList<Product> copy = new ArrayList<>(shoppingcart);
            copy.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    float pri1=o1.getPrice();
                    float pri2=o2.getPrice();
                    return ((pri1-pri2)>=0)?1:-1;
                }
            });
            for(int i=0;i<copy.size();i++){
                System.out.println(copy.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+=product.getPrice();
            for(int i=0;i<stores.size();i++){
                if(stores.get(i).hasproductss(product)){
                    stores.get(i).transact(product,1);
                    return true;
                }
            }
        }
        return false;
    }
}