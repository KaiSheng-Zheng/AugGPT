import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        this.name=name;this.price=price;
        cnt++;id=cnt;
    }
    public boolean setRating(int rating){
        boolean e;
        if (rating==1||rating==2||rating==3||rating==4||rating==5){ratings.add(rating);e=true;}
        else {e=false;}
        return e;
    };
    public float getAvgRating(){
        float t=0;float av;
        if (ratings.size()==0){av=0;}
        else {for (int i = 0; i < ratings.size(); i++) {
            t+=ratings.get(i);
        }
        av=t/ratings.size();}
        return av;
    };
    public String toString(){
        String w=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return w;
    };

    public int getId() {
        return id;
    }
    public float getPrice() {
        return price;
    }
}