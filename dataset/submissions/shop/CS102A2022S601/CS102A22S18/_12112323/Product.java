import java.text.DecimalFormat;
import java.util.ArrayList;
public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
    public Product(String name, float price){
this.name=name;
this.price=price;
setCnt(getCnt()+1);
setId(getCnt());
this.ratings=new ArrayList<>();
    }
    public boolean setRating(int rating){
        if (1<=rating&rating<=5){
            this.ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public float getAvgRating(){
       float a = 0;
        for (int b = 0;b<ratings.size();b++){
            a+=ratings.get(b);
        }
        if (ratings.size()==0){
            float b = 0;
            return b;
        }else {
        float b =(a/ratings.size());
       return b;
        }
    }
    public String toString(){
        DecimalFormat yyc = new DecimalFormat("#.00");
        DecimalFormat zcy = new DecimalFormat("#.0");
        float b =Math.round(getAvgRating() * 10) / 10f;

       StringBuilder list = new StringBuilder();
       list.append("Product ID");
        list.append(" ");
        list.append(this.getId());
        list.append(", ");
        list.append(this.getName());
        list.append(", ");
        list.append("RMB ");
        if (price==0){
            list.append("0.00");
        }
        else {
        list.append(yyc.format(price));}
        list.append(", ");
        list.append("Rating ");
        if (getAvgRating()==0){
            list.append("0.0");
        }
        else {
        list.append(zcy.format(b));
        }
        return String.valueOf(list);

    }
}
