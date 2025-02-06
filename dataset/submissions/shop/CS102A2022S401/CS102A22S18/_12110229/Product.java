import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name,float price){
        this.name=name;
        this.price=price;
        cnt+=1;
        this.id=cnt;
    }

    public boolean setRating(int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5){
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }else {
            float num=0;
            for (int i=0;i<ratings.size();i++){
                num+=ratings.get(i);
            }
            return num/ratings.size();
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
    }

    public float getPrice(){
        return price;
    }
}
