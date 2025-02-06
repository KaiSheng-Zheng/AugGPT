import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer  {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productArrayList=new ArrayList<>();
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    Comparator<Product> sortByPrice=new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Product p1=(Product) o1;
            Product p2=(Product) o2;
            if (p1.getPrice()==p2.getPrice()){
                return shoppingCart.indexOf(p1)-shoppingCart.indexOf(p2);
            }
           if (p1.getPrice()-p2.getPrice()>0){
               return 1;
           }else {
               return -1;
           }
        }

    };
    Comparator<Product> sortByRating=new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Product p1=(Product) o1;
            Product p2=(Product) o2;
            if (p1.getAvgRating()==p2.getAvgRating()){
                return shoppingCart.indexOf(p1)-shoppingCart.indexOf(p2);
            }
            if (p1.getAvgRating()-p2.getAvgRating()>0){
                return 1;
            }else {
                return -1;
            }
        }

    };


    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)){
            return true;
        }else return false;
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&product.getPrice()<=wallet){
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.removeProduct(product);
            return true;
        }return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        productArrayList.clear();
        for (Product product : shoppingCart) {
            productArrayList.add(product);
        }
        if(sortMethod==SortBy.PurchaseTime){

        }
        if (sortMethod==SortBy.Price){
            Collections.sort(productArrayList,sortByPrice);
        }
        if (sortMethod==SortBy.Rating){
            Collections.sort(productArrayList,sortByRating);
        }
        for (Product product : productArrayList) {
            System.out.println(product.toString());
        }
        }
    public boolean refundProduct(Product product){
        return true;
    }
    }

