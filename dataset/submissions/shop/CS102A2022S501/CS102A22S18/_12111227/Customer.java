import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>(); 
    private ArrayList<Store> stores = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        id = ++cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }else {
            return false;
        }
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            updateWallet(-product.getPrice());
            store.transact(product,0);
            shoppingCart.add(product);
            products.add(product);
            stores.add(store);
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
        
        ArrayList<Product> shoppingCart1 = new ArrayList<>();
        shoppingCart1.addAll(shoppingCart);
        
        if(sortMethod == SortBy.Rating){
            for (int i = 0; i < shoppingCart1.size(); i++) {
                boolean change = false;
                for (int j = 0; j < shoppingCart1.size()-i-1; j++) {
                    if(shoppingCart1.get(j).getAvgRating() > shoppingCart1.get(j+1).getAvgRating()){
                        Product product = shoppingCart1.get(j);
                        shoppingCart1.set(j,shoppingCart1.get(j+1));
                        shoppingCart1.set(j+1,product);
                        change = true;
                    }
                }
                if(change == false){
                    break;
                }
            }
            for (int i = 0; i < shoppingCart1.size(); i++) {
                System.out.println(shoppingCart1.get(i));
            }
        }

        if(sortMethod == SortBy.Price){
            for (int i = 0; i < shoppingCart1.size(); i++) {
                boolean change1 = false;
                for (int j = 0; j < shoppingCart1.size()-i-1; j++) {
                    if(shoppingCart1.get(j).getPrice() > shoppingCart1.get(j+1).getPrice()){
                        Product product = shoppingCart1.get(j);
                        shoppingCart1.set(j,shoppingCart1.get(j+1));
                        shoppingCart1.set(j+1,product);
                        change1 = true;
                    }
                }
                if(change1 == false){
                    break;
                }
            }
            for (int i = 0; i < shoppingCart1.size(); i++) {
                System.out.println(shoppingCart1.get(i));
            }
        }
    }

   public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            stores.get(products.indexOf(product)).transact(product,1);
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }else {
            return false;
        }
    }
}
