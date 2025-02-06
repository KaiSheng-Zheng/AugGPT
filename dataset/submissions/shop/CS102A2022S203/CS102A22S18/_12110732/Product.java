import java.util.ArrayList;
public class Product {
    private int id;
    private String name;
    private static int cnt = 0;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public boolean setRating(int rating)
    {
        boolean result = false;
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5)
        {
            result = true;
            ratings.add(rating);
        }
        return result;
    }
    public Product(String name, float price)
    {
        this.name = name;
        this.price = price;
        cnt++;
        this.id=cnt;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Integer> getRatings() {
        return ratings;
    }
    public float getPrice() {
        return price;
    }
    public int getId(){
        return id;
    }
    public float getAvgRating()
    {
        float s =0;
        float avg = 0;
        if (ratings.size()!=0)
        {
            for (int i=0;i<ratings.size();i++)
            {
                s += ratings.get(i);
                avg =s/ratings.size() ;
            }
        }else if (ratings.size()==0)
        {
            avg=0;
        }
        return avg;
    }
    public String toString()
    {
        String result=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
        return  result;
    }
}