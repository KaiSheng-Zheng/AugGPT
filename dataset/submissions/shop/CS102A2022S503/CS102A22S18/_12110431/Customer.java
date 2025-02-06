import java.util.ArrayList;
import java.util.HashMap;
public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private HashMap<Product,Store> a = new HashMap<>();

    public Customer(String name, float wallet){
        shoppingCart=new ArrayList<>();
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet=wallet+amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet-product.getPrice()>=0){
            updateWallet(-product.getPrice());
            store.transact(product,0);
            shoppingCart.add(product);
            a.put(product,store);
            return true;
        }else {return false;}
    }

    public void viewShoppingCart(SortBy sortMethod){
        float[] prices=new float[shoppingCart.size()];
        float[] ratings=new float[shoppingCart.size()];
        for (int i=0;i<shoppingCart.size();i++){
            prices[i]=shoppingCart.get(i).getPrice();
        }
        for (int i=0;i<shoppingCart.size();i++){
            ratings[i]=shoppingCart.get(i).getAvgRating();
        }
        switch (sortMethod){
            case Price:{
                for (int i=0;i<shoppingCart.size();i++){
                    int t=0;
                    float min=prices[0];
                    for (int j=0;j<prices.length;j++){
                        if (prices[j]<min){
                            t=j;
                            min=prices[j];
                        }
                    }
                    System.out.println(shoppingCart.get(t));
                    prices[t]=6;
                }
            }
            case Rating:{
                for (int i=0;i<shoppingCart.size();i++){
                    int t=0;
                    float min=ratings[0];
                    for (int j=0;j<ratings.length;j++){
                        if (ratings[j]<min){
                            t=j;
                            min=ratings[j];
                        }
                    }
                    System.out.println(shoppingCart.get(t));
                    ratings[t]=6;
                }
            }
            case PurchaseTime:{
                for (int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
            }
        }
    }

    public boolean hasp(Product product){
        for (int i=0;i<shoppingCart.size();i++){
            if (product.getId()==shoppingCart.get(i).getId()){return true;}
        }
        return false;
    }

    public boolean refundProduct(Product product){
        if (hasp(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            a.get(product).transact(product,1);
            return true;
        }
        else return false;
    }
}


