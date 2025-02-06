import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public float getWallet() {
        return wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && getWallet() >= product.getPrice()){
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            product.setStore(store);
            shoppingCart.add(product);
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (Product i : shoppingCart){
                    System.out.println(i.toString());
                }
                break;
            case Price:
                float[] prices = new float[shoppingCart.size()];
                for (int i = 0; i < prices.length; i++){
                    prices[i] = shoppingCart.get(i).getPrice();
                }
                Arrays.sort(prices);
                ArrayList<Product> sortByPrice = new ArrayList<>();
                for (float price : prices) {
                    for (Product product : shoppingCart) {
                        if (price == product.getPrice()) {
                            sortByPrice.add(product);
                        }
                    }
                }
                for (Product i : sortByPrice){
                    System.out.println(i.toString());
                }
                break;
            case Rating:
                float[] ratings = new float[shoppingCart.size()];
                for (int i = 0; i < ratings.length; i++){
                    ratings[i] = shoppingCart.get(i).getAvgRating();
                }
                Arrays.sort(ratings);
                ArrayList<Product> sortByRatings = new ArrayList<>();
                for (float rating : ratings) {
                    for (Product product : shoppingCart) {
                        if (rating == product.getAvgRating()) {
                            sortByRatings.add(product);
                        }
                    }
                }
                for (Product i : sortByRatings){
                    System.out.println(i.toString());
                }
                break;
        }
    }

    public boolean refundProduct(Product product){
        boolean valid = false;
        for (Product i : shoppingCart){
            if (product.getId() == i.getId()){
                valid = true;
            }
        }
        if (valid){
            product.getStore().transact(product,1);
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            return true;
        }else {
            return false;
        }
    }

}
