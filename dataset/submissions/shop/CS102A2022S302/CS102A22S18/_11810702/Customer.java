import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private ArrayList<Store> shoppingStore;
    private float wallet;

    public Customer(String name, float wallet) {
        id = ++cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
        shoppingStore = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    };
    public void updateWallet(float amount){
        wallet += amount;
    };
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            store.transact(product,0);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            shoppingStore.add(store);
            return true;
        }
        return false;
    };
    public void viewShoppingCart(SortBy sortMethod){
        // PurchaseTime, Rating, Price
        ArrayList<Product> tmp = new ArrayList<>(shoppingCart);
        switch (sortMethod) {
            case Rating:
                tmp.sort((p1, p2) -> (int) (p1.getAvgRating()-p2.getAvgRating()));
                break;
            case Price:
                tmp.sort((p1, p2) -> (int) (p1.getPrice()-p2.getPrice()));
        }
        for (Product p:
                tmp) {
            System.out.println(p.toString());
        }
    };
    public boolean refundProduct(Product product){
        // find which store
        if (shoppingCart.contains(product)){
            Store store = shoppingStore.get(shoppingCart.indexOf(product));
            store.transact(product,1);
            wallet+=product.getPrice();
            shoppingStore.remove(store);
            shoppingCart.remove(product);
            return true;
        }
        return false;
    };
}