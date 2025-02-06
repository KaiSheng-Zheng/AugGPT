import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name,float price){
        cnt++;
        id =cnt;
        this.name =name;
        this.price =price;

    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getPrice(){
        return price;
    }
    public float getAvgRating(){
        float sum =0;
        float AvgRating =0;
        if (ratings.size() ==0){
            return 0;
        }else {
            for (int i=0;i <ratings.size();i++){
                sum =sum +ratings.get(i);
            }
            AvgRating = sum/ratings.size();
        }
        return getAvgRating();
    }
    public String toString(){
        String Ratings = String.format("%.1f",this.getAvgRating());
        String Price =String.format("%.2f",this.getPrice());
        return " Product ID" + id + "," +name +", RMB "+Price+",Ratings"+ Ratings;

    }


}
