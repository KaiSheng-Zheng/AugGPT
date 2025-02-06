import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        this.name=name;
        cnt++;
        this.id=cnt;
        this.wallet=wallet;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        if (rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }else {
        return false;
        }
    }

    public void updateWallet(float amount) {
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product)&&this.wallet>= product.getPrice()){
            wallet -= product.getPrice();
            shoppingCart.add(product);
            store.transact(product, 0);
            product.setStore(store);
            return true;
        }else {
        return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> theOperator=new ArrayList<>(shoppingCart);
        if (sortMethod==SortBy.PurchaseTime){
            for (Product product:theOperator){
                System.out.println(product);
            }
        }else if (sortMethod==SortBy.Rating){
            theOperator.sort(Comparator.comparing(Product::getAvgRating));
            for (Product product:theOperator){
                System.out.println(product);
            }
        }else {
            theOperator.sort(Comparator.comparing(Product::getPrice));
            for (Product product:theOperator){
                System.out.println(product);
            }
        }
    }
    public boolean refundProduct(Product product) {
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId()== product.getId()){
                shoppingCart.remove(i);
                updateWallet(product.getPrice());
                product.getStore().transact(product,1);
                product.getStore().addProduct(product);
                return true;
            }
        }
        return false;
    }
}
