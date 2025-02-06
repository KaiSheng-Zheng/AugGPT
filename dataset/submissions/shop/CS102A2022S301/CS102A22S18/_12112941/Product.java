import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
    }
    public boolean setRating(int rating){
        if (rating<=5&&rating>=1) {
            this.ratings.add(rating);
            return true;
        }
        else
            return false;
    }
    public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }
        int sum=0;
        for (int i = 0; i < this.ratings.size(); i++) {
            sum+=this.ratings.get(i);
        }
        float ave=(float) sum/this.ratings.size();
        return ave;
    }
    public float getPrice(){
        return price;
    }

    public String toString(){
        String out="";
        DecimalFormat out1=new DecimalFormat("0.00");
        DecimalFormat out2=new DecimalFormat("0.0");
        out="Product ID "+this.id+", "+this.name+", RMB "+ out1.format(price)+", Rating "+out2.format(this.getAvgRating());
        return out;

    }
    public boolean equals(Object o){
        if (o==null||this==null){
            return false;
        }
        else {
            Product os=(Product) o;
            if (this.id==os.id)
                return true;
            else
                return false;
        }
    }
}
