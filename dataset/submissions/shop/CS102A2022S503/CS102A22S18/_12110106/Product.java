import java.text.DecimalFormat;
import java.util.ArrayList;
public class Product {
    private static int cnt=0;
    // initialized to 0, and will increase by 1 when the constructor is called.
private int id;
// unique for each product and the value is set to cnt.
private String name;
private float price;
private ArrayList<Integer> ratings= new ArrayList<>();
// ratings from different customers; default is empty.










    public Product(String name, float price){
        this.name = name;
        this.price = price;
        Product.cnt++;
        this.id = Product.cnt;
    }


    //method setRating
    public boolean setRating(int rating) {
        if (rating < 1) {
            return false;
        } else if (rating > 5) {
            return false;
        } else if (1 <= rating && rating <= 5) {
            return ratings.add(rating);
        }
    else return ratings.add(rating);
    }

//method getAvgeRating
    public float getAvgRating(){
        double sum=0;
        for(int rating:this.ratings){
            sum=sum+rating;
        }
        float AvgRating;
        AvgRating= (float) (sum/this.ratings.size());
       if(this.ratings.size()==0){
           return (float)0.0;
       }else return AvgRating;
    }

    //method toString wrong!
    public String toString(){
        String result;
        DecimalFormat pricePrice= new DecimalFormat("0.00");
        DecimalFormat newAverageRating= new DecimalFormat("0.0");
        String result2;
        if(this.ratings.size()==0){
            result2="0.0";
        }else{
            result2=newAverageRating.format(this.getAvgRating());
        }
        result="Product ID"+this.id+","+"RMB"+pricePrice.format(this.price)+","+"Rating"+result2;
        return result;
    }



    public float getPrice(){
        return price;
    }
}
