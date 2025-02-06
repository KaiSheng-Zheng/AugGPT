import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public static int getCnt() {
        return cnt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else
            return false;
    }

    public float getAvgRating(){
        if(ratings.size()==0){
            return 0;}
        else{
        int total = 0;
        for(int i=0;i<ratings.size();i++){
            total+=ratings.get(i);
        }
        float avg =(float)total/ratings.size();
        return avg;}
    }

    public String toString(){
        String a = "Product ID "+id+", "+name;
        return String.format(a+", RMB %.2f, Rating %.1f",price,getAvgRating());

    }
}