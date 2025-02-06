import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    // Attributes
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private Store store;
    // Constructor
    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.shoppingCart = new ArrayList<>(){};
        if (wallet > 0) this.wallet = wallet;
    }
    // Methods
    public boolean rateProduct(Product product, int rating){
        if (rating >= 1 && rating <= 5) {
            product.setRating(rating);
            return true;
        } else return false;
    }
    public void updateWallet(float amount){this.wallet += amount;}
    public boolean purchaseProduct(Store store, Product product){
        this.store = store;
        boolean has = store.hasProduct(product);
        if (has && this.wallet >= product.getPrice()){
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            store.transact(product, 0);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (Product value : this.shoppingCart){
                System.out.println(value.toString());
            }
        }
        else if (sortMethod.equals(SortBy.Rating)){
            Product[] productShoppingCart = new Product[this.shoppingCart.size()];
            for (int i = 0; i < productShoppingCart.length; i++){
                productShoppingCart[i] = this.shoppingCart.get(i);
            }
            for (int i = 0; i < productShoppingCart.length - 1; i++){
                for (int j = i + 1; j < productShoppingCart.length; j++){
                    if (productShoppingCart[i].getAvgRating() > productShoppingCart[j].getAvgRating()){
                        Product temp = productShoppingCart[i];
                        productShoppingCart[i] = productShoppingCart[j];
                        productShoppingCart[j] = temp;
                    }
                }
            }
            for (int i = 0; i < productShoppingCart.length - 1; i++){
                if (productShoppingCart[i].getAvgRating() == productShoppingCart[i + 1].getAvgRating()){
                    Product temp = productShoppingCart[i];
                    productShoppingCart[i] = productShoppingCart[i + 1];
                    productShoppingCart[i + 1] = temp;
                }
            }
            for (Product product : productShoppingCart) {
                System.out.println(product.toString());
            }
        }
        else if (sortMethod.equals(SortBy.Price)){
            Product[] productShoppingCart = new Product[this.shoppingCart.size()];
            for (int i = 0; i < productShoppingCart.length; i++){
                productShoppingCart[i] = this.shoppingCart.get(i);
            }
            for (int i = 0; i < productShoppingCart.length - 1; i++){
                for (int j = i + 1; j < productShoppingCart.length; j++){
                    if (productShoppingCart[i].getPrice() > productShoppingCart[j].getPrice()){
                        Product temp = productShoppingCart[i];
                        productShoppingCart[i] = productShoppingCart[j];
                        productShoppingCart[j] = temp;
                    }
                }
            }
            for (Product product : productShoppingCart) {
                System.out.println(product.toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        for (int i = 0; i < this.shoppingCart.size(); i++){
            if (this.shoppingCart.get(i).equals(product)){
                this.shoppingCart.remove(i);
                wallet += product.getPrice();
                this.store.transact(product, 1);
                return true;
            }
        }
        return false;
    }
}
