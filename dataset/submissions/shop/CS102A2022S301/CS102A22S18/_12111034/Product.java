import java.text.DecimalFormat;
import java.util.ArrayList;
public class Product {

    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id=0; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    ArrayList<Integer> arr =new ArrayList<>();

    private  ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }


    public boolean setRating(int rating){

        if (rating==1||rating==2||rating==3||rating==4||rating==5){
           ratings.add(rating);
            //ratings=arr;
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        float sum=0;
        float avgRating;
        if (ratings.size()!=0){
        for (int i=0;i<ratings.size();i++){
            sum =sum+ratings.get(i);
        }
        avgRating=sum/ratings.size();
        return avgRating;}
        else return 0;
    }
    public String toString(){
        DecimalFormat df =new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0.0");
        int id1=id;
        String.valueOf(id1);
        return String.format("Product ID %d, %s, RMB %s, Rating %s",id,name,df.format(price),df2.format(getAvgRating()));
         //return  "Product ID "+id+","+" "+name+", RMB"+" "+df.format(price)+", Rating"+" "+df2.format(getAvgRating());
        //return "Product ID "+id+", Laptop, RMB "+df.format(price)+", Rating "+df2.format(getAvgRating());
        //return String.format("Product ID %d, %s, RMB %s, Rating %s",id,name,df.format(price),df2.format(getAvgRating()));
         //return "Product ID "+id+", Laptop, RMB "+df.format(price)+", Rating "+df2.format(getAvgRating());
    }
    public float getPrice(){
        return price;
    }


    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
}

    
 