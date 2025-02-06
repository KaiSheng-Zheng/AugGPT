import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>();
    private Store storefrom;
    private int purchasetime;
    public Product(String name, float price)
    {
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public void setPurchasetime(int time)
    {
        purchasetime=time;
    }
    public int getPurchasetime()
    {
        return purchasetime;
    }
    public void setStorefrom(Store store)
    {
        storefrom=store;
    }
    public Store getStorefrom()
    {
        return storefrom;
    }
    public boolean setRating(int rating)
    {
        if(rating>=1&&rating<=5)
            ratings.add(rating);
        else
            return false;
        return true;
    }
    public float getAvgRating()
    {
        float out=0;
        if(ratings.isEmpty())
            return out;
        int sum=0;
        for (int i = 0; i < ratings.size(); i++) {
            sum+=ratings.get(i);
        }
        out=((float)sum)/ratings.size();
        return out;
    }
    public String toString()
    {
        NumberFormat formatter2 = new DecimalFormat("0.00");
        NumberFormat formatter1 = new DecimalFormat("0.0");
        String out="";
        out="Product ID "+id+", "+name+", RMB "+formatter2.format(price)+", Rating "+formatter1.format(getAvgRating());
        return out;
    }
    public float getPrice()
    {
        return price;
    }
    public float getPrice2()
    {
        int price2=(int)(100*price);
        return ((float)price2)/100;
    }
}
