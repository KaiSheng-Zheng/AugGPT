import java.util.*;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
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
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        int count = 0;
        for (int i = 0; i < store.getProductList().size(); i++) {
            if (product.getId() == store.getProductList().get(i).getId() && product.getPrice() <= wallet) {
                wallet -= product.getPrice();
                shoppingCart.add(product);
                store.transact(product, 0);
                count++;
                break;
            }
        }
        if (count != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        List<Product> list = shoppingCart;
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } else if (sortMethod == SortBy.Rating) {
            Collections.sort(list, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) o1.getAvgRating() * 1000 - (int) o2.getAvgRating() * 1000;
                }
            });
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } else if (sortMethod == SortBy.Price) {
            Collections.sort(list, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) o1.getPrice() * 1000 - (int) o2.getPrice() * 1000;
                }
            });
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }

    }
    public boolean refundProduct(Product product){
        return true;
    }

}

