import java.util.ArrayList;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();// The list of purchased products; default is empty.
    private ArrayList<Integer> ratesOfShoppingCartProducts = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        ratesOfShoppingCartProducts.add(rating);
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && (product.getPrice() <= wallet)) {
            //store.transact(product, 0);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            store.removeProduct(product);
            store.setIncome(store.getIncome()+product.getPrice());
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.Rating) {
            shoppingCart.sort((product1, product2) -> {
                if (product1.getAvgRating() > product2.getAvgRating())
                    return 1;
                if (product1.getAvgRating() < product2.getAvgRating())
                    return -1;
                return 0;
            });
        }
        if (sortMethod == SortBy.Price) {
            shoppingCart.sort((product1, product2) -> {
                if (product1.getPrice() > product2.getPrice())
                    return 1;
                if (product1.getPrice() < product2.getPrice())
                    return -1;
                return 0;
            });
        }
        for(Product product : shoppingCart){
            System.out.println(product.toString());
        }
    }

    public boolean refundProduct(Product product) {
        return true;
    }
}