import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private int num = 0;

    public Customer(String name, float wallet){
        id=++cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.getProductList().contains(product) && product.getPrice() <= wallet){
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.removeProduct(product);
            store.transact(product,0);
            product.setOrder(num);
            store.goodsAdd(product);
            num++;
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Rating:
                Product[] rate = new Product[shoppingCart.size()];
                for(int i = 0;i <shoppingCart.size();i++){
                    rate[i]=shoppingCart.get(i);
                }
                Arrays.sort(rate,new SortByRating());
                for(int i = 0;i<rate.length;i++){
                    System.out.println(rate[i].toString());
                }
                break;
            case Price:
                Product[] money = new Product[shoppingCart.size()];
                for(int i = 0;i<shoppingCart.size();i++){
                    money[i]=shoppingCart.get(i);
                }
                Arrays.sort(money,new SortByPrice());
                for(int i = 0;i<money.length;i++){
                    System.out.println(money[i].toString());
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }

    private class SortByRating implements Comparator<Product> {
        public int compare(Product p1,Product p2){
            if (p2.getAvgRating()<=p1.getAvgRating()) return 1;
            else return -1;
        }
    }
    private class SortByPrice implements Comparator<Product>{
        public int compare(Product p1,Product p2){
            if (p2.getPrice()<=p1.getPrice()) return 1;
            else return -1;
        }
    }
}
