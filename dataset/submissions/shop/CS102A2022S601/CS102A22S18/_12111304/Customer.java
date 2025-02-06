import java.util.*;

public class Customer {

    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        cnt += 1;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> purchase = new ArrayList<>();
        purchase.addAll(shoppingCart);
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        } else if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < purchase.size(); i++) {
                purchase.get(i).setSortMethod(SortBy.Rating);
            }
            Collections.sort(purchase);
            for (int i = 0; i < purchase.size(); i++) {
                System.out.println(purchase.get(i));
            }
        } else if (sortMethod == SortBy.Price) {
            for (int i = 0; i < purchase.size(); i++) {
                purchase.get(i).setSortMethod(SortBy.Price);
            }
            Collections.sort(purchase);
            for (int i = 0; i < purchase.size(); i++) {
                System.out.println(purchase.get(i));
            }
        }
    }

    public boolean refundProduct(Product product) {
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId()==product.getId()){
                product.getStore().transact(product,1);
                wallet+=product.getPrice();
                shoppingCart.remove(i);
                return true;
            }
        }
        return false;
    }
}