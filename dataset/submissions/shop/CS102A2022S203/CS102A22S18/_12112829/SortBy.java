import java.util.Comparator;

public enum SortBy {
    PurchaseTime, Rating, Price
}

class sortRating implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getAvgRating() >= o2.getAvgRating()){
            return 1;
        }else{
            return -1;
        }
    }
}

class sortPrice implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice()>=o2.getPrice()){
            return 1;
        }else {
            return -1;
        }
    }
}
