import java.util.*;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            this.shoppingCart.add(product);
            store.transact(product, 0);
            this.updateWallet(product.getPrice()*-1);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> shoppingCartCopy = this.shoppingCart;
        switch (sortMethod) {
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            case Rating:
                Collections.sort(shoppingCartCopy, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return (int) (o1.getAvgRating() - o2.getAvgRating());
                    }
                });
                for (int i = 0; i < shoppingCartCopy.size(); i++) {
                    System.out.println(shoppingCartCopy.get(i));
                }
                break;
            case Price:
                Collections.sort(shoppingCartCopy, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return (int) (o1.getPrice() - o2.getPrice());
                    }
                });
                for (int i = 0; i < shoppingCartCopy.size(); i++) {
                    System.out.println(shoppingCartCopy.get(i));
                }
                break;
        }
    }

    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            this.shoppingCart.remove(product);
            this.updateWallet(product.getPrice());
            product.productsource.get(0).transact(product, 1);
            return true;
        } else {
            return false;
        }
    }
}
