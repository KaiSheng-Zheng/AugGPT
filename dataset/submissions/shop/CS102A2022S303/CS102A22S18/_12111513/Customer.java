import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();; // The list of purchased products; default is empty.
    private float wallet;
    HashMap<Product,Store>hashMap = new HashMap<>();
    public Customer(String name, float wallet){
        cnt++;
        this.name=name;
        this.wallet = wallet;
        this.id=cnt;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    

    public boolean removeProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            return true;
        }else {
            return false;
        }

    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean rateProduct(Product product, int rating){
        product.setRating(rating);
        if (rating>=1&&rating<=5){
            return true;
        }else {
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
       if (store.getProductList().contains(product)&&getWallet()>=product.getPrice()){
           getShoppingCart().add(product);
           setWallet(getWallet()-product.getPrice());
           store.removeProduct(product);
           store.setIncome(product.getPrice()+store.getIncome());
           hashMap.put(product,store);
           return true;
       }else {
           return false;
       }
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                Timesort(shoppingCart);
                break;
            case Rating:
                Ratingsort(shoppingCart);
                break;
            case Price:
                Pricesort(shoppingCart);
                break;
        }
    }
        public void Ratingsort (ArrayList<Product> shoppingCart ){
        float[] ratings = new float[shoppingCart.size()];
            ArrayList<Product> shoppingsort = new ArrayList<>();

            for (int i = 0; i < ratings.length; i++) {
                ratings[i] = shoppingCart.get(i).getAvgRating();
            }
            Arrays.sort(ratings);
            for (int i = 0; i < ratings.length; i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (ratings[i]==shoppingCart.get(j).getAvgRating()) {
                        if (!shoppingsort.contains(shoppingCart.get(j))) {
                            shoppingsort.add(shoppingCart.get(j));
                            break;
                        }
                    }
                }


            }
            for (int i = 0; i < shoppingsort.size(); i++) {
                System.out.println(shoppingsort.get(i).toString());

            }

    }
    public void Pricesort (ArrayList<Product> shoppingCart ) {
        float[] ratings = new float[shoppingCart.size()];
        ArrayList<Product> shoppingsort = new ArrayList<>();

        for (int i = 0; i < ratings.length; i++) {
            ratings[i] = shoppingCart.get(i).getPrice();
        }
        Arrays.sort(ratings);
        for (int i = 0; i < ratings.length; i++) {
            for (int j = 0; j < shoppingCart.size(); j++) {
                if (ratings[i] == shoppingCart.get(j).getPrice()) {
                    if (!shoppingsort.contains(shoppingCart.get(j))) {
                        shoppingsort.add(shoppingCart.get(j));
                        break;
                    }
                }
            }
        }for (int i = 0; i < shoppingsort.size(); i++) {
            System.out.println(shoppingsort.get(i).toString());

        }
    }
    public void Timesort(ArrayList<Product> shoppingCart ){
        for (int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i).toString());

        }

    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
        shoppingCart.remove(product);
        setWallet(getWallet()+product.getPrice());
        hashMap.get(product).transact(product,1);
        return true;
        }else {
            return false;
        }

    }
    }
