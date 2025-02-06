import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;default is empty.
    private int bought;
    private float wallet;

    public Customer(String name, float wallet){
        this.id=++cnt;
        this.name=name;
        this.wallet=wallet;
        this.bought=0;
    }

    public boolean rateProduct(Product product, int rating){
        if(rating<=5&&rating>=1){
            product.setRating(rating);
            return true;
        }
        else return false;
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && this.wallet>=product.getPrice()){
            this.updateWallet(-product.getPrice());
            this.shoppingCart.add(product);
            store.transact(product,0);
            ++this.bought;
            product.setTime(this.bought);
            return true;
        }else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> cache = new ArrayList<>();
        for (Product p : this.shoppingCart) {
            cache.add(p);
        }
        if(sortMethod.equals(SortBy.Price)){
            cache.sort(price.thenComparing(timing));
        }
        if(sortMethod.equals(SortBy.Rating)){
            cache.sort(rating.thenComparing(timing));
        }
        if(sortMethod.equals(SortBy.PurchaseTime)){
            cache.sort(timing);
        }
        if (cache.size()!=0) {
            for (Product pro : cache) {
                System.out.println(pro);
            }
        }
    }




    Comparator price = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return Float.compare(o1.getPrice(), o2.getPrice());
        }
    };

    Comparator rating = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return Float.compare(o1.getAvgRating(), o2.getAvgRating());
        }
    };

    Comparator timing = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return Integer.compare(o1.getTime(), o2.getTime());
        }
    };


    public boolean refundProduct(Product product){
        if(this.hasProduct(product)){
            this.updateWallet(product.getPrice());
            this.shoppingCart.remove(product);
            product.getSoldIn().transact(product,1);
            return true;
        }else return false;
    }

    public boolean hasProduct(Product product){
        return this.shoppingCart.contains(product);
    }




}
