import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class Product {
    private static int cnt=0;

    public int getId() {
        return id;
    }

    private int id;
//int op1;
    private String name;

    public Store getSd() {
        return sd;
    }

    public void setSd(Store sd) {
        this.sd = sd;
    }

    private Store sd;



    public float getPrice() {
        return price;
    }
    private float price;
//float lp;

    float avg=0;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price){
        this.price=price;
        this.name=name;
        cnt++;
        id=cnt;
    }
    public boolean setRating(int rating){
      if(rating==1||rating==2||rating==3||rating==4||rating==5) {
          ratings.add(rating);
      return true;}
      else
          return false;
    }
    public float getAvgRating(){
        int avg1=0;
        if(ratings.size()==0)
            return 0;
        else {
        for(int i=0;i<ratings.size();i++)
    avg1+=ratings.get(i);
        float lp1=(float)avg1;
        avg=lp1/ratings.size();
        return avg;}
    }
    public String toString(){
        String A;
        A="Product ID "+id+", "+name+", RMB "+String.format("%.2f, Rating %.1f",price,getAvgRating());
        return A;
    }
}
   
  