import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;id=cnt;
    }
    public boolean setRating(int rating){
        if (rating<1 ||rating>5){
            return false;
        }else {
            ratings.add(rating);
            return true;
        }
    }

    public float getAvgRating(){
        int sum = 0;
        for (int x = 0;x<ratings.size();x++){
            sum += ratings.get(x);
        }
        float avgRating =(float) sum / ratings.size();
        return avgRating;
    }
    public String toString(){
     return "Product ID"+ id+
            name+
            "RMB"+ price+
            "Rating"+getAvgRating();

        }

    public float getPrice() {
        return price;
    }
}

