import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt+=1;
        this.id=cnt;
        this.ratings=new ArrayList<Integer>();
    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }

    public float getAvgRating(){
        float total=0;
        for(int i=0;i<ratings.size();i++){
            total+=ratings.get(i);
        }
        if(ratings.size()==0){
            return 0;
        }
        else {
            float avg=total/ratings.size();
            return avg;
        }
    }

    public String toString(){
        String product = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return product;
    }

    public float getPrice() {
        return this.price;
    }
}