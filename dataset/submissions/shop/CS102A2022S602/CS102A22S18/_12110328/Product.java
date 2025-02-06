import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private final int id;
    private final String name;
    private final float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Store store;
    public int purchasetime=0;

    public Product(String name,float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }

    public void setId(int id) {
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else return false;
    }

    public float getAvgRating(){
        int sum=0;
        for(int i=0;i<ratings.size();i++){
            sum+=ratings.get(i);
        }
        float avg=(sum*1.0f)/(ratings.size()*1.0f);
        return avg*1.0f;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
    public int getId(){
        return id;
    }
    public float getPrice(){
        return price;
    }

    public ArrayList<Integer> getRatings(){
        return ratings;
    }
    public Store getStore(){return store;}
}
