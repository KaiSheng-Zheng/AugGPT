import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.

    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    public Store RNM;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id=cnt;
    }

    public float getPrice() {
        return price;
    }


    public boolean setRating(int rating){
        if(rating>0&&rating<6){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        float sum =0;
        float average;
        if (ratings.size()==0){
            return 0;
        }
        for (int i = 0;i<ratings.size();i++){
            sum+=ratings.get(i);
        }
        average=sum/ratings.size();
        return average;
    }
    public String toString(){
//        String s = "Product ID " + id + ", " + name + ", RMB " + String.format("%.2f", price) + ", Rating " + String.format("%.1f",getAvgRating());
//        return s;
        String s = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f" ,id,name,price,getAvgRating());
        return s;
    }
}
