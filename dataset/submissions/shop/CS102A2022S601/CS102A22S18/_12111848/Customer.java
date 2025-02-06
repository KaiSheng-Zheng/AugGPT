import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        ++cnt;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }else {
            return false;
        }
    }
    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            shoppingCart.add(product);
            this.wallet -= product.getPrice();
            store.transact(product,0);
            product.store = store;
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }if(sortMethod.equals(SortBy.Rating)){
            ArrayList<Product> productsRating = new ArrayList<>(shoppingCart);
            for(int i = 0;i < productsRating.size() - 1;i++){
                for(int j = 0;j < productsRating.size() - 1 - i;j++){
                    if(productsRating.get(j).getAvgRating() > productsRating.get(j + 1).getAvgRating()){
                        Product product1 = productsRating.get(j);
                        productsRating.set(j,productsRating.get(j+1));
                        productsRating.set(j + 1,product1);
                    }
                }
            }
            for( int i = 0;i < productsRating.size();i++) {
                System.out.println(productsRating.get(i).toString());
            }
        }if(sortMethod.equals(SortBy.Price)){
            ArrayList<Product> productsPrice = new ArrayList<>(shoppingCart);
            for(int i = 0;i < shoppingCart.size() - 1;i++){
                for(int j = 0;j < shoppingCart.size() - 1 - i;j++){
                    if(productsPrice.get(j).getPrice() > productsPrice.get(j + 1).getPrice()){
                        Product product1 = productsPrice.get(j);
                        productsPrice.set(j,productsPrice.get(j+1));
                        productsPrice.set(j + 1,product1);
                    }
                }
            }
            for( int i = 0;i < productsPrice.size();i++) {
                System.out.println(productsPrice.get(i).toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            product.store.transact(product,1);
            return true;
        }else {
            return false;
        }
    }
}
