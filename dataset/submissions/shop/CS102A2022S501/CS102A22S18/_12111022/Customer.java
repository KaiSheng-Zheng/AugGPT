import java.util.ArrayList;
public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && this.wallet >= product.getPrice()){
            shoppingCart.add(product);
            product.setStore(store);
            product.getStore().transact(product,0);
            this.wallet -= product.getPrice();
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shopping = shoppingCart;
        if (sortMethod == SortBy.Rating){
            for (int i = 0; i<shoppingCart.size()-1; i++){
                for (int j = 0; j<shoppingCart.size()-1-i; j++){
                    if (shoppingCart.get(j).getAvgRating()>shoppingCart.get(j+1).getAvgRating()){
                        Product temp = shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,temp);
                    }
                }
            }

        }
        if (sortMethod == SortBy.Price){
            for (int i = 0; i<shoppingCart.size()-1; i++){
                for (int j = 0; j<shoppingCart.size()-1-i; j++){
                    if (shoppingCart.get(j).getPrice()>shoppingCart.get(j+1).getPrice()){
                        Product temp = shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,temp);
                    }
                }
            }
        }
        for (Product product : shoppingCart) {
            System.out.println(product);
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            product.getStore().transact(product,1);
            this.wallet+=product.getPrice();
            return true;
        }
        else {
            return false;
        }
    }
}
