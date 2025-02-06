import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        id = ++ cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if (rating >= 1 && rating <= 5){
            product.setRating(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.getProductList().contains(product) && wallet >= product.getPrice()){
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            return true;
        }
        else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod == SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        ArrayList<Product> shoppingCart1 = new ArrayList<>();
        if (sortMethod == SortBy.Rating){
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i+1; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getAvgRating() <= shoppingCart.get(j).getAvgRating()){
                        shoppingCart1.add(shoppingCart.get(i));
                    }
            }
            }
            for (int k = 0; k < shoppingCart1.size(); k++) {
                System.out.println(shoppingCart1.get(k).toString());
            }
        }
        if (sortMethod == SortBy.Price){
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i+1; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getPrice() <= shoppingCart.get(j).getPrice()){
                        shoppingCart1.add(shoppingCart.get(i));
                    }
                }
            }
            for (int i = 0; i < shoppingCart1.size(); i++) {
                System.out.println(shoppingCart1.get(i).toString());
            }
        }
    }

   
}
