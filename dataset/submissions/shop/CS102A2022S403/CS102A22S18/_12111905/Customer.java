import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (wallet>= product.getPrice()&&store.getProductList().contains(product)){
            store.transact(product,0);
            product.from = store;
            shoppingCart.add(product);
            updateWallet(-1* product.getPrice());
            return true;
        }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> cart = new ArrayList<>();
        cart.addAll(shoppingCart);
        switch (sortMethod){
            case Price:{
                cart.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice()<o2.getPrice()){
                            return -1;
                        }else return 1;
                    }
                });
                for (Product product : cart) {
                    System.out.println(product);
                }
                break;
            }
            case Rating:{
                cart.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getAvgRating()<o2.getAvgRating()){
                            return -1;
                        }else return 1;
                    }
                });
                for (Product product : cart) {
                    System.out.println(product);
                }
                break;
            }
            case PurchaseTime:{
                for (Product product : cart) {
                    System.out.println(product);
                }
                break;
            }
            }
        }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            product.from.transact(product,1);
            shoppingCart.remove(product);
            wallet=wallet+product.getPrice();
            return true;
        }else {
            return false;
        }
    }

}