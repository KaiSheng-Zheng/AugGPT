import java.util.ArrayList;
import java.text.DecimalFormat;


public class Product {

    public float npric(){
            return this.price;
        }

    public boolean equals(Object wu)
    {
        if (wu.getClass()!=this.getClass())
            return false;
        else {
            Product product= (Product)wu;
            return product.id== this.id;
        }

    }

    private int id;
    private String name;
    private float price;
    private static int cnt=0;
    private ArrayList<Integer> ratings = new ArrayList<>();

    DecimalFormat caidan =new DecimalFormat("0.00");
    DecimalFormat pingjun =new DecimalFormat("0.0");
    public Product(String name, float price)
    {
        this.price = price;
        this.name = name;

        Product.cnt++;
        this.id = Product.cnt;





    }
    public boolean setRating(int rating)
    {
        if (rating>5||rating<1)
            return false;

        return this.ratings.add(rating);
    }


    public float getAvgRating()
    {
        float he=0;

        if (this.ratings.size()==0)
            return 0.0f;

        for (int zs : this.ratings)
        {
            he+=zs;
        }


        return he/this.ratings.size();
    }


    public String toString()
    {


         String shuchu = String.format("Product ID %d, %s, RMB %.2f, Rating ", id,name,price);
        if (this.ratings.size() == 0)
            shuchu += "0.0";
        else
        {
            shuchu +=pingjun.format(this.getAvgRating());
        }

        return shuchu;
    }
}