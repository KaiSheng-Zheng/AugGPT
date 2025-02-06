import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
        private static int cnt=0;
        private int id;
        private String name;
        private ArrayList<Product> shoppingCart=new ArrayList<>();
        private HashMap<Product,Store> shoppingPlace=new HashMap<>();
        private float wallet;

        public Customer(String name,float wallet){
            this.name=name;
            this.wallet=wallet;
            cnt= cnt+1;
            this.id=cnt;
        }
        public boolean rateProduct(Product product,int rating ){
            if(rating<1||rating>5){
                return false;
            }else{
                product.setRating(rating);
                return true;
            }
        }
        public void updateWallet(float amount){
            this.wallet=this.wallet+amount;
            }

        public boolean purchaseProduct(Store store, Product product) {
            if(this.wallet>=product.getPrice()&&store.hasProduct(product)==true){
                shoppingCart.add(product);
                shoppingPlace.put(product,store);
                shoppingPlace.get(product).transact(product,0);
                updateWallet(-product.getPrice());
                return true;
            }else{
                return false;
            }
        }

    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)==true) {
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            shoppingPlace.get(product).transact(product,1);
            return true;
        }
        else {return false;
        }
    }
        public void viewShoppingCart(SortBy sortMethod) {
            ArrayList <Product> s=new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                s.add(shoppingCart.get(i));
            }

            if (sortMethod == SortBy.PurchaseTime) {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(s.get(i).toString());
                }
            } else if (sortMethod == SortBy.Price) {

                Collections.sort(s, new ProductComparator());
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(s.get(i).toString());
                }
            } else if (sortMethod == SortBy.Rating) {

                Collections.sort(s, new ProductComparator2());
                for (int i = 0; i < s.size(); i++) {
                    System.out.println(s.get(i).toString());
                }
            }
        }
        class ProductComparator implements Comparator<Product> {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() - o2.getPrice() >= 0) {
                    return  1;
                } else {
                    return -1;
                }}
        }
        class ProductComparator2 implements Comparator<Product>{
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getAvgRating() - o2.getAvgRating() >= 0) {
                    return 1;
                }
                else {
                    return -1;
                }
            }}}



