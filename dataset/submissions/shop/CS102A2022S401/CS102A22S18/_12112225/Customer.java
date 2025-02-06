import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 1; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
        this.id = cnt;
        cnt++;
    }

    public boolean rateProduct(Product product, int rating){
        if (rating < 1 || rating > 5) return false;
        product.setRating(rating);
        return true;
    }

    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet > product.getPrice()){
            store.transact(product, 0);
            shoppingCart.add(product);
            wallet -= product.getPrice();
            return true;
        } else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Rating:
                ArrayList<Product> copyList = new ArrayList<>(shoppingCart);
                copyList.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getAvgRating() - o2.getAvgRating() > 0) return 1;
                        else if (o1.getAvgRating() - o2.getAvgRating() == 0) return 0;
                        else return -1;
                    }
                });
                for (int i = 0; i < copyList.size(); i++) {
                    System.out.println(copyList.get(i).toString());
                }
                break;
            case Price:
                ArrayList<Product> copyList2 = new ArrayList<>(shoppingCart);
                copyList2.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice() - o2.getPrice() > 0) return 1;
                        else if (o1.getPrice() - o2.getPrice() == 0) return 0;
                        else return -1;
                    }
                });
                for (int i = 0; i < copyList2.size(); i++) {
                    System.out.println(copyList2.get(i).toString());
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        if (!shoppingCart.contains(product))
            return false;
        shoppingCart.remove(product);
        wallet += product.getPrice();
        product.getStore().transact(product, 1);
        return true;
    }

}
