import java.text.DecimalFormat;
import java.util.ArrayList;
public class Product
{
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList();
    private int time;
    Store belong;
    public Product(String name,float price)
    {
        this.name=name;
        this.price=price;
        this.id=++cnt;
    }
    public float getPrice()
    {
        return this.price;
    }
    public ArrayList<Integer> getRatings()
    {
        return this.ratings;
    }
    public int getTime()
    {
        return this.time;
    }
    public void setTime(int time)
    {
        this.time=time;
    }
    public boolean setRating(int rating)
    {
        if(rating<1||rating>5) return false;
        this.ratings.add(rating);
        return true;
    }
    public float getAvgRating()
    {
        int siz=this.ratings.size();
        if(siz==0) return 0;
        float tot=0f;
        for (Integer rating:this.ratings) tot+=rating;
        return tot/siz;
    }
    public String toString()
    {
        DecimalFormat df1=new DecimalFormat(".0");
        DecimalFormat df2=new DecimalFormat(".00");
        String s1="Product ID ";
        String s2=Integer.toString(this.id);
        String s3=", ";
        String s4="RMB ";
        String s5=df2.format(this.price);
        String s6="Rating ";
        String s7=df1.format(getAvgRating());
        if(getAvgRating()==0) s7="0"+s7;
        return s1+s2+s3+this.name+s3+s4+s5+s3+s6+s7;
    }
}
