import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the
    //constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;
    //default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet = wallet+amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>= product.getPrice()){
            store.transact(product,0);
            this.shoppingCart.add(product);
            updateWallet(-product.getPrice());
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCart1 = new ArrayList<>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            shoppingCart1.add(shoppingCart.get(i));
        }

        if(sortMethod.equals(SortBy.PurchaseTime)){
            for (int i = 0; i < shoppingCart1.size(); i++) {
                System.out.println(shoppingCart1.get(i).toString());
            }
        }
        else if (sortMethod.equals(SortBy.Price)){
            shoppingCart1.sort(Comparator.comparing(Product::getPrice));
            for (int i = 0; i < shoppingCart1.size(); i++) {
                System.out.println(shoppingCart1.get(i).toString());
            }
        }
        else if (sortMethod.equals(SortBy.Rating)){
            shoppingCart1.sort(Comparator.comparing(Product::getAvgRating));
            for (int i = 0; i < shoppingCart1.size(); i++) {
                System.out.println(shoppingCart1.get(i).toString());
            }
        }
    }
}
