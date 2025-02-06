

import java.util.Comparator;
public class CompareRating implements Comparator<Product>{
    @Override
    public int compare(Product p1, Product p2) {
        if(p1.getAvgRating()>=p2.getAvgRating())
            return 1;
        else return -1;
    }
    }
    class ComparePrice implements Comparator<Product>{
        public int compare(Product p1, Product p2) {
            if(p1.getPrice()>=p2.getPrice())
                return 1;
            else return -1;
        }
}
