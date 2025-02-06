import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt += 1;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean retaProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
            this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet > product.getPrice()) {
            wallet -= product.getPrice();
            shoppingCart.add(product);
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
        } else if (sortMethod == SortBy.Rating) {
            ArrayList<Product> productArrayList = new ArrayList<Product>();
            for (Product product : shoppingCart) {
                productArrayList.add(product);
            }
            Collections.sort(productArrayList, new Comparator<Product>() {
                public int compare(Product o1, Product o2) {
                    return (int) (o2.getAvgRating()- o1.getAvgRating());
                }
            });
            for (Product product : productArrayList) {
                System.out.println(product.toString());
            }
        } else if (sortMethod == SortBy.Price) {
            ArrayList<Product> productArrayList = new ArrayList<Product>();
            for (Product product : shoppingCart) {
                productArrayList.add(product);
            }
            Collections.sort(productArrayList, new Comparator<Product>() {
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice()- o2.getPrice());
                }
            });
            for (Product product : productArrayList) {
                System.out.println(product.toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        return true;
    }


}
