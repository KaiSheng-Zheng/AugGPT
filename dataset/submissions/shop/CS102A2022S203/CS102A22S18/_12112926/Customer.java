import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product,int rating){
        if(rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }
        else{
            return false;
        }
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store,Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            wallet=wallet - product.getPrice();
            return true;
        }
        else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> arrayList = new ArrayList<>();
        ArrayList<Product> arrayList1 = new ArrayList<>();
        for (Product product : shoppingCart) {
            arrayList.add(product);
            arrayList1.add(product);
        }
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Rating) {
            Collections.sort(arrayList, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating() > o2.getAvgRating()) {
                        return 1;
                    } else if (o1.getAvgRating() < o2.getAvgRating()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            for (Product product : arrayList) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Price) {
            Collections.sort(arrayList1, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice() > o2.getPrice()) {
                        return 1;
                    } else if (o1.getPrice() < o2.getPrice()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            for (Product product : arrayList1) {
                System.out.println(product);
            }
        }
        }
        public boolean refundProduct(Product product){
        return true;
        }
    }
