import java.text.DecimalFormat;
import java.util.ArrayList;
public class Product implements Comparable<Product>{
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    private Store store;

    public Product (String name, float price){
        cnt++;
        id = cnt;
        this.name=name;
        this.price=price;}


    public int getId (){
        return id;
    }
    public int getCnt (){return cnt;}
    public String getName  (){return name;}
    public float getPrice (){return price;}
    public ArrayList<Integer> getRatings (){return ratings;}

    public Store getStore (){return store;}
    public void setStore (Store store){this.store =store;}


    public boolean setRating(int rating){
        ArrayList <Integer> ratings = getRatings();
        if(rating>=1 && rating<=5){
            ratings.add(rating);
            this.ratings = ratings;
            return true;}
        else{
            return false;}}


    public float getAvgRating(){
        ArrayList <Integer> ratings = getRatings();
        int sum=0;
        float avgRating;
        int size = ratings.size();

        for (Integer rating : ratings) {
            sum = sum + rating;}

        if(size==0){
            avgRating=0;}
        else{
            avgRating=(float)  sum/size ;}
        return avgRating ;}

    public float avgRating = getAvgRating();


    @Override
    public String toString(){
        float avgRating;
        float price;
        avgRating= getAvgRating();
        price= getPrice();

        String format1 = new DecimalFormat("#0.0").format(avgRating);
        String format2 = new DecimalFormat("#0.00").format(price);
        return "Product ID " + id + ", " + name + ", " + "RMB " + format2 + ", " + "Rating " + format1;
    }


    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
