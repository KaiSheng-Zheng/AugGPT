import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public enum SortBy{
    PurchaseTime,Rating,Price;

    public static ArrayList<Product> PurchaseTime(ArrayList<Product> shopping){
        Collections.sort(shopping);
        return shopping;
    }


    public static ArrayList<Product> Rating(ArrayList<Product> shopping){
        Collections.sort(shopping);
        shopping.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare((int)o1.avgRating*10, (int)o2.avgRating*10);
            }
        } );

        return shopping;
    }

    public static ArrayList<Product> Price(ArrayList<Product> shopping){
        Collections.sort(shopping);
        shopping.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare((int)o1.getPrice()*100, (int)o2.getPrice()*100);
            }
        } );
        return shopping;
    }

}
