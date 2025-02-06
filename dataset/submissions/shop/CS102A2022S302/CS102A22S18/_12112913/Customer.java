import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer{
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Store> storeList;

    public Customer(String name,float wallet){
        this.name = name;
        this.wallet = wallet;
        id = ++cnt;
        shoppingCart = new ArrayList<Product>();
        storeList = new ArrayList<Store>();
    }

    public boolean rateProduct(Product product, int rating){
        boolean result;
        if (product.setRating(rating)){
            result = true;
        }else{
            result = false;
        }
        return result;
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        boolean result = true;
        if (product.getPrice() > wallet || !store.hasProduct(product)){
            result = false;
        }else{
            store.transact(product,0);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            storeList.add(store);
        }
        return result;
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> sort = new ArrayList<Product>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            sort.add(shoppingCart.get(i));
        }
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product:sort) {
                System.out.println(product.toString());
            }
        }else if (sortMethod.equals(SortBy.Price)){
            Collections.sort(sort, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    int result = 0;
                    if (o1.getPrice() - o2.getPrice() > 0){
                        result = 1;
                    }else if (o1.getPrice() - o2.getPrice() < 0){
                        result = -1;
                    }
                    return result;
                }
            });
            for (Product product:sort) {
                System.out.println(product.toString());
            }
        }else if (sortMethod.equals(SortBy.Rating)){
            Collections.sort(sort, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    int result = 0;
                    if (o1.getAvgRating() - o2.getAvgRating() > 0){
                        result = 1;
                    }else if (o2.getAvgRating() - o1.getAvgRating() > 0){
                        result = -1;
                    }
                    return result;
                }
            });
            for (Product product:sort) {
                System.out.println(product.toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        boolean result = false;
        boolean hasProduct = false;
        int i = 0;
        for (; i < shoppingCart.size(); i++) {
            if (product.toString().equals(shoppingCart.get(i).toString())){
                hasProduct = true;
                result = true;
                break;
            }
        }
        if (hasProduct){
            wallet += product.getPrice();
            shoppingCart.remove(product);
            storeList.get(i).transact(product,1);
            storeList.remove(storeList.get(i));
        }
        return result;
    }
}