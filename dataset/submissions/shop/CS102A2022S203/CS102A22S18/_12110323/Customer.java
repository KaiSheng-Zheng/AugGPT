import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id=cnt;
        this.shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)){
            return true;
        }
        return false;
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && (wallet>product.getPrice())){
            this.wallet-=product.getPrice();
            shoppingCart.add(product);
            store.removeProduct(product);
            store.setIncome(store.getIncome()+product.getPrice());
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod){

        if (sortMethod==SortBy.PurchaseTime){
            for (Product i:shoppingCart){
                System.out.println(i);
            }
        }
        else if (sortMethod==SortBy.Rating){
            Collections.sort(shoppingCart,new SortByRating());
            for (Product i:shoppingCart){
                System.out.println(i);
            }
        }
        else if (sortMethod==SortBy.Price){
            Collections.sort(shoppingCart,new SortByPrice());
            for (Product i:shoppingCart){
                System.out.println(i);
            }
        }
    }

    public boolean refundProduct(Product product){
        for (Product i:shoppingCart){
            if (i==product){
                this.wallet+=product.getPrice();
                shoppingCart.remove(product);
                return true;
            }
        }
        return false;

    }

}

enum SortBy {
    PurchaseTime, Rating, Price
}

class SortByRating implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getAvgRating()>o2.getAvgRating()){
            return 1;
        }
        return -1;
    }
}

class SortByPrice implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice()>o2.getPrice()){
            return 1;
        }
        return -1;
    }
}
