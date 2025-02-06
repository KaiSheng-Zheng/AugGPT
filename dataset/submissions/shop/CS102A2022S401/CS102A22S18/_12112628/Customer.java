import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private final int id;
    private final String name;
    private final ArrayList<Product> shoppingCart = new ArrayList<>();
    private final ArrayList<Store> storeRecord = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        ++cnt;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (!store.hasProduct(product) || wallet < product.getPrice())
            return false;
        store.transact(product, 0);
        wallet -= product.getPrice();
        shoppingCart.add(product);
        storeRecord.add(store);
        return true;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> viewList = new ArrayList<>(shoppingCart);
        //default by time
        if (sortMethod == SortBy.Rating) {
            viewList.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    float result =  o1.getAvgRating() - o2.getAvgRating();
                    if (result > 0)
                        return 1;
                    else if (result < 0)
                        return -1;
                    else
                        return 0;
                }
            });
        }
        else if (sortMethod == SortBy.Price) {
            viewList.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    float result =  o1.getPrice() - o2.getPrice();
                    if (result > 0)
                        return 1;
                    else if (result < 0)
                        return -1;
                    else
                        return 0;
                }
            });
        }

        for (Product product : viewList) {
            System.out.println(product.toString());
        }
    }

    public boolean refundProduct(Product product) {
        int index;
        if ((index = shoppingCart.indexOf(product)) == -1)
            return false;
        Store store = storeRecord.get(index);
        store.transact(product, 1);
        wallet += product.getPrice();
        shoppingCart.remove(index);
        storeRecord.remove(index);
        return true;
    }
}
