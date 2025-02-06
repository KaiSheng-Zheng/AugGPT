import java.util.ArrayList;

public class Product {
    //Attributes
    private static int cnt;// initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private final String name;
    private final float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    //Constructor
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        id =cnt;
    }

    //Methods
    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        if (ratings.size() == 0){return 0;}

        int sum = 0;
        for (int x = 0;x<ratings.size();x++){
            sum += ratings.get(x);
        }
        float avgRating =(float) sum/ratings.size();
        return avgRating;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Product ID ").append(id).append(", ");
        sb.append(name).append(", ");
        sb.append("RMB ").append(String.format("%.2f", price)).append(", ");
        sb.append("Rating ").append(String.format("%.1f",getAvgRating()));
        return sb.toString();
    }

    //Setters
    public void setId(int id) {this.id = id;}


    //Getters
    public int getId() {return id;}
    public float getPrice() {return price;}
}
