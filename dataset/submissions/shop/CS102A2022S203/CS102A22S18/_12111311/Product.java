import java.util.ArrayList;

public class Product
{
    private static int cnt;
    private static int time;
    private int purchaseTime;
    private int id; 
    private String name;
    private float price;
    private Store from;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name,float price)
    {
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }

    public boolean setRating(int rating)
    {
        if(rating>5||rating<1)
            return false;
        ratings.add(rating);
        return true;
    }

    public void setStore(Store store)
    {
        from=store;
    }

    public void setPurchaseTime()
    {
        time++;
        purchaseTime=time;
    }

    public float getAvgRating()
    {
        int s=ratings.size();
        if(s==0)
            return 0f;
        float x=0f;
        for(int i=0;i<s;i++)
            x+=ratings.get(i);
        return x/s;
    }

    public String toString()
    {
        return "Product ID "+String.valueOf(id)+", "+name+", RMB "+
                String.format("%.2f",price)+
               ", Rating "+String.format("%.1f",getAvgRating());
    }

    public int getId()
    {
        return id;
    }

    public float getPrice()
    {
        return price;
    }

    public int getPurchaseTime()
    {
        return purchaseTime;
    }

    public Store getStore()
    {
        return from;
    }
}
