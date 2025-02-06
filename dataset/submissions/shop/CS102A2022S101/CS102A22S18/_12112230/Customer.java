import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>(); // The list of purchased products;default is
                                                                        // empty.
    private float wallet = (float) 0;

    public Customer(String name, float wallet) {
        id = ++cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        System.out.println(wallet);
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            product.fromstore = store;
            store.setIncome(product.getPrice());
            wallet -= product.getPrice();
            store.removeProduct(product);
            shoppingCart.add(product);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            case Rating:
                List<Product> newList = new ArrayList<>(shoppingCart);
                Collections.sort(newList, Product.ProRatings);
                for (Product product : newList) {
                    System.out.println(product.toString());
                }
                break;
            case Price:
                List<Product> nList = new ArrayList<>(shoppingCart);
                Collections.sort(nList, Product.ProPrice);
                for (Product product : nList) {
                    System.out.println(product.toString());
                }
                break;
            default:
                break;
        }
    }

    public boolean refundProduct(Product product) {
       for (Product prod : shoppingCart) {
            if (prod.getId()==product.getId()) {
                product.fromstore.transact(product, 1);
                wallet += product.getPrice();
                shoppingCart.remove(prod);
                return true;
            }
       }
       return false;
    }

}
