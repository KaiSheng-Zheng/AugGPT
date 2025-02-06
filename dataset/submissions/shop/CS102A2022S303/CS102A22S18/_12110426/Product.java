import java.util.ArrayList;

public class Product {private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        this.name=name;this.price=price;cnt++;this.id=cnt;
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            this.ratings.add(rating);return true;
        }else
            return false;
    }
    public float getAvgRating(){
        float a = 0,b = 0;
        if (this.ratings.size()==0){}
        else {
        for (int i = 0; i < this.ratings.size(); i++) {
            a=a+this.ratings.get(i);
        }
        b = a/this.ratings.size();}
        return b;
    }
    public String toString(){
        return "Product ID "+this.id+", "+this.name+", "+"RMB "+ String.format("%.2f",this.getPrice())+", "+"Rating "+String.format("%.1f",this.getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
}
