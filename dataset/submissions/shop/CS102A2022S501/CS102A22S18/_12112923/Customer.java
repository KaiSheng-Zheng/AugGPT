import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;


    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        this.id=++cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }else {
            return false;
        }
    }
    public void updateWallet(float amount){
        this.wallet=this.wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && this.wallet>=product.getPrice()){
            updateWallet(-product.getPrice());
            product.setStore(store);
            product.getStore().transact(product,0);
            shoppingCart.add(product);
            return true;
        }
        else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCart2 = new ArrayList<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            shoppingCart2.add(shoppingCart.get(i));
        }
        int n=shoppingCart.size();
        if(sortMethod==SortBy.Rating){
            for(int i=0;i<n;i++){
                for(int j = 0; j<n-i-1; j++){
                    Product a=shoppingCart2.get(j);
                    Product b=shoppingCart2.get(j+1);
                    if(a.getAvgRating()>b.getAvgRating()){
                        shoppingCart2.set(j,b);
                        shoppingCart2.set(j+1,a);
                    }
                    if(a.getAvgRating()==b.getAvgRating()){
                        if(a.getPurchaseTime()>b.getPurchaseTime()){
                            shoppingCart2.set(j,b);
                            shoppingCart2.set(j+1,a);
                        }
                    }
                }
            }
        }
        if(sortMethod==SortBy.Price){
            for(int i=0;i<n;i++){
                for(int j = 0; j<n-i-1; j++){
                    Product a=shoppingCart2.get(j);
                    Product b=shoppingCart2.get(j+1);
                    if(a.getPrice()>b.getPrice()){
                        shoppingCart2.set(j,b);
                        shoppingCart2.set(j+1,a);
                    }
                    if(a.getPrice()==b.getPrice()){
                        if(a.getPurchaseTime()>b.getPurchaseTime()){
                            shoppingCart2.set(j,b);
                            shoppingCart2.set(j+1,a);
                        }
                    }
                }
            }
        }
        if(sortMethod==SortBy.PurchaseTime){
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    Product a = shoppingCart2.get(j);
                    Product b = shoppingCart2.get(j + 1);
                    if(a.getPurchaseTime()>b.getPurchaseTime()){
                        shoppingCart2.set(j,b);
                        shoppingCart2.set(j+1,a);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(shoppingCart2.get(i));
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            this.wallet=this.wallet+product.getPrice();
            product.getStore().transact(product,1);
            return true;
        }
        else{
            return false;
        }
    }
}
