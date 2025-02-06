import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private final String name;
    private final ArrayList<Product> shoppingCart=new ArrayList<>();
    private final ArrayList<Store> store1=new ArrayList<>();
    private float wallet;
    private int id;

    public Customer(String name, float wallet){
        this.wallet=wallet;
        this.name=name;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>= product.getPrice()){
            store.transact(product,0);
            store1.add(store);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.Rating){
            for (int i = 1; i < shoppingCart.size(); i++) {
                for(int j=0;j<shoppingCart.size()-i;j++){
                    if(shoppingCart.get(j).getAvgRating()>shoppingCart.get(j+1).getAvgRating()){
                       Product x=shoppingCart.get(j);
                       shoppingCart.set(j,shoppingCart.get(j+1));
                       shoppingCart.set(j+1,x);
                    }
                }
            }
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if(sortMethod==SortBy.Price){
            for (int i = 1; i < shoppingCart.size(); i++) {
                for(int j=0;j<shoppingCart.size()-i;j++){
                    if(shoppingCart.get(j).getPrice()>shoppingCart.get(j+1).getPrice()){
                        Product x=shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,x);
                    }
                }
            }
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if(sortMethod==SortBy.PurchaseTime){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            store1.get(shoppingCart.indexOf(product)).transact(product,1);
            store1.remove(shoppingCart.indexOf(product));
            shoppingCart.remove(product);
            wallet+= product.getPrice();
            return true;
        }else {
            return false;
        }
    }
}