import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        float sum=0;
        if(ratings.size()==0){
            return 0;
        }else {
            for (int i=0;i<ratings.size();i++){
                sum+=ratings.get(i);
            }
            return sum/ratings.size();
        }
    }
    public String toString(){
        String i="";
        DecimalFormat decimalFormat=new DecimalFormat(".00");
        DecimalFormat decimalFormat1=new DecimalFormat(".0");
          if(getAvgRating()==0){
            i+="Product ID "+id+", "+name+", "+"RMB "+decimalFormat.format(price)+", Rating "+0.0;
            return i;
        }else {
            i+="Product ID "+id+", "+name+", "+"RMB "+decimalFormat.format(price)+", Rating "+decimalFormat1.format(getAvgRating());
            return i;
        }
        
    }

    public float getPrice(){
        return this.price;
    }
//    @Override
//    public int compareTo(Product product){
//        int i;
//        if(this.price-product.getPrice()>0){
//            return 1;
//        }else if(this.price-product.getPrice()<0){
//            return -1;
//        }else {
//            return 0;
//        }
//    }








}



