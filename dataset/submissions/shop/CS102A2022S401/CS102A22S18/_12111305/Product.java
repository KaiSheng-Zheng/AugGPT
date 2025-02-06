import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private int time;


    public Product(String name,float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }


    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public void setTime(int time){
        this.time=time;
    }


    public float getPrice(){
        return price;
    }
    public int getId(){
        return id;
    }
    public int getTime() {return time;}
    public float getAvgRating(){
        if(ratings.size()==0){
            return 0;
        }
        else{
            int sum=0;
            for (Integer rating : ratings) {
                sum += rating;
            }
            return (float) sum/(float) ratings.size();
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
