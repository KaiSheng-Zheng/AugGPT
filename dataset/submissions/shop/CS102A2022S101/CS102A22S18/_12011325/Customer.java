import java.util.ArrayList;
import java.util.Objects;
public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt = cnt + 1;
        id = cnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean rateProduct(Product product, int rating) {
        boolean b = false;
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5)
            b = true;
        if (b) {
            product.setRating(rating);
        }
        return b;
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            wallet = wallet - product.getPrice();
            shoppingCart.add(product);
            store.removeProduct(product);
            store.addIncome(product.getPrice());
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < shoppingCart.size(); i++) {
               for (int j = i + 1; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getAvgRating() > shoppingCart.get(j).getAvgRating()) {
                        Product temp = shoppingCart.get(j);
                        shoppingCart.set(j, shoppingCart.get(i));
                        shoppingCart.set(i, temp);
                   }
                }
            }
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod == SortBy.Price) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i + 1; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getPrice() > shoppingCart.get(j).getPrice()) {
                        Product temp = shoppingCart.get(j);
                        shoppingCart.set(j, shoppingCart.get(i));
                        shoppingCart.set(i, temp);
                    }
                }
            }
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        if(this.shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet = wallet+ product.getPrice();
        return true;
        }else
            return false;
    }
}

enum SortBy {
    PurchaseTime, Rating, Price
}

