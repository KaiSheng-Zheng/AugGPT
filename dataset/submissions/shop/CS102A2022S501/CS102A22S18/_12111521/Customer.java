import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private HashMap<Product,Store> hashMap = new HashMap();

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return  product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        updateWallet(-product.getPrice());
        if(store.hasProduct(product)&&wallet>=0){
            shoppingCart.add(product);
            hashMap.put(product,store);
            store.transact(product,0);
            return true;
        }else{
            updateWallet(product.getPrice());
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod) {
            case PurchaseTime -> sortByPurchaseTime(shoppingCart);
            case Rating -> sortByPurchaseTime(sortByPurchaseRating(shoppingCart));
            case Price -> sortByPurchaseTime(sortByPurchasePrice(shoppingCart));
        }
    }

    public void sortByPurchaseTime(ArrayList<Product> shoppingCart){
        for (int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i));
        }
    }

    public ArrayList<Product> sortByPurchaseRating(ArrayList<Product> shoppingCart){
        float[] ratings = new float[shoppingCart.size()];
        for (int i = 0; i < ratings.length; i++) {
            ratings[i] = shoppingCart.get(i).getAvgRating();
        }
        Arrays.sort(ratings);
        ArrayList<Product> newShoppingCart = new ArrayList<>();
        for (int i = 0; i < ratings.length; i++) {
            for (int j = 0; j < ratings.length; j++) {
                if(ratings[i] == shoppingCart.get(j).getAvgRating() && !shoppingCartHasProduct(newShoppingCart,shoppingCart.get(j))){
                    newShoppingCart.add(shoppingCart.get(j));
                    break;
                }
            }
        }
        return newShoppingCart;
    }

    public ArrayList<Product> sortByPurchasePrice(ArrayList<Product> shoppingCart){
        ArrayList<Product> shoppingCart2 =  shoppingCart;
        float[] prices = new float[shoppingCart2.size()];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = shoppingCart2.get(i).getPrice();
        }
        Arrays.sort(prices);
        ArrayList<Product> newShoppingCart = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                if(prices[i] == shoppingCart2.get(j).getPrice() && !shoppingCartHasProduct(newShoppingCart,shoppingCart2.get(j))){
                    newShoppingCart.add(shoppingCart2.get(j));
                    break;
                }
            }
        }
        return newShoppingCart;
    }

    public boolean refundProduct(Product product){
        if(shoppingCartHasProduct(shoppingCart,product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            Store store = hashMap.get(product);
            store.transact(product,1);
            return true;
        }else {
            return false;
        }

    }

    public boolean shoppingCartHasProduct(ArrayList<Product> shoppingCart ,Product product){
        boolean hasProduct = false;
        for (Product value : shoppingCart) {
            if (value.getId() == product.getId()) {
                hasProduct = true;
                break;
            }
        }
        return hasProduct;
    }
}

