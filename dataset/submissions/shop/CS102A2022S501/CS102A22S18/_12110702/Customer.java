import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
       if(product.setRating(rating)){return true;}
       else return false;
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>=product.getPrice()){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            product.maps.put(product,store);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else if (sortMethod==SortBy.Rating){
            Product s;
            for (int j = 0; j <shoppingCart.size(); j++) {
                for (int i = 0; i<shoppingCart.size()-1; i++) {
                if (shoppingCart.get(i).getAvgRating()>shoppingCart.get(i+1).getAvgRating()){
                    s=shoppingCart.get(i+1);
                    shoppingCart.set(i+1,shoppingCart.get(i));
                    shoppingCart.set(i,s);
                }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else{
            Product s;
            for (int j = 0; j <shoppingCart.size(); j++) {
                for (int i = 0; i<shoppingCart.size()-1; i++) {
                    if (shoppingCart.get(i).getPrice()>shoppingCart.get(i+1).getPrice()){
                        s=shoppingCart.get(i+1);
                        shoppingCart.set(i+1,shoppingCart.get(i));
                        shoppingCart.set(i,s);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)){
            product.maps.get(product).setIncome(product.maps.get(product).getIncome()-product.getPrice());
            wallet+=product.getPrice();
            shoppingCart.remove(product);
            product.maps.get(product).addProduct(product);
            return true;
        }
        else return false;


    }
}

