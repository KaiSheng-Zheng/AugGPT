import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id ;
    private String name;
    private float price;
    private ArrayList<Integer> ratings= new ArrayList<>();

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Product(String name, float price){
       cnt++;
       this.id= cnt;
       this.name = name;
       this.price = price;
      // this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if(rating <= 5 && rating >= 1){
            this.ratings.add(rating);
            return true;
        }
        return false;
//        if( rating>5|| rating<1)
//            return false;
//        else
//            this.ratings.add(rating);
//        return true;
    }

    public float getAvgRating(){
        float total = 0.0f;
        if(ratings.size()==0) return 0.0f;
        for (Integer rating : ratings) {
            total = total + (float) rating;
        }
        float v;
        DecimalFormat f = new DecimalFormat("##0.0");
        v =Float.parseFloat(f.format(total / ratings.size()));
        //v = total / ratings.size();
        return v;
    }


    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
