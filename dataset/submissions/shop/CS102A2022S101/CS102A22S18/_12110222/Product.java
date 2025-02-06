import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private float price;
    private int id;
    private String name;
    private ArrayList<Integer> ratings =new ArrayList<>();

    public float getPrice() {
        return price;
    }

    public Product( String name, float price) {

        this.name = name;
        this.price =price ;
        cnt++;
        this.id = cnt;


    }
    public boolean setRating(int rating){

       if(rating <= 5 && rating >= 1){
           ratings.add(rating);
           return true;
       }
       return false;
    }
    public float getAvgRating(){
        float sum = 0;
        if(ratings.size()==0){return 0;}
        else{
        for (int i = 0; i < ratings.size(); i++) {
            sum+=ratings.get(i);
        }
        return sum/ratings.size();}
    }
    @Override
    public String toString(){
        DecimalFormat dp = new DecimalFormat("0.00");
        DecimalFormat da = new DecimalFormat("0.0");
        return "Product ID "+ id+", "+ name+", "+"RMB "+ dp.format(price)+", " + "Rating "+ da.format(getAvgRating());
    }
}
