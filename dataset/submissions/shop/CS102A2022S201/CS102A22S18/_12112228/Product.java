import java.util.ArrayList;

public class Product {
    private static int cnt =0 ;
    private int id;
    private String name;
    private float price;
    private float average;
    private ArrayList<Integer> ratings =new ArrayList<>();
    public Product(String name, float price){
        this.name =name;
        this.price =price;
        cnt +=1;
        id =cnt;
    }
    public boolean setRating(int rating){
        boolean result = false;
        if(rating<=5&&rating>=0){
            ratings.add(rating);
            result =true;
        }
        return result;
             }
    public float getAvgRating(){
       float average =0;
          for(int i = 0 ; i < ratings.size();i++){
                 average =average+ratings.get(i);
        }
          average= average/ratings.size();
          return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public String toString(){
        String result = null;
        result = "Product ID " +String.format("%d",id)+", "+ name+", "+"RMB " +String.format("%.2",price)
                +", "+ "Rating "+String.format("%.1f",getAvgRating());
        return result;
    }

    public static int getCnt() {
        return cnt;
    }
    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }
    public float setPrice(float price){
        return this.price=price;
    }
}
