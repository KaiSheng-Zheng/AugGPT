import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product
{
    private static int cnt;
    private int id ;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private int count=0;

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Product(String name, float price)
    {
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public boolean setRating(int rating)
    {
        if(rating>=1&&rating<=5)
        {
            ratings.add(rating);
            return true;
        }
        else
        {
            return false;
        }

    }
    public float getAvgRating()
    {
        int l = ratings.size();
        float sum = 0;
        float avg = 0;
        for(int i=0;i<l;i++)
        {
            sum+= ratings.get(i);
        }
        if(l!=0){
            avg = sum/l;
        }
        return avg;
    }
    @Override
    public String toString()
    {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        DecimalFormat decimalFormat0 = new DecimalFormat("0.0");
        float price2 = (float) Math.round(price*100)/100;
        String strPrice = decimalFormat.format(price2);
        float avgRating = (float) Math.round(getAvgRating()*10)/10;
        String strRating = decimalFormat0.format(avgRating);
        String str = "Product ID "+id+", "+name+", RMB "+strPrice+", Rating "+strRating;
        return str;
    }
}
