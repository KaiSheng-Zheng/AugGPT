import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int time;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>();
    public String getName()
    {
        return name;
    }
    public int getTime()
    {
        return time;
    }
    public void setTime(int time)
    {
        this.time=time;
    }
    public int getId()
    {
        return id;
    }
    public float getPrice()
    {
        return price;
    }
    public Product(String name,float price)
    {
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating)
    {
        if(rating>=1 && rating<=5) {
            ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating()
    {
        if(ratings.size()==0) return 0;
        float sum=0;
        for(int i=0;i<=(ratings.size()-1);i++)
        {
            sum+=ratings.get(i);
        }
        return sum/ratings.size();
    }
    public String toString()
    {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
