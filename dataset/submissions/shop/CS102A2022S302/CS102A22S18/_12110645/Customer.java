import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean check1 = store.getProductList().contains(product);
        if (check1 && this.wallet >= product.getPrice()) {
            store.getProductList().remove(product);
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            float x = store.getIncome();
            store.setIncome(x + product.getPrice());
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> newProducts = new ArrayList<>(shoppingCart);
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product newProduct : newProducts) {
                System.out.println(newProduct);
            }
        } else if (sortMethod == SortBy.Rating) {
            newProducts.sort(new Rating());
            for (Product newProduct : newProducts) {
                System.out.println(newProduct);
            }
        } else if (sortMethod == SortBy.Price) {
            newProducts.sort(new Price());
            for (Product newProduct : newProducts) {
                System.out.println(newProduct);
            }
        }
    }

    public boolean refundProduct(Product product) {
        return false;
    }
}
class Rating implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getAvgRating()-(o2.getAvgRating()));
    }
}
class Price implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice()-(o2.getPrice()));
    }
}

