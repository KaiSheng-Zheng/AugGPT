import java.util.ArrayList;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (!store.hasProduct(product) || wallet < product.getPrice())
            return false;
        product.lastStore = store;
        store.transact(product, 0);
        shoppingCart.add(product);
        updateWallet(-product.getPrice());
        return true;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean refundProduct(Product product) {
        if (!boughtProduct(product))
            return false;
        shoppingCart.remove(product);
        updateWallet(product.getPrice());
        product.lastStore.transact(product, 1);
        product.lastStore = null;
        return true;
    }

    public boolean boughtProduct(Product product) { //////
        for (Product value : shoppingCart) {
            if (value.getId() == product.getId())
                return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> sortList = sort(sortMethod);
        for (Product product : sortList)
            System.out.println(product.toString());
    }

    public ArrayList<Product> sort(SortBy sortMethod) {
        ArrayList<Product> sortList = new ArrayList<>(shoppingCart);
        for (int i = 1; i < sortList.size(); i++) {
            for (int j = 0; j < sortList.size() - 1; j++) {
                if ((sortMethod == SortBy.Rating && sortList.get(j).getAvgRating() > sortList.get(j + 1).getAvgRating())
                        || (sortMethod == SortBy.Price && sortList.get(j).getPrice() > sortList.get(j + 1).getPrice())) {
                    Product temp = sortList.get(j);
                    sortList.set(j, sortList.get(j + 1));
                    sortList.set(j + 1, temp);
                }
            }
        }
        return sortList;
    }
}

