import java.util.ArrayList;

public class Product {

    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }


    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        if (this.ratings.size() != 0){
            float avg = 0;
            for (int i = 0; i < this.ratings.size(); i++) {
                avg = avg + this.ratings.get(i);
            }
            avg = avg/this.ratings.size();
            return avg;
        }else {
            return 0;
        }

    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString(){
       return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f" , this.id , this.name , this.price , getAvgRating());
    }


//    public float compareToPrice(Product o){
//        return this.price - o.price;
//    }
//
//    public float compareToRating(Product o){
//        return this.getAvgRating() - o.getAvgRating();
//    }
}
