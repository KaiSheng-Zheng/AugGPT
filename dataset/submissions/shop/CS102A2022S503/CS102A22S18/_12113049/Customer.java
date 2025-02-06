import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();// The list of purchased products; default is empty.
    private ArrayList<Store> storeList = new ArrayList<>();
    private float wallet;


    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;}

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Product> getShoppingCart() {return shoppingCart;}
    public ArrayList<Store> getStoreList() {return storeList;}
    public float getWallet (){return wallet;}

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;}
        else {
            return false;}}


    public void updateWallet(float amount) {
        float wallet = getWallet();
        wallet = wallet + amount;
        this.wallet = wallet ;}



    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            // update wallet and shopping-list
            store.transact(product, 0);
            updateWallet(-product.getPrice());
            storeList.add(store);
            shoppingCart.add(product);
            return true;}
        else {
            return false;}}


    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> shopping1=getShoppingCart();
        ArrayList<Product> shopping = new ArrayList<>();

        for (Product product : shopping1) {
            shopping.add(product);}

            if(sortMethod == SortBy.PurchaseTime){
                for (Product s : shopping) {
                    System.out.println(s.toString());}}

            if(sortMethod == SortBy.Rating){
                shopping.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return Float.compare(o1.getAvgRating(), o2.getAvgRating());}} );

                for (Product s : shopping) {
                    System.out.println(s.toString());}}


            if(sortMethod == SortBy.Price){
                shopping.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return Float.compare(o1.getPrice(), o2.getPrice());}} );

                for (Product s : shopping) {
                    System.out.println(s.toString());}}
        }


        public boolean refundProduct(Product product){
        ArrayList <Product> shoppingCart = getShoppingCart();
        int a=-1;
        a = shoppingCart.indexOf(product);
        if(a>=0){
            Store store = product.getStore();
            store.transact(product, 1);
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            return true;}
        else{
            return false;}}


}