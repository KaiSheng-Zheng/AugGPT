import java.util.ArrayList;
public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private ArrayList<Product> s2=new ArrayList<>();
    private ArrayList<Product> s3=new ArrayList<>();
    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if(rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }
        else
            return false;
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)){
            if(wallet>=product.getPrice()){
                store.removeProduct(product);
                updateWallet(product.getPrice()*-1);
                store.transact(product,0);
                shoppingCart.add(product);
                return  true;
            }
            else
                return false;
        }
        else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
                break;
            case Rating:
                for(int i = 0; i < shoppingCart.size(); i++){
                    s2.add(shoppingCart.get(i));
                    for(int j=0;j<i+1;j++){
                        if(shoppingCart.get(i).getAvgRating()>s2.get(j).getAvgRating()){
                            s2.remove(i);
                            s2.add(j,shoppingCart.get(i));
                            break;
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(s2.get(i).toString());
                }
                break;
            case Price:
                for(int i = 0; i < shoppingCart.size(); i++){
                    s3.add(shoppingCart.get(i));
                    for(int j=0;j<i+1;j++){
                        if(shoppingCart.get(i).getPrice()>s3.get(j).getPrice()){
                            s3.remove(i);
                            s3.add(j,shoppingCart.get(i));
                            break;
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(s3.get(i).toString());
                }
                break;
        }
    }
}
enum SortBy {
    PurchaseTime, Rating, Price
}