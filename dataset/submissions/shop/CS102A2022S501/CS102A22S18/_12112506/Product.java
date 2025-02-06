import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer>ratings=new ArrayList<>();
    public float getPrice() {
        return price;
    }
    public Product(String name, float price){
        ++cnt;
        id=cnt;
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public boolean setRating(int rating){
        if(rating<1||rating>5)return false;
        ratings.add(rating);
        return true;
    }
    public float getAvgRating(){
        float avg=0f;
        int len=ratings.size();
        if(len==0)return avg;
        for(int i=0;i<len;i++) {
            avg += (float) ratings.get(i);
        }
        avg=avg/(float) len;
        return avg;
    }
    public static String Dig1(float value){
        BigDecimal val = new BigDecimal(value);
        val = val.setScale(1, RoundingMode.HALF_UP);
        return val .toString();
    }
    public static String Dig2(float value){
        BigDecimal val=new BigDecimal(value);
        val=val.setScale(2,RoundingMode.HALF_UP);
        return  val.toString();
    }
    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+Dig2(price)+", Rating "+Dig1(getAvgRating());
    }
    public boolean equal(Product compPr){
        return id==compPr.id;
//        if(id==compPr.id&& Objects.equals(name, compPr.name) &&price==compPr.price){
//            boolean check=true;//when ID the same, two product the same(?)
//            int len1=ratings.size();
//            int len2=compPr.ratings.size();
//            if(len1==0&&len2==0)return true;
//            else if(len1!=len2)return false;
//            for(int i=0;i<len1;i++){
//                if(ratings.get(i)!=compPr.ratings.get(i)){
//                    check=false;
//                    break;
//                }
//            }
//            return check;
//        }
//        return false;
    }
}
