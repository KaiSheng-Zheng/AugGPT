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
        if (rating>=1&&rating<=5){ratings.add(rating);return true;}
        else {return false;}
    }
    public float getAvgRating(){
        float x=0;
        for (Integer rating : ratings) {
            x += rating;
        }
        if (ratings.size()==0){return 0;}
        else {return x/ratings.size();}
    }
    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

