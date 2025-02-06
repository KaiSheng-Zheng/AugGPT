import java.util.ArrayList;
import java.util.Comparator;

public enum SortBy {
    PurchaseTime, Rating, Price;
}

class Product{
    private Store store;
    private static int cnt=0;
    private final int id;
    private final String name;
    private final float price;
    private ArrayList<Integer> ratings;
    private int time;

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
        ratings=new ArrayList<Integer>();
        this.time=0;
    }
    public void setStore(Store store){
        this.store=store;
    }
    public Store getStore(){
        return this.store;
    }
    public boolean setRating(int rating){
        if(0<rating&&rating<6){
            ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }
    public float getAvgRating(){
        float sum= 0;
        float AvRating=0;
        if(ratings!=null && !ratings.isEmpty()){
            int size= ratings.size();
            for (Integer rating : ratings) {
                sum += rating;
            }
            AvRating=sum/size;
        }
        return AvRating;
    }
    public int getProductID(){
        return this.id;
    }
    public String toString(){
        return ""+"Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
    }
    public float getPrice(){
        return this.price;
    }
    public boolean setTime(int time){
        if(time>0){
            this.time=time;
            return true;
        }
        else{
            return false;
        }
    }
    public int getTime(){
        return this.time;
    }
}

class Store{
    private static int cnt=0;
    private final int id;
    private final String name;
    private final ArrayList<Product> productList;
    private float income;
    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=new ArrayList<Product>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product){
        boolean contain=hasProduct(product);
        if(contain){
            return false;
        }
        else{
            this.productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            this.productList.remove(product);
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public String getName(){
        return this.name;
    }
    public void transact(Product product, int method){
        if(method==0){
            this.income+=product.getPrice();
            removeProduct(product);
        }
        else if(method==1){
            this.income-=product.getPrice();
            product.setTime(0);
            addProduct(product);
        }
    }
}

class  Customer{
    private static int cnt=0;
    private final int id;
    private final String name;
    private ArrayList<Product> shoppingCart;
    private float wallet=0;
    public static int onTime=0;


    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.shoppingCart=new ArrayList<Product>();
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)){
            product.setStore(store);
            if(wallet>= product.getPrice()){
                onTime++;
                product.setTime(onTime);
                wallet-= product.getPrice();
                store.transact(product,0);
                this.shoppingCart.add(product);
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.equals(SortBy.PurchaseTime)){
            this.shoppingCart.stream().forEach(System.out::println);
        }
        else if(sortMethod.equals(SortBy.Rating)){
            this.shoppingCart.sort(Comparator.comparing(Product::getAvgRating).thenComparing(Product::getTime));
            this.shoppingCart.stream().forEach(System.out::println);
        }
        else if(sortMethod.equals(SortBy.Price)){
            this.shoppingCart.sort(Comparator.comparing(Product::getPrice).thenComparing(Product::getTime));
            this.shoppingCart.stream().forEach(System.out::println);
        }
    }

    public boolean refundProduct(Product product){
        if(this.shoppingCart.contains(product)){
            this.shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.getStore().transact(product,1);
            return true;
        }
        else{
            return false;
        }
    }
}

