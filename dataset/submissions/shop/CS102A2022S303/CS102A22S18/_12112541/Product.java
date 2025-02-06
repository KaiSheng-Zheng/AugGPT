import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id=cnt;
    }

    public boolean setRating(int rating) {
        boolean test = false;
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            test = true;
            ratings.add(rating);
        }
        return test;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public float getPrice() {
        return price;
    }

    public int getId(){
        return id;
    }
    public float getAvgRating(){
        float sum =0;
        float avgRating = 0;
        if (ratings.size()!=0){
        for (int i=0;i<ratings.size();i++){
            sum += ratings.get(i);
            avgRating =sum/ratings.size() ;
        }
        }else if (ratings.size()==0)
            avgRating = 0;
        return avgRating;
    }
    public String toString(){
        String str=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
        return  str;
    }

}




