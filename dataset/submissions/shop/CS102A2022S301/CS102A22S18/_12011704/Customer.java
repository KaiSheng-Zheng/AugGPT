import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> purchased=new ArrayList<>();
    private ArrayList<Store> fromwhichstore=new ArrayList<>();
    private ArrayList<Product> shoppingCart; // The list of purchased products;default is empty.
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        shoppingCart=new ArrayList<>();
        cnt++;id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(wallet>= product.getPrice()&&store.hasProduct(product)){
            shoppingCart.add(product);
            store.removeProduct(product);
            store.setIncome(product.getPrice());
            purchased.add(product);
            fromwhichstore.add(store);
            updateWallet(-product.getPrice());
            return true;
        }
        else {return false;}
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.Price){
            float[]price=new float[shoppingCart.size()];
            for (int i = 0; i < price.length; i++) {
                price[i]=shoppingCart.get(i).getPrice();
            }
            Arrays.sort(price);
            for (int i = 0; i < price.length-1; i++) {
                if(price[i]==price[i+1]){
                    price[i]=-1;
                }
            }
            for (float v : price) {
                for (int j = 0; j < price.length; j++) {
                    if (v == shoppingCart.get(j).getPrice()) {
                        System.out.println(shoppingCart.get(j));
                    }
                }
            }
        }



        if (sortMethod==SortBy.PurchaseTime){
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }



        if(sortMethod==SortBy.Rating){
                float[]rating=new float[shoppingCart.size()];
            for (int i = 0; i < rating.length; i++) {
                rating[i]=shoppingCart.get(i).getAvgRating();
            }
            Arrays.sort(rating);
            for (int i = 0; i < rating.length-1; i++) {
                if(rating[i]==rating[i+1]){
                    rating[i]=-1;
                }
            }
            for (float v : rating) {
                for (int j = 0; j < rating.length; j++) {
                    if (v == shoppingCart.get(j).getAvgRating()) {
                        System.out.println(shoppingCart.get(j));
                    }
                }
            }
        }


    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            int des=-1;
            for (int i = 0; i < purchased.size(); i++) {
                if(purchased.get(i)==product){
                    des=i;
                    break;
                }
            }
            if(fromwhichstore.get(des).getIncome()>= product.getPrice()){
            fromwhichstore.get(des).addProduct(product);
            fromwhichstore.get(des).refundIncome(product.getPrice());
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            return true;
            }
            else return false;
        }
        else return false;
    }

}
