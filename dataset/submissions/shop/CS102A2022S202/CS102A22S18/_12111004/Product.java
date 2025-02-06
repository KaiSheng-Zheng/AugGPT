import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        cnt++;
        id=cnt;
        this.name=name;
        this.price=price;
    }

    public float getPrice() {
        return price;
    }



    public boolean setRating(int rating){
        if(rating<=5&&rating>=1){
            ratings.add(rating);return true;
        }
        else return false;
    }

    public float getAvgRating(){
        int size=ratings.size();
        float total=0;int m;
        for (Integer rating : ratings) {
            m = rating;
            total = total + m;
        }
        return total/((float) size);
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
