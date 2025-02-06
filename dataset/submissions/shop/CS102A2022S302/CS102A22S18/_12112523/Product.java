import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id=0;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();


    public Product(String name, float price){
        this.id=cnt+1;
        cnt++;
        this.name=name;
        this.price=price;
    }

    public boolean setRating(int rating){
        if(rating<1||rating>5){
            return false;
        }
        else {
            ratings.add(rating);
            return true;
        }
    }

    public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }
        float result = 0;
        for (int i = 0; i < ratings.size(); i++) {
            result+=ratings.get(i);
        }
        result=result/ratings.size();
        return result;
    }


    //Product ID id, name, RMB price, Rating average-rating
    public String toString(){
        String result=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return result;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

}
