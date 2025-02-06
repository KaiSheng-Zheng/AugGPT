
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String name;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name,float price){this.name=name;this.price=price;ratings=new ArrayList<>();
        id++;cnt++; this.id=this.cnt;this.cnt=cnt;}
    public boolean setRating(int Rating){
        if (Rating>=1&&Rating<=5){return ratings.add(Rating);}
    else {return false;}
    }
    public float getAvgRating(){
        float sum=0f;
        if (ratings.size()==0){return 0f;}
        else {for (int i=0;i<ratings.size();i++){sum=sum+ratings.get(i);}
        float result=(float) sum/ratings.size();
        return result;}
    }
    public String toString(){

        String discription="Product ID "+String.valueOf(id)+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
        return discription;
    }
}
