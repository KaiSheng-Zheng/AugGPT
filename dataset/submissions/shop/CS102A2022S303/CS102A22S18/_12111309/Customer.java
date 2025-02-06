import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet = 0;

    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if (rating==1 || rating==2 || rating==3 || rating==4 || rating==5){
            product.setRating(rating);
            return true;
        }
        else return false;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product) && wallet >= product.getPrice()){
            shoppingCart.add(product);
            product.store=store;
            this.wallet -= product.getPrice();
            store.getProductList().remove(product);
            store.setIncome(store.getIncome()+product.getPrice());
            return true;
        }
        else return false;
    }


    public void viewShoppingCart(SortBy sortMethod) {
        String[] result = new String[shoppingCart.size()];
        for (int i = 0; i < shoppingCart.size(); i++) {
            result[i] = shoppingCart.get(i).toString();
        }
        if (sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(result[i]);
            }
        }
        else if (sortMethod==SortBy.Rating){
            float[] averageRatingFirst = new float[shoppingCart.size()];
            float[] averageRatingChange = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                averageRatingChange[i] = shoppingCart.get(i).getAvgRating();
                averageRatingFirst[i] = shoppingCart.get(i).getAvgRating();
            }
            Arrays.sort(averageRatingChange);
            ArrayList<Float> average = new ArrayList<>();
            average.add(averageRatingChange[0]);
            for (int i = 1; i < shoppingCart.size(); i++) {
                if (averageRatingChange[i]!=averageRatingChange[i-1])
                {
                    average.add(averageRatingChange[i]);
                }
                else continue;
            }
            for (int i = 0; i < average.size(); i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (averageRatingFirst[j]==average.get(i)){
                        System.out.println(result[j]);
                    }
                    else continue;
                }
            }
        }
        else if (sortMethod==SortBy.Price){
            double[] price = new double[shoppingCart.size()];
            double[] priceFirst = new double[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                price[i] = shoppingCart.get(i).getPrice();
                priceFirst[i] = shoppingCart.get(i).getPrice();
            }
            Arrays.sort(price);
            ArrayList<Double> priceArray = new ArrayList<>();
            priceArray.add(price[0]);
            for (int i = 1; i < shoppingCart.size(); i++) {
                if (price[i]!=price[i-1])
                {priceArray.add(price[i]);}
                else continue;
            }
            for (int i = 0; i < priceArray.size(); i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (priceFirst[j]==priceArray.get(i)){
                        System.out.println(result[j]);
                    }
                    else continue;
                }
            }
        }
    }
    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)){
           shoppingCart.remove(product);
           this.wallet+=product.getPrice();
           product.store.transact(product,1);
           return true;
        }
        else return false;
    }

}
