import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        id=cnt+1;
        cnt++;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return (product.setRating(rating));
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (product.getPrice()>wallet){
            return false;
        }
        boolean result;
        result=store.removeProduct(product);
        if(result){
            store.transact(product,0);
            this.wallet-=product.getPrice();
            this.shoppingCart.add(product);
        }
        return result;
    }


    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            case Rating:
                Product[] copy1=new Product[shoppingCart.size()];
                for (int i = 0; i < this.shoppingCart.size(); i++) {
                    copy1[i]=shoppingCart.get(i);
                }
                Arrays.sort(copy1,new SortByRating());
                for (int i = 0; i < copy1.length; i++) {
                    System.out.println(copy1[i].toString());
                }
                break;
            case Price:
                Product[] copy2=new Product[shoppingCart.size()];
                for (int i = 0; i < this.shoppingCart.size(); i++) {
                    copy2[i]=shoppingCart.get(i);
                }
                Arrays.sort(copy2,new SortByPrice());
                for (int i = 0; i < copy2.length; i++) {
                    System.out.println(copy2[i].toString());
                }
                break;
        }
    }


    public boolean refundProduct(Product product){
        return false;
    }
    private class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2){
            if (p2.getAvgRating()<=p1.getAvgRating()){
                return 1;
            }
            return -1;
        }
    }
    private class SortByPrice implements Comparator<Product>{
        @Override
        public int compare(Product p1, Product p2){
            if (p2.getPrice()<=p1.getPrice()){
                return 1;
            }
            return -1;
        }
    }
}
