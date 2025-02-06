import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.


    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }



    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.price=price;
        this.name=name;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }


    public float getAvgRating(){
        float sum =0;
        float avg=0;
        for (int i=0;i<ratings.size();i++){
            sum+=ratings.get(i);
        }
        if(ratings.size()==0){
            return 0;
        }
        avg = sum/ratings.size();
        return avg;
    }

    public String toString(){
//        String price = String.format("%.2f",this.price);
//        String rating = String.format("%.1f",getAvgRating());
//        return "Product ID "+this.id+", "+this.name+", RMB "+price+", Rating "+rating;
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

}
