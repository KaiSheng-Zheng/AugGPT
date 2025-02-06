import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private int time;
    //private Random random=new Random();
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
        //System.out.println(2222);
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
        float sum=0;
        for(int x:ratings)
        {
            sum+=x;
        }
        return Float.parseFloat(String.valueOf(sum/ratings.size()));
        //return Float.parseFloat(String.format("%.1f",sum*1.0/ratings.size()));

    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String toString(){
        return "Product ID "+this.id+", "+this.name+", RMB "+String.format("%.2f",this.price)+", Rating "+String.format("%.1f",this.getAvgRating());
        //return "Product ID "+this.id+", "+this.name+", RMB "+String.format("%.2f",this.price)+", Rating "+getAvgRating();
    }
}
