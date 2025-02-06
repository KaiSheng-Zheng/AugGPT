import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt += 1;
        this.id = cnt;
        shoppingCart = new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        if (1 <= rating && rating <= 5){
            product.setRating(rating);
            return true;
        }
         else
             return false;
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public ArrayList<Product> products = new ArrayList<>();
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>= product.getPrice()){
            updateWallet(- product.getPrice());
            shoppingCart.add(product);
            store.removeProduct(product);
            store.transact(product,0);
            return true;
        }
        else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod){

                if (sortMethod == SortBy.Price) {
                    Collections.sort(shoppingCart, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return (int) (o1.getPrice() - o2.getPrice());
                        }
                    });
                    for (Product product : shoppingCart) {
                        System.out.print(product.toString());
                    }
                }

        if (sortMethod == SortBy.Rating) {
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getAvgRating() - o2.getAvgRating());
                }
            });
            for (Product product : shoppingCart) {
                System.out.print(product.toString());
            }
        }

        if(sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product : shoppingCart) {
                System.out.print(product.toString());
            }
        }

    }
    public boolean refundProduct(Product product){
        if(this.shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }
        else return false;
    }

}
