import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println((float)Math.round(((float) 17/4)*10)/10);
    }
    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public float getPrice(){
        return price;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public boolean setRating(int rating){
        if (rating == 1||rating == 2||rating == 3||rating == 4||rating == 5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }

    public float getAvgRating(){
        if (ratings.isEmpty()){
            return (float) 0.0;
        }else{
            int sum = 0;
            for (Integer rating : ratings) {
                sum += rating;
            }
            return (float) sum/ratings.size();
        }
    }

    public String toString(){
        float avgRate = (float)Math.round(getAvgRating()*10)/10;
        float pri = (float)Math.round(price*100)/100;
        return String.format("Product ID " + "%d" +", "+ "%s" + ", RMB " + "%.2f" + ", Rating " + "%.1f",id,name,pri,avgRate);
    }
}