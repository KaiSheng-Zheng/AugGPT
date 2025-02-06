import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {

    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;

    public static void main(String[] args) {
        Product x = new Product("milk",20);
        Product y = new Product("heyya",30);
        Product z = new Product("lol",10);

        Store x1 = new Store("walmart");
        x1.addProduct(x);
        x1.addProduct(y);
        x1.addProduct(z);

        Customer John = new Customer("John",30);
        Customer Lee = new Customer("John",100);
        Customer Jack = new Customer("John",100);


//        John.rateProduct(x,5);
//        John.rateProduct(y,1);
//        John.rateProduct(z,3);
//
//        Lee.rateProduct(x,5);
//        Lee.rateProduct(y,1);
//        Lee.rateProduct(x,3);
//
//        Jack.rateProduct(x,5);
//        Jack.rateProduct(y,1);
//        Jack.rateProduct(x,3);

        John.purchaseProduct(x1,x);
//        John.purchaseProduct(x1,y);
//        John.purchaseProduct(x1,z);


        John.viewShoppingCart(SortBy.Price);
        System.out.println(x.getAvgRating());
    }

    public Customer(String name, float wallet){
        cnt++;
        this.id= cnt;
        this.name=name;
        if(wallet>=0){
            this.wallet=wallet;
        }

    };

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);

    };

    public void updateWallet(float amount){
        this.wallet=wallet +amount;
    };

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&& wallet> product.getPrice()){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            return true;
        } else {
            return false;
        }
    };

    public void viewShoppingCart(SortBy sortMethod){

        if(sortMethod==SortBy.Price){
            Collections.sort(shoppingCart, (s1, s2) -> Float.compare(s1.getPrice(), s2.getPrice()));
            for(Product x:shoppingCart){
                System.out.println(x);
            }
        }else if(sortMethod==SortBy.Rating){
            Collections.sort(shoppingCart, (s1, s2) -> Float.compare(s1.getAvgRating(), s2.getAvgRating()));
            for(Product x:shoppingCart){
                System.out.println(x);
            }
        } else if(sortMethod==SortBy.PurchaseTime){
            for(Product x:shoppingCart){
                System.out.println(x);
            }
        }

    };

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            updateWallet(product.getPrice());
            shoppingCart.remove(product);

            return true;
        }else {
            return false;
        }

    };

}