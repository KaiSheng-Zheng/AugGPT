import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price){
        cnt++;
        id=cnt;
        this.name=name;this.price=price;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            boolean setRating=true;this.ratings.add(rating);
            return setRating;
        }else {
            boolean setRating=false;

        return setRating;
        }
    }

    public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }else {int sum=0;
            for (int i=0;i<ratings.size();i++){
                sum+=ratings.get(i);
            }
            DecimalFormat df=new DecimalFormat("0.0");
        return Float.parseFloat(df.format((float)sum/ratings.size()));

        }

    }
    public String toString(){
        StringBuilder D=new StringBuilder();
        DecimalFormat Price=new DecimalFormat("0.00");
        DecimalFormat Rating=new DecimalFormat("0.0");
        D.append("Product ID "+id+", ");
        D.append(name);
        D.append(", RMB "+Price.format(price));
        D.append(", Rating "+Rating.format(getAvgRating()));
        String toString=D.toString();
        return toString;

    }
    public  String getName(){
        return name;
    }

    public float getPrice() {
       return price;
    }
}
