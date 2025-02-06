import java.util.ArrayList;
import java.util.Objects;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name,float wallet){
        ++cnt;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        if(product.getPrice()>wallet)return false;
        int len=store.getProductList().size();
        for(int i=0;i<len;i++){
            //if(Objects.equals(product.getName(), store.getProductList().get(i).getName()))
            if(store.getProductList().get(i).equal(product))
            {
                updateWallet(-product.getPrice());
                //wallet-=product.getPrice();
                shoppingCart.add(product) ;
                store.transact(product,0);
                //store.incomeChange(product.getPrice());
                return true;
                //store.getProductList().remove(i);
            }
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime -> {
                int len=shoppingCart.size();
                for(int i=0;i<len;i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
            }
            case Rating -> {
                int len=shoppingCart.size();
                int []sort=new int[len+10];
                for(int i=0;i<len;i++){
                    sort[i]=i;
                }
                for(int i=0;i<len;i++){
                    for(int j=0;j<=i;j++){
                        if(i==j)continue;
                        if(shoppingCart.get(sort[i]).getAvgRating()<shoppingCart.get(sort[j]).getAvgRating() ){
                            int pos=sort[i];
                            sort[i]=sort[j];
                            sort[j]=pos;
                        }
                    }
                }
                for(int i=0;i<len;i++){
                    System.out.println(shoppingCart.get(sort[i]).toString());
                }
            }
            case Price -> {
                int len=shoppingCart.size();
                int []sort=new int[len+10];
                for(int i=0;i<len;i++){
                    sort[i]=i;
                }
                for(int i=0;i<len;i++){
                    for(int j=0;j<=i;j++){
                        if(i==j)continue;
                        if(shoppingCart.get(sort[i]).getPrice()<shoppingCart.get(sort[j]).getPrice() ){
                            int pos=sort[i];
                            sort[i]=sort[j];
                            sort[j]=pos;
                        }
                    }
                }
                for(int i=0;i<len;i++){
                    System.out.println(shoppingCart.get(sort[i]).toString());
                }
            }
        }
    }
    public boolean refundProduct(Product product){
        return false;//bonus
    }
}