import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<Product>();
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if (rating>5||rating<1){
            return false;
        }
        else {
        product.setRating(rating);
        return true;}
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    int k=0;
    public boolean purchaseProduct(Store store, Product product){
        if(product.getPrice()<=wallet&&store.getProductList().contains(product)){
            store.transact(product,0);
            shoppingCart.add(product);
            k++;
            product.setTime(k);
            updateWallet(-product.getPrice());
            return true;
        }else {return false;}

    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){

            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(shoppingCart.size()-1-i));
            }
        }
        if (sortMethod==SortBy.Price){
            //shoppingCart.sort(Product::compareTo);
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = 1; j < shoppingCart.size(); j++) {
                    Product product;
                       if (shoppingCart.get(i).getPrice()>shoppingCart.get(j).getPrice()){
                           product=shoppingCart.get(i);
                           shoppingCart.set(i,shoppingCart.get(j));
                           shoppingCart.set(j,product);
                       }
                    }
                }

            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
        if (sortMethod==SortBy.Rating){
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = 1; j < shoppingCart.size(); j++) {
                    Product product;
                    if (shoppingCart.get(i).getAvgRating()>shoppingCart.get(j).getAvgRating()){
                        product=shoppingCart.get(i);
                        shoppingCart.set(i,shoppingCart.get(j));
                        shoppingCart.set(j,product);
                    }
                }
            }

            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
    }


    public boolean refundProduct(Product product){
return false;
    }
}