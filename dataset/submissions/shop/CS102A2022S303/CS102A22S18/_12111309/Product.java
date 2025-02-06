import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Store store;

    public Product(String name,float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }


    public boolean setRating(int rating){
        if (rating==1 || rating==2 || rating==3 || rating==4 || rating==5){
            this.ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        float average;
        if(ratings.size()!=0) {
            float allRatings=0;
            for(int i=0;i<ratings.size();i++) {
               allRatings+=ratings.get(i);
            }
            average = allRatings / ratings.size();
        }else{
            average=0;
        }
        return average;
    }
    public float getPrice() {
        return this.price;
    }
    public int getId() {
        return id;
    }
    public String toString() {
        String result ;
        result = "Product ID "+getId()+", "+name+", RMB "+String.format("%.2f",getPrice())+", Rating "+String.format("%.1f",getAvgRating());
        return result;
    }
}
