import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id ;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt +=1;
        id =cnt;
    }
    public boolean rateProduct(Product product, int rating){
        boolean result = false;
        product.setRating(rating);
        if(product.setRating(rating)){
            result=true;
        }
        return  result;
    }
    public void updateWallet(float amount){
        wallet = wallet+amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        boolean result =false;
        boolean x =false;
        for(int i = 0; i < store.getProductList().size();i++) {
            if (product.getId() == store.getProductList().get(i).getId()) {
                x = true;
                break;
            }
        }
               if(x&&wallet>=product.getPrice()){
                store.transact(product,0);
                updateWallet(-product.getPrice());
                shoppingCart.add(product);
                result=true;
               }
               return result;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            for(int i=0;i<shoppingCart.size();i++)
                System.out.println(shoppingCart.get(i).toString());
        }
        else if(sortMethod==SortBy.Price){
            for(int i=0;i<shoppingCart.size();i++){
                for(int j=0;j<shoppingCart.size()-i-1;j++){
                    if(shoppingCart.get(j).getPrice() > shoppingCart.get(j+1).getPrice()){
                        Product tmp=shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,tmp);
                    }
                }
            }
            for(int i=0;i<shoppingCart.size();i++)
                System.out.println(shoppingCart.get(i).toString());
        }
        else if(sortMethod==SortBy.Rating){
            for(int i=0;i<shoppingCart.size();i++){
                for(int j=0;j<shoppingCart.size()-i-1;j++){
                    if(shoppingCart.get(j).getAvgRating() > shoppingCart.get(j+1).getAvgRating()){
                        Product tmp=shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,tmp);
                    }
                }
            }
            for(int i=0;i<shoppingCart.size();i++)
                System.out.println(shoppingCart.get(i).toString());
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }
    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }
}
