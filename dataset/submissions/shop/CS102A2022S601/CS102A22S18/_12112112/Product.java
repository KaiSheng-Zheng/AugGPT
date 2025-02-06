import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Store storeid;


    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public Product(String name, float price){
        cnt= cnt+1;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating){
        if (rating!=1&&rating!=2&&rating!=3&&rating!=4&&rating!=5){
            return false;
        }else {
            ratings.add(rating);
            return true;
        }
    }
    public float getAvgRating(){
        float a=0;
        for (int i=0;i<ratings.size();i++){
            a=a+ratings.get(i);
        }
        if (ratings.size()!=0) {
            return a / ratings.size();
        }else {
            return 0;
        }
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        String s= String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.getId(),this.getName(),this.getPrice(),this.getAvgRating());
        return s;
    }
}
