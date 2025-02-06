import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart ;
    private float wallet;
    private ArrayList<Store> Location1;
    private ArrayList<Product> Location2;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
        Location1 = new ArrayList<>();
        Location2 = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.removeProduct(product)) {
            if (product.getPrice() <= wallet) {
                store.transact(product,0);
                shoppingCart.add(product);
                float price = product.getPrice()*(-1);
                updateWallet(price);
                Location1.add(store);
                Location2.add(product);
                return true;
            }
        }
        // should add the product back if failed!
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (shoppingCart != null && shoppingCart.size() > 0) {
            ArrayList<Product> temp = shoppingCart;
            if (SortBy.Price == sortMethod) {
                temp.sort(Comparator.comparing(Product::getPrice));
                for (Product p : temp) {
                    System.out.println(p.toString());
                }
            }
            if (SortBy.Rating == sortMethod) {
                temp.sort(Comparator.comparing(Product::getAvgRating));
                for (Product p : temp) {
                    System.out.println(p.toString());
                }
            }
            if (SortBy.PurchaseTime == sortMethod) {
                for (Product p : temp) {
                    System.out.println(p.toString());
                }
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            wallet += product.getPrice();
            shoppingCart.remove(product);
            for (int i = 0; i < Location2.size(); i++) {
                if(Location2.get(i)==product)
                    Location1.get(i).transact(product,1);
            }
            return true;
        }
        return false;
    }
}