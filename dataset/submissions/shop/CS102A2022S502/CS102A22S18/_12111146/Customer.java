import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<ShoppingCart> shoppingCarts = new ArrayList<>();

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        ShoppingCart shoppingCart1 = new ShoppingCart(store, product);
        this.shoppingCarts.add(shoppingCart1);
        boolean have = store.getProductList().contains(product);
        if (wallet >= product.getPrice() && have) {
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            shoppingCart.add(product);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {

        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }

        if (sortMethod == SortBy.Rating) {
            ArrayList<Product> copy2 = new ArrayList<>(shoppingCart);

            float[] rating = new float[shoppingCart.size()];

            for (int i = 0; i < shoppingCart.size(); i++) {
                rating[i] = shoppingCart.get(i).getAvgRating();
            }

            Arrays.sort(rating);

            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = 0; j < copy2.size(); j++) {
                    if (rating[i] == copy2.get(j).getAvgRating()) {
                        System.out.println(copy2.get(j).toString());
                        copy2.remove(j);
                    }
                }
            }
        }
        if (sortMethod == SortBy.Price) {
            ArrayList<Product> copy1 = new ArrayList<>(shoppingCart);

            float[] price = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                price[i] = shoppingCart.get(i).getPrice();
            }
            Arrays.sort(price);

            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = 0; j < copy1.size(); j++) {
                    if (price[i] == copy1.get(j).getPrice()){
                        System.out.println(copy1.get(j).toString());
                        copy1.remove(j);
                    }
                }
            }

        }

    }

    public boolean productInShoppingCart(Product product) {
        for (Product product1 : shoppingCart) {
            if (product.equals(product1)) {
                return true;
            }
        }
        return false;
    }

    public boolean refundProduct(Product product){
        if (shoppingCarts.size() == 0 || !productInShoppingCart(product)){
            return false;
        } else if (productInShoppingCart(product)){
            for (int i = 0; i < shoppingCarts.size(); i++) {
                if (product.equals(shoppingCarts.get(i).getProduct())){
                    updateWallet(product.getPrice());
                    shoppingCart.remove(product);//////////
                    shoppingCarts.get(i).getStore().transact(product,1);
                    return true;
                }
            }
        }
        return false;
    }



}

class ShoppingCart{
    private Store store;
    private Product product;
    public ShoppingCart(Store store, Product product){
        this.product = product;
        this.store = store;
    }
    public Store getStore(){
        return store;
    }
    public Product getProduct(){
        return product;
    }
}


enum SortBy {
    PurchaseTime, Rating, Price
}
       