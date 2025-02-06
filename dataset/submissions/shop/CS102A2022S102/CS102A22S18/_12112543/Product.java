import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.ratings=getRatings();
        this.name=name;
        this.price=price;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings =ratings;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else return false;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }
    public float getAvgRating(){
        float sum=0;
        if(ratings.size()==0){
            return 0;
        }else {
            for (int i=0;i<ratings.size();i++){
                sum+=ratings.get(i);
            }
            float AvgRating=sum/ratings.size();
            return AvgRating;
        }

    }
@Override
    public String toString(){
        return String.format ("Product ID %d, %s, RMB %.2f, Rating %.1f",
                getId(),getName(),getPrice(),getAvgRating());
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        id=cnt;
        this.id = cnt;
    }

    public static int getCnt() {
        cnt=0;
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

}
