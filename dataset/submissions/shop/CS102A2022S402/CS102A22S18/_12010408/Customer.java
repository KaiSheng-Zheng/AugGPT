import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Store> shopId;

    public Customer(String name, float wallet) {
        ++cnt;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
        this.shoppingCart = new ArrayList<>();
        this.shopId = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && this.wallet >= product.getPrice()){
            this.shoppingCart.add(product);
            store.transact(product,0);
            this.wallet -= product.getPrice();
            this.shopId.add(store);
            return true;
        }else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        int n = this.shoppingCart.size();
        if (n == 0)return;
        if (sortMethod == SortBy.PurchaseTime){
            for (Product product : this.shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod == SortBy.Rating){
            ArrayList<Product> rat = new ArrayList<>(this.shoppingCart);
            for (int i = 1; i < n; i++){
                for (int j = i - 1; j >= 0; j--){
                    if (rat.get(j + 1).getAvgRating() < rat.get(j).getAvgRating()){
                        Product a = rat.get(j + 1);
                        rat.set(j + 1, rat.get(j));
                        rat.set(j, a);
                    }
                }
            }
            for (Product product : rat) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod == SortBy.Price){
            ArrayList<Product> rat = new ArrayList<>(this.shoppingCart);
            for (int i = 1; i < n; i++){
                for (int j = i - 1; j >= 0; j--){
                    if (rat.get(j + 1).getPrice() < rat.get(j).getPrice()){
                        Product a = rat.get(j + 1);
                        rat.set(j + 1, rat.get(j));
                        rat.set(j, a);
                    }
                }
            }
            for (Product product : rat) {
                System.out.println(product.toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        int n = this.shoppingCart.size();
        if (n == 0) return false;
        for (int i = 0; i < n; i++){
            if (this.shoppingCart.get(i).getId() == product.getId()){
                this.shopId.get(i).transact(product,1);
                this.shopId.remove(i);
                this.shoppingCart.remove(i);
                this.wallet += product.getPrice();
                return true;
            }
        }
        return false;
    }
}
