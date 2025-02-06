import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        boolean result = product.setRating(rating);
        return result;
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && this.wallet >= product.getPrice()){
            shoppingCart.add(product);
            store.transact(product,0);
            updateWallet(-product.getPrice());
            return true;
        }
        else {
            return false;
        }
    }


    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.Price) {
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice() - o2.getPrice());
                }
            });
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.PurchaseTime) {
            for(int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        } else if (sortMethod == SortBy.Rating) {
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice() - o2.getPrice());
                }
            });
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }


    }
        public boolean refundProduct(Product product){
        return true;
        }
}
