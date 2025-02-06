import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;//let cnt be a number that reflects id
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

//define product
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
    }
//set ratings
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            return ratings.add(rating);
        }
        else{
            return false;
        }
    }

    public int getId() {
        return id;
    }

    //average
    public float getAvgRating(){
        float sum=0;
        float average;
        if(ratings.size()!=0) {
            for (int i = 0; i < ratings.size(); i++) {
                sum = sum + ratings.get(i);
            }
            average=sum/ratings.size();
        }
        else{
            average=0;
        }
        return average;
        }
//get price
    public float getPrice() {
        return price;
    }
//tostring
    public String toString(){
        DecimalFormat r = new DecimalFormat("0.0");
        DecimalFormat p = new DecimalFormat("0.00");
        String result = "Product ID " + this.id+ ", " + this.name + ", RMB " + p.format(this.price) + ", Rating "+r.format(getAvgRating());
        return result;
    }


}
