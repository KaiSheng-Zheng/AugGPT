import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products default is empty.;
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&this.wallet>= product.getPrice()){
            shoppingCart.add(product);
            store.transact(product,0);
            updateWallet(-product.getPrice());
            product.RNM=store;
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product:this.shoppingCart){
                System.out.println(product.toString());
            }
        }else if (sortMethod.equals(SortBy.Rating)){
            this.shoppingCart.sort(new Comparator<Product>() {
                public int compare(Product p1,Product p2){
                    if(p1.getAvgRating() > p2.getAvgRating()) {return 1;}
                    else if (p1.getAvgRating() == p2.getAvgRating()){return 0;}
                    return -1;
                }
            });
                for (Product product:this.shoppingCart){
                    System.out.println(product.toString());
                }
            }
        else {this.shoppingCart.sort(new Comparator<Product>() {
            public int compare(Product p1,Product p2){
                if (p1.getPrice() > p2.getPrice()) return 1;
                else if (p1.getPrice() == p2.getPrice()) return 0;
                else return -1;
            }
        });
            for (Product product:this.shoppingCart){
                System.out.println(product.toString());
            }

        }
        }public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+=product.getPrice();
            product.RNM.transact(product,1);
            return true;
        }else {
            return false;
        }
    }
}



