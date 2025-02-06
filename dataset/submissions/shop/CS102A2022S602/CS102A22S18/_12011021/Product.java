import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price){
        cnt=cnt+1;
        id=cnt;
        this.name=name;
        this.price=price;
    }

    public boolean setRating(int rating){
        if((rating<1)|(rating>5)){
            return false;
        }else {
            this.ratings.add(rating);
            return true;
        }
    }

    public float getAvgRating(){
        float avgRating=0;
        int sum=0;
        if(ratings.size()>0) {
            for (int i = 0; i < ratings.size(); i++) {
                sum = sum + ratings.get(i);
            }
            avgRating = ((float) sum) / ((float) ratings.size());
            return avgRating;
        }else {
            return 0;
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
    }

    public String getName(){
        return this.name;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }
}