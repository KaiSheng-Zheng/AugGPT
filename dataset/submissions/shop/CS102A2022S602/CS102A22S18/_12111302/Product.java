import java.util.ArrayList;

public class Product {
    private static int cnt=1; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    public Store store;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price)
    {
        this.name=name;this.price=price;
        this.id=cnt;
        cnt++;
    }
    public boolean setRating(int rating)
    {
                 if(rating>=1&&rating<=5)
                 {
                     ratings.add(rating);  return true;
                 }
                 else  return false;
    }

    public float getAvgRating()
    {   if(ratings.size()==0) return 0;
        float sum=0;
        for(int i=0;i<ratings.size();i++)
        {
            sum+=(float)ratings.get(i);
        }
        String s = String.format("%.7f", sum/ratings.size());
        float v = Float.parseFloat(s);
        return v;
    }
    public float getPrice()
    {
        return this.price;
    }
    public String toString()
    {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

}
