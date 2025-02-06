import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id = cnt;
    }
    public void setId(int id) {
        this.id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)==true){
            return true;
        }else return false;
    }
    public void updateWallet(float amount){
//        if(amount>0){wallet+=amount;}
//        if(amount<=0){wallet-=amount;}
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>= product.getPrice()){
            shoppingCart.add(product);
            store.transact(product,0);
            updateWallet(-1*product.getPrice());
            return true;
        }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        for (int i = 0; i < shoppingCart.size(); i++) {

        }
    }
    public boolean refundProduct(Product product){
        int counter=0;int num=0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i) == product) {
                counter++;
                num=i;
            }
        }
        if(counter!=0){
            shoppingCart.remove(shoppingCart.get(num));
            updateWallet(product.getPrice());
            product.getStore().transact(product,1);
            return true;
        } else return false;
    }
}