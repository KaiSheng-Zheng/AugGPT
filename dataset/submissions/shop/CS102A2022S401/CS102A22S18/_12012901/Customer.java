import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
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
        if (1 <= rating && rating <= 5) {
            product.setRating(rating);
            return true;
        }
        return false;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= wallet) {
            store.transact(product,0);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> orderProd = new ArrayList<>();
        for (Product product : shoppingCart) {
            orderProd.add(product);
        }
        switch (sortMethod) {
            case PurchaseTime -> {

            }
            case Rating -> {
                orderProd.sort((o1, o2) -> Float.compare(o1.getAvgRating(), o2.getAvgRating()));
            }
            case Price -> {
                orderProd.sort((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()));
            }
        }
        for (Product product : orderProd)
            System.out.println(product);
    }

    public boolean refundProduct(Product product) {
        if(shoppingCart.contains(product)){
            product.getSellFrom().transact(product,1);
            shoppingCart.remove(product);
            wallet += product.getPrice();
            return true;
        }
        return false;
    }

}
