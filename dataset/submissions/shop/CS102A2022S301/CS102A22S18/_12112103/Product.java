import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean setRating(int rating){
        switch (rating){
            case 1:{this.ratings.add(rating);return true;}
            case 2:{this.ratings.add(rating);return true;}
            case 3:{this.ratings.add(rating);return true;}
            case 4:{this.ratings.add(rating);return true;}
            case 5:{this.ratings.add(rating);return true;}
            default:return false;
        }
    }

    public float getAvgRating(){
        float sum=0;
        for (int t: ratings) {
            sum+=t;
        }
        if(ratings.size()==0) { return 0;
        }else return sum/ratings.size();
    }

    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
    }

    public float getPrice() {
        return price;
    }
}
