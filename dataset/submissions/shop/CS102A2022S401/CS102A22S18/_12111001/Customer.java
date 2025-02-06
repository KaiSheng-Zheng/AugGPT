import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&product.getPrice() <= wallet){
            shoppingCart.add(product);
            store.transact(product,0);
            updateWallet(-1 * product.getPrice());
            return true;
        }
        else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> resultShoppingCart;
        if(sortMethod == SortBy.PurchaseTime){
            resultShoppingCart = sort(sortMethod);
        }else if(sortMethod == SortBy.Rating){
            int counter1 = 0;
            int counter2 = 0;
            float[] newRate = new float[shoppingCart.size()];
            for(int i = 0;i < shoppingCart.size();i++){
                newRate[i] = (float) (Math.round(shoppingCart.get(i).getAvgRating() * 10)) / 10;
            }
            for (float v : newRate) {
                if (newRate[0] == v) {
                    counter2++;
                }
            }
            if(counter2 >= newRate.length) {
                for (Product product : shoppingCart) {
                    if (shoppingCart.get(0).getAvgRating() == product.getAvgRating()) {
                        counter1++;
                    }
                }
                if (counter1 >= shoppingCart.size()) {
                    resultShoppingCart = sort(SortBy.PurchaseTime);
                } else {
                    resultShoppingCart = sort(sortMethod);
                }
            }
            else{
                resultShoppingCart = sortByNewRate(newRate);
            }
        }else{
            int counter = 0;
            for(Product product : shoppingCart){
                if(shoppingCart.get(0).getPrice() == product.getPrice()){
                    counter++;
                }
            }
            if(counter >= shoppingCart.size()){
                resultShoppingCart = sort(SortBy.PurchaseTime);
            }else {
                resultShoppingCart = sort(sortMethod);
            }
        }
        for (Product product : resultShoppingCart) {
            System.out.println(product.toString());
        }
    }
    public ArrayList<Product> getShoppingCart(){
        return shoppingCart;
    }

    public boolean refundProduct(Product product){
        int cnt = 0;
        for(int i = 0;i < getShoppingCart().size();i++){
            if(product.getId() == getShoppingCart().get(i).getId()){
                cnt++;
            }
        }
        if(cnt != 0&&!product.getStore().hasProduct(product)){
            shoppingCart.remove(product);
            product.getStore().transact(product,1);
            updateWallet(product.getPrice());
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> sortByNewRate(float[] newRating){
        ArrayList<Float> ratings = new ArrayList<>();
        ArrayList<Product> newShoppingCart = (ArrayList<Product>) shoppingCart.clone();
        ArrayList<Product> sortedShoppingCart = new ArrayList<>();
        for(int i = 0;i < newRating.length;i++){
            ratings.add(newRating[i]);
        }
        Collections.sort(ratings);
        for(int i = 0;i < ratings.size();i++){
            for(int j = 0;j < newShoppingCart.size();j++){
                if(ratings.get(i) == newRating[j]){
                    sortedShoppingCart.add(newShoppingCart.get(j));
                    newShoppingCart.remove(j);
                    break;
                }
            }
        }
        return sortedShoppingCart;
    }

    public ArrayList<Product> sort(SortBy sortMethod){
        if(sortMethod.equals(SortBy.PurchaseTime)){
            return shoppingCart;
        }else if(sortMethod.equals(SortBy.Rating)){
            ArrayList<Float> ratings = new ArrayList<>();
            ArrayList<Product> newShoppingCart = (ArrayList<Product>) shoppingCart.clone();
            ArrayList<Product> sortedShoppingCart = new ArrayList<>();
            for(Product product : shoppingCart){
                ratings.add(product.getAvgRating());
            }
            Collections.sort(ratings);
            for(int i = 0;i < ratings.size();i++){
                for(int j = 0;j < newShoppingCart.size();j++){
                    if(ratings.get(i) == newShoppingCart.get(j).getAvgRating()){
                        sortedShoppingCart.add(newShoppingCart.get(j));
                        newShoppingCart.remove(j);
                        break;
                    }
                }
            }
            return sortedShoppingCart;
        }else{
            ArrayList<Float> prices = new ArrayList<>();
            ArrayList<Product> newShoppingCart = (ArrayList<Product>) shoppingCart.clone();
            ArrayList<Product> sortedShoppingCart = new ArrayList<>();
            for(Product product : shoppingCart){
                prices.add(product.getPrice());
            }
            Collections.sort(prices);
            for(int i = 0;i < prices.size();i++){
                for(int j = 0;j < newShoppingCart.size();j++){
                    if(prices.get(i) == newShoppingCart.get(j).getPrice()) {
                        sortedShoppingCart.add(newShoppingCart.get(j));
                        newShoppingCart.remove(j);
                        break;
                    }
                }
            }
            return sortedShoppingCart;
        }
    }
}
