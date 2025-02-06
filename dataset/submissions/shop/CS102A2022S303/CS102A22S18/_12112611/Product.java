import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.


    public int getId() {
        return id;
    }

    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }

    public boolean setRating(int rating){
        if(rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }else return false;

    }
    public float getAvgRating(){
        int a=0;
        if (ratings.size()==0){
            return 0;
        }
        else {
            for(int i=0;i<ratings.size();i++) {
            a = a + ratings.get(i);
        }return 1.0f * a/ratings.size();
        }
    }
    public float getAvgRating1(){
        float a=0;
        if (ratings.size()==0){
            return 0;
        }
        else {
            for(int i=0;i<ratings.size();i++) {
                a = a + ratings.get(i);
            }return a/ratings.size();
        }
    }

    public String toString(){
        float i=getAvgRating();
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,i);
    }

    public float getPrice() {
        return price;
    }

}

