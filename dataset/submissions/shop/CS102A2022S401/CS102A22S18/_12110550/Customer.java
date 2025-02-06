import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private HashMap<Product,Store>history=new HashMap<>();

    public Customer(String name, float wallet){
        this.cnt++;
        this.id=Customer.cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && this.wallet>=product.getPrice()){
            store.transact(product,0);
            this.wallet-=product.getPrice();
            this.shoppingCart.add(product);
            this.history.put(product,store);
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            for (Product product : this.shoppingCart) {
                System.out.println(product.toString());
            }
        }

        else if(sortMethod==SortBy.Rating){
            ArrayList<Product> order=new ArrayList<>();
            ArrayList<Product> temp = new ArrayList<>(shoppingCart);
            Product small;
            for (int i = 0; i < shoppingCart.size(); i++) {
                small=temp.get(0);

                if(temp.size()>1){
                    for (int j = 0; j < temp.size()-1; j++) {
                        if(small.getAvgRating()>temp.get(j+1).getAvgRating()){
                            small=temp.get(j+1);
                        }

                    }
                }

                order.add(small);
                temp.remove(small);
            }

            for (int i = 0; i <order.size(); i++) {
                System.out.println(order.get(i).toString());
            }
        }


        else if(sortMethod==SortBy.Price){
            ArrayList<Product> order=new ArrayList<>();
            ArrayList<Product> temp = new ArrayList<>(shoppingCart);
            Product small;
            for (int i = 0; i < shoppingCart.size(); i++) {
                small=temp.get(0);

                if(temp.size()>1){
                    for (int j = 0; j < temp.size()-1; j++) {
                        if(small.getPrice()>temp.get(j+1).getPrice()){
                            small=temp.get(j+1);
                        }

                    }
                }

                order.add(small);
                temp.remove(small);
            }

            for (int i = 0; i <order.size(); i++) {
                System.out.println(order.get(i).toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        if(history.containsKey(product)){
            Store home=history.get(product);
            home.transact(product,1);
            this.wallet+=product.getPrice();
            this.shoppingCart.remove(product);
            history.remove(product);
            return true;
        }else {
            return false;
        }

    }
}
