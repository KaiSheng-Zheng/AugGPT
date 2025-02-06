import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private float average;
    public Product(String name,float price){
        cnt+=1;
        id=cnt;
        this.name = name;
        this.price = price;
    }
    public boolean setRating(int rating){
        if(rating==1||rating==2||rating==3||rating==4||rating==5){
            ratings.add(rating);
            return true;}
        else{
            return false;
        }
    }
    public float getAvgRating() {
        float all = 0;
        if (ratings.size() != 0) {
            for (int i = 0; i < ratings.size(); i++) {
                all += ratings.get(i);
            }
            average = all / ratings.size();
        }
        if (ratings.size() == 0) {
            average = 0;
        }
        return average;
    }
    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",average);
    }
    public String getName(){return name;}
    public float getPrice(){return price;}


}
