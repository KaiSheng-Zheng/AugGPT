import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private int time;//private Random random=new Random();
    public Product(String name, float price)
    {
        ratings=new ArrayList<>();
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
        this.time=0;
    }
    public boolean setRating(int rating)
    {
        if(rating<1||rating>5)return false;
        ratings.add(rating);
        return true;


    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public float getAvgRating()
    {
        if(ratings.size()==0)return 0;
        float sum_Rate=0;
        for(int i=0;i<ratings.size();i++)
        {
            sum_Rate+=ratings.get(i);
        }
        return Float.parseFloat(String.valueOf(sum_Rate/ratings.size()));

    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String toString(){
        return "Product ID "+this.id+", "+this.name+", RMB "+String.format("%.2f",this.price)+", Rating "+String.format("%.1f",this.getAvgRating());
    }
}
