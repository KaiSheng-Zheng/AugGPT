import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; defaultis empty.
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
        this.ratings=new ArrayList<>();
    }
    public boolean setRating(int rating){
        if (rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }else return false;

    }
    public float getAvgRating(){
        double sum=0;

        int num= ratings.size();
        if (num>0){
        for (int i = 0; i < num; i++) {
            sum+=ratings.get(i);
        }
        return (float) (sum/num);}
        else {
            return  0;}
        

    }
    public String toString(){
        String id=String.valueOf(this.id);
        String name=this.name;
        String price=String.format("%.2f", this.price);
        String averageRating=String.format("%.1f",this.getAvgRating());
        return "Product ID "+id+", "+name+", RMB "+price+", Rating "+averageRating;

    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public int getId() {
        return id;
    }
}