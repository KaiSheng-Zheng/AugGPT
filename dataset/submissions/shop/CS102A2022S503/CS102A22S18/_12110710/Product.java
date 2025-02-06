import java.util.ArrayList;

public class Product {
    private static int cnt;// initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.


    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        Product.cnt++;
        id=cnt;
        ratings=new ArrayList<>();
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
        float answer=0;
        if(ratings.size()!=0) {
            for(int k=0;k<ratings.size();k++){
                answer+=(float) ratings.get(k);
            }
            answer = answer / ratings.size();
            return answer;
        }
        else {
            return 0;
        }
    }

    public float getPrice(){
        return price;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price,getAvgRating());
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}