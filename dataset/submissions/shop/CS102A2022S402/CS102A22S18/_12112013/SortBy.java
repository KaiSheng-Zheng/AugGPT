import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public enum SortBy{
    PurchaseTime, Rating, Price;
    public ArrayList<Product> Price(ArrayList<Product> shoppingCart){
        Collections.sort(shoppingCart,new priceComparator());
        return shoppingCart;
    }
    public ArrayList<Product> Rating(ArrayList<Product> shoppingCart){
        Collections.sort(shoppingCart,new rateComparator());
        return shoppingCart;
    }
    static class priceComparator implements Comparator<Object> {
        public int compare(Object o1,Object o2){
            Product p1=(Product) o1;
            Product p2=(Product) o2;
            String pr1=String.format("%.0f",p1.getPrice()*1000000);
            String pr2=String.format("%.0f",p2.getPrice()*1000000);
            // May exceed the range of Integer
            // E.g., price = 1000000, pri1 > Integer.MAX_VALUE
            int price1=Integer.valueOf(pr1);
            int price2=Integer.valueOf(pr2);
            return price1-price2;
        }
    }
    static class rateComparator implements Comparator<Object>{
        public int compare(Object o1,Object o2){
            Product p1=(Product) o1;
            Product p2=(Product) o2;
            String pr1=String.format("%.0f",p1.getAvgRating()*1000000);
            String pr2=String.format("%.0f",p2.getAvgRating()*1000000);
            int price1=Integer.valueOf(pr1);
            int price2=Integer.valueOf(pr2);
            return price1-price2;
        }
    }
}
