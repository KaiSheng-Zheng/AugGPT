import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    private float average=0;

    public Product(String name, float price){
        cnt+=1;
        id=cnt;
        this.name=name;
        this.price=price;
    }

    public boolean setRating(int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5){
            ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }
    public float getAvgRating(){
        float all = 0;
        if (ratings.size()!=0) {
            for (int i = 0; i < ratings.size(); i++) {
                all += ratings.get(i);
            }
            average = all / ratings.size();
        }
        return average;
    }
    public String toString(){
        return "Product ID " +id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",average);
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}