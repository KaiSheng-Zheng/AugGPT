import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
            if (rating>=1&&rating<=5){
                product.getRatings().add(rating);
                return true;
            }else return false;
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && getWallet()>= product.getPrice()){
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.removeProduct(product);
            store.setIncome(store.getIncome()+product.getPrice());
            return true;
        }else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }else if (sortMethod.equals(SortBy.Price)){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice()-o2.getPrice());
                }
            });
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }else if (sortMethod.equals(SortBy.Rating)){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return Float.compare(o1.getAvgRating(),o2.getAvgRating());
                }
            });
            for (Product product : shoppingCart){
                System.out.println(product.toString());
            }
        }

    }
    public boolean refundProduct(Product product){
        return true;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Customer.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }
}
