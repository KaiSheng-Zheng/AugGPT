import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private final int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private static int time=0;
    public Customer(String name,float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
        shoppingCart=new ArrayList<>();
    }
    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        if (!store.hasProduct(product)){
            return false;
        }
        if (wallet<product.getPrice()){
            return false;
        }
        wallet-=product.getPrice();
        store.transact(product,0);
        shoppingCart.add(product);
        time++;
        product.setTime(time);
        return true;
    }
    public void viewShoppingCart(SortBy sortBy){
        ArrayList<Product> shoppingcart = new ArrayList<>(shoppingCart);
        switch (sortBy){
            case Price:
                Collections.sort(shoppingcart, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice()>o2.getPrice()){
                            return 1;
                        };
                        if (o1.getPrice()<o2.getPrice()){
                            return -1;
                        }
                        //if (o1.getPrice()==o2.getPrice()){
                        //    return o1.getTime()-o2.getTime();
                        //}
                        return 0;
                    }
                });
                break;
            case Rating:
                Collections.sort(shoppingcart, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getAvgRating()>o2.getAvgRating()){
                            return 1;
                        };
                        if (o1.getAvgRating()<o2.getAvgRating()){
                            return -1;
                        }
                        //if (o1.getAvgRating()==o2.getAvgRating()){
                        //    return o1.getTime()-o2.getTime();
                        //}
                        return 0;
                    }
                });
                break;
        }
        for (int i=0;i<shoppingcart.size();i++){
            System.out.println(shoppingcart.get(i));
        }
    }
    public boolean refundProduct(Product product){
        if (!shoppingCart.contains(product)){
            return false;
        }
        for(int i=0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).getId()==product.getId()){
                product=shoppingCart.get(i);
                break;
            }
        }
        shoppingCart.remove(product);
        product.getPlace().transact(product,1);
        wallet+=product.getPrice();
        return true;
    }
}

