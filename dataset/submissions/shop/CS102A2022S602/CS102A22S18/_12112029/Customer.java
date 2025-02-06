import java.util.ArrayList;
public class Customer {
    private static int cnt=0;
    private int id=0;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        if(rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }

        else return false;
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        store.hasProduct(product);
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            shoppingCart.add(product);
            store.transact(product,0);
            wallet=wallet-product.getPrice();
            return true;
        }
        else return false;
    }


    public void viewShoppingCart(SortBy sortMethod){
        int n = shoppingCart.size(),i;
        if(sortMethod==SortBy.PurchaseTime){
            for(i=0;i<n;i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if(sortMethod==SortBy.Price){
            ArrayList<Product> ab = new ArrayList<>();
            ArrayList<Product> CD = new ArrayList<>(shoppingCart);
            int x=0,y;
            for(y=0;y<shoppingCart.size()-1;y++)
            {
                for(i=1;i<CD.size();i++){
                    if(CD.get(x).getPrice()>CD.get(i).getPrice()){
                        x=i;}
                }ab.add(CD.get(x));CD.remove(x);
                x=0;
            }
            ab.add(CD.get(0));
            for(i=0;i<ab.size();i++){
                System.out.println(ab.get(i).toString());}
        }

        if(sortMethod==SortBy.Rating){
            ArrayList<Product> ab = new ArrayList<>();
            ArrayList<Product> CD = new ArrayList<>(shoppingCart);
            int x=0,y;

            for(y=0;y<shoppingCart.size()-1;y++)
            {
                for(i=1;i<CD.size();i++){
                    if(CD.get(x).getAvgRating()>CD.get(i).getAvgRating()){
                        x=i;}
                }ab.add(CD.get(x));CD.remove(x);
                x=0;
            }
            // CD.get(0) is not safe.
            // add an if statement before to handle CD.size() == 0.
            ab.add(CD.get(0));
            for(i=0;i<ab.size();i++){
                System.out.println(ab.get(i).toString());}
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            wallet=wallet+product.getPrice();
            shoppingCart.remove(product);
            return true;
        }
        else return false;
    }
}
