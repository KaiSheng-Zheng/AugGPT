import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id = 0;
    private String name = "";
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet = 0;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product, 0);
            return true;
        }
        else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod == SortBy.PurchaseTime){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod == SortBy.Rating){
            ArrayList<Product> shoppingCartCopy = shoppingCart;
            for (int i = 1; i < shoppingCartCopy.size(); i++){
                Product carryValue = shoppingCartCopy.get(i);
                int position = i;
                while (position > 0 && carryValue.getAvgRating() <= shoppingCartCopy.get(i).getAvgRating()) {
                    if (carryValue.getAvgRating() == shoppingCartCopy.get(i).getAvgRating()) {
                        break;
                    }
                    else {
                        shoppingCartCopy.set(position, shoppingCartCopy.get(position-1));
                        position--;
                    }
                }
                shoppingCartCopy.set(position, carryValue);
            }
            for (Product product : shoppingCartCopy) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod == SortBy.Price){
            ArrayList<Product> shoppingCartCopy = shoppingCart;
            for (int i = 1; i < shoppingCartCopy.size(); i++){
                Product carryValue = shoppingCartCopy.get(i);
                int position = i;
                while (position > 0 && carryValue.getPrice() <= shoppingCartCopy.get(i).getPrice()) {
                    if (carryValue.getPrice() == shoppingCartCopy.get(i).getPrice()) {
                        break;
                    }
                    else {
                        shoppingCartCopy.set(position, shoppingCartCopy.get(position-1));
                        position--;
                    }
                }
                shoppingCartCopy.set(position, carryValue);
            }
            for (int i = 0; i < shoppingCartCopy.size(); i++){
                System.out.println(shoppingCartCopy.get(i).toString());
            }
        }
    }
}