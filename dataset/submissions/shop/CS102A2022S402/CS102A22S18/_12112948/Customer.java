import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>();
    private float wallet;
    public ArrayList<Store> storeList=new ArrayList<Store>();


    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (!product.setRating(rating)) {
            return false;
        }
        else
            return true;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= wallet) {
            this.storeList.add(store);
            store.transact(product, 0);
            shoppingCart.add(product);
            wallet =wallet- product.getPrice();


            return true;
        }
        else
            return false;
    }

    Comparator<Product> comparator1 = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            Float avg1= o1.getAvgRating();
            Float avg2=o2.getAvgRating();
            return (avg1-avg2>=0)?1:-1;

        }
    };

    Comparator<Product> comparator2 = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            Float p1= o1.getPrice();
            Float p2=o2.getPrice();
            return (p1-p2>=0)?1:-1;

        }
    };

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> temp=new ArrayList<>(shoppingCart);
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(temp.get(i));
            }
        }
        if (sortMethod == SortBy.Rating){
            temp.sort(comparator1);
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(temp.get(i));
            }
        }
        if (sortMethod == SortBy.Price) {
            temp.sort( comparator2);
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(temp.get(i));
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)){
            for (int i=0;i<this.storeList.size();i++) {
                if (this.storeList.get(i).products.contains(product)) {
                    this.storeList.get(i).transact(product, 1);
                    shoppingCart.remove(product);
                    updateWallet(product.getPrice());
                    break;
                }

            }
            return true;
        }
        else
            return false;
    }






}
