import java.util.ArrayList;

public class Product{
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt++;
        this.name=name;
        this.price=price;
        id=Integer.valueOf(cnt);
    }
    public boolean setRating(int rating){
        boolean valid=true;
        if (rating<=5&&rating>=1){
            this.ratings.add(rating);
        }else {
            valid=false;
        }
        return valid;
    }

    public float getAvgRating(){

        int sum=0;
        if (ratings.size()==0){
            return 0;
        }else {
            for (int i=0;i<ratings.size();i++){
                sum=sum+ratings.get(i);
            }
            return (float)sum/ratings.size();
        }
    }
    public String toString(){
        return String.format("Product ID "+id+", "+name+", RMB %.2f"+", Rating %.1f",price,getAvgRating());
    }

    public float getPrice(){
        return price;
    }

    public int getId(){
        return id;
    }
}
