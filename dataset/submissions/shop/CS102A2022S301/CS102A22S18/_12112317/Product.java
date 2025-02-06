import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name,float price){
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();

    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }

    public float getAvgRating(){
        float result = 0;
        float total = 0;

        for (int i = 0; i <=ratings.size()-1 ; i++) {
            total+=ratings.get(i);
        }
        if(ratings.size()!=0){
            result = total/ratings.size();
        }else{
            result = 0;
        }
        return result;
    }

    public String toString(){
        return "Product ID "+ id+", "+ name+", "+"RMB "+String.format("%.2f",price)+", "+"Rating "+ String.format("%.1f",getAvgRating());

    }

    public int getId(){
        return id;
    }

    public float getPrice(){
        return price;
    }



}
