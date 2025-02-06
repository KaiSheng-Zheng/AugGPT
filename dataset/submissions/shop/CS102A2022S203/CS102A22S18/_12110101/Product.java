import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    public Product(String name, float price){
      this.id=Product.cnt;
      this.price=price;
      this.name=name;
    }
    public boolean setRating(int rating){
        if(rating==1&&rating==2&&rating==3&&rating==4&&rating==5)
           return this.ratings.add(rating);
        else
            return false;

    }
    public float getPrice(){
        return this.price;
    }
    public float getAvgRating(){
        float b=0;
        for (int a:this.ratings)
            b+=a;
        return  b/this.ratings.size();

    }
    public String toString(){
        return "Product ID "+this.id+", "+this.name+", RMB"+String.format("%.public String toString();2f",this.price)+", Rating "+String.format("%.1f",this.getAvgRating());
    }



}