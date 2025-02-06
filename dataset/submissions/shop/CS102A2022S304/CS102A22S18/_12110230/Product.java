import java.util.ArrayList;

public class Product
{
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price)
    {
        this.name=name;
        this.price=price;
        ratings=new ArrayList<>();
        cnt++;
        this.id=cnt;
    }

    public boolean setRating(int rating)
    {
        if(rating<=5 && rating>=1)
        {
            ratings.add(rating);
            return true;
        }
        else return false;
    }

    public float getAvgRating()
    {
        float output=0.0f;
        if (ratings.size()==0)
        {
            return 0.0f;
        }
        for (int i=0;i<ratings.size();i++)
        {
            output +=ratings.get(i);
        }
        output=output/ratings.size();
        output=(float)(Math.round(output*10))/10.0f;
        return output;
    }

    @Override
    public String toString()
    {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public float getPrice() {
        return price;
    }
}