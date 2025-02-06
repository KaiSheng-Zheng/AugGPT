import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<Product>();
    }

    public boolean rateProduct(Product product, int rating){
        boolean setRating;
        if (rating<1 || rating>5){
            setRating = false;
        } else {
            product.setRating(rating);
            setRating = true;
        }
        return setRating;
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && this.wallet>=product.getPrice()){
            store.transact(product,0);
            this.wallet -= product.getPrice();
            this.shoppingCart.add(product);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.Price){
            for (int i = 0; i < shoppingCart.size()-1; i++) {
                for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                    if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice()) {
                        Product tempProduct = shoppingCart.get(j);
                        shoppingCart.set(j, shoppingCart.get(j + 1));
                        shoppingCart.set(j + 1, tempProduct);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        } else if (sortMethod==SortBy.Rating) {
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                    if (shoppingCart.get(j).getAvgRating() > shoppingCart.get(j + 1).getAvgRating()) {
                        Product tempProduct = shoppingCart.get(j);
                        shoppingCart.set(j, shoppingCart.get(j + 1));
                        shoppingCart.set(j + 1, tempProduct);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        } else if (sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }

    }

    public boolean customerHasProduct(Product product){
        if (this.shoppingCart.contains(product)){
            return true;
        } else {
            return false;
        }
    }

    public boolean refundProduct(Product product){
        return true;
    }

}
