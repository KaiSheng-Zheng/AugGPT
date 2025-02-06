import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private ArrayList<Bought> boughtList = new ArrayList<>();

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt ++;
        int count = cnt;
        this.id = count;
    }

    public static int getCnt() {
        return cnt;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public float getWallet() {
        return wallet;
    }

    public int getId() {
        return id;
    }

    public boolean rateProduct(Product product, int rating){// using product?
        boolean valid;
        valid = product.setRating(rating);
        return valid;
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        boolean able = true;
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            updateWallet((-1)*product.getPrice());
            shoppingCart.add(product);
            Bought thing = new Bought(store,product);
            boughtList.add(thing);
            store.removeProduct(product);
            store.transact(product,0);
            able = true;
        }
        else {
            able = false;
        }
        return able;
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:{
                for (int i = 0; i < shoppingCart.size();i ++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            }
            case Rating:{
                Product[] order = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size();i ++){
                    int count = 0;
                    for (int j = 0; j < shoppingCart.size(); j ++){
                        if (shoppingCart.get(j).getAvgRating() < shoppingCart.get(i).getAvgRating()){
                            count ++;
                        }
                        if (shoppingCart.get(j).getAvgRating() == shoppingCart.get(i).getAvgRating()){
                            if (i > j){
                                count ++;
                            }
                        }
                    }
                    order[count] = shoppingCart.get(i);
                }
                for (int i = 0; i < shoppingCart.size();i ++){
                    System.out.println(order[i].toString());
                }
                break;

            }
            case Price:{
                Product[] order = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size();i ++){
                    int count = 0;
                    for (int j = 0; j < shoppingCart.size(); j ++){
                        if (shoppingCart.get(j).getPrice() < shoppingCart.get(i).getPrice()){
                            count ++;
                        }
                        if (shoppingCart.get(j).getPrice() == shoppingCart.get(i).getPrice()){
                            if (i > j){
                                count ++;
                            }
                        }
                    }
                    order[count] = shoppingCart.get(i);
                }
                for (int i = 0; i < shoppingCart.size();i ++){
                    System.out.println(order[i].toString());
                }
                break;
            }
        }

    }



    public boolean refundProduct(Product product){
        boolean hasPurchased = true;

        if (shoppingCart.contains(product)){
            hasPurchased = true;
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            for (int i = 0;i < boughtList.size();i ++){
                if (boughtList.get(i).getProduct() == product){
                    boughtList.get(i).getStore().transact(product,1);
                }
            }
        }
        else{
            hasPurchased = false;
        }
        return hasPurchased;
    }


    class Bought{
        private Store store;
        private Product product;
        public Bought(Store store,Product product){
            this.store = store;
            this.product = product;
        }
        public Store getStore(){ return(this.store);}
        public Product getProduct(){ return(this.product);}
    }
}
