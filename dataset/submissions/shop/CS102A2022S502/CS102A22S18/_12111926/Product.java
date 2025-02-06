import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;


    public Product(String name, float price){
        this.name =name; this.price=price;
        cnt++;
        this.id=cnt;
        this.ratings = new ArrayList<>();
    }

    public float getPrice() {
        return this.price;
    }


    public boolean setRating(int rating) {

        if(rating>=1 &&rating<=5){
            this.ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        float avg =0;
        if(ratings.size()!=0) {
            for (Integer rating : this.ratings) {
                avg += rating;
            }
            avg = avg / this.ratings.size();
        }
        return (float) avg;
    }
    public String toString(){
        return "Product ID "+ this.id +", "+ this.name+", " +"RMB "+String.format("%.2f", this.price)+", Rating "+String.format("%.1f",getAvgRating());//"product ID"+ this.id +", "+this.name+"RMB "+String.format("%.2f",this.price)+", Rating"+String.format("%.1f",getAvgRating());
    }

}