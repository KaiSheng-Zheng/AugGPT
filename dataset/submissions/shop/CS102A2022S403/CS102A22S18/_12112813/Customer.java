import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id = cnt+1;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void  updateWallet(float amount){
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (wallet < product.getPrice() || !store.hasProduct(product)){
            return false;
        }else {
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> OriginShoppingCart = shoppingCart;
        switch (sortMethod){
            case PurchaseTime:
                shoppingCart = OriginShoppingCart;
                break;
            case Rating:
                Collections.sort(shoppingCart, new Comparator<Product>(){
                    @Override
                    public int compare(Product o1, Product o2){
                        return (int) (o1.getAvgRating()*10 - o2.getAvgRating()*10);
                    }
                });
                break;
            case Price:
                Collections.sort(shoppingCart, new Comparator<Product>(){
                    @Override
                    public int compare(Product o1, Product o2){
                        return (int) (o1.getPrice()*100 - o2.getPrice()*100);
                    }
                });
                break;
        }
        for (int i = 0;i<shoppingCart.size();i++){
            System.out.println(shoppingCart.get(i).toString());
        }
    }
    public boolean refundProduct(Product product){
        if (product.Sold == true){
            shoppingCart.remove(product);
            if (product.store != null){
                product.store.transact(product, 1);
            }else {
                
            }
            updateWallet(product.getPrice());
            return true;
        }else {return false;}
    }
}
